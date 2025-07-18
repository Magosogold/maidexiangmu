package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ToubiaodanweiEntity;
import com.entity.view.ToubiaodanweiView;

import com.service.ToubiaodanweiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 投标单位
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
@RestController
@RequestMapping("/toubiaodanwei")
public class ToubiaodanweiController {
    @Autowired
    private ToubiaodanweiService toubiaodanweiService;


    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		ToubiaodanweiEntity u = toubiaodanweiService.selectOne(new EntityWrapper<ToubiaodanweiEntity>().eq("toubiaodanwei", username));
		if(u==null || !u.getMima().equals(MD5Util.md5(password))) {
			return R.error("账号或密码不正确");
		}
		String token = tokenService.generateToken(u.getId(), username,"toubiaodanwei",  "投标单位" );
		return R.ok().put("token", token);
	}

	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ToubiaodanweiEntity toubiaodanwei){
    	//ValidatorUtils.validateEntity(toubiaodanwei);
    	ToubiaodanweiEntity u = toubiaodanweiService.selectOne(new EntityWrapper<ToubiaodanweiEntity>().eq("toubiaodanwei", toubiaodanwei.getToubiaodanwei()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		toubiaodanwei.setId(uId);
                toubiaodanwei.setMima(MD5Util.md5(toubiaodanwei.getMima()));
        toubiaodanweiService.insert(toubiaodanwei);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        ToubiaodanweiEntity u = toubiaodanweiService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	ToubiaodanweiEntity u = toubiaodanweiService.selectOne(new EntityWrapper<ToubiaodanweiEntity>().eq("toubiaodanwei", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima(MD5Util.md5("123456"));
        toubiaodanweiService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ToubiaodanweiEntity toubiaodanwei,
		HttpServletRequest request){
        EntityWrapper<ToubiaodanweiEntity> ew = new EntityWrapper<ToubiaodanweiEntity>();

		PageUtils page = toubiaodanweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, toubiaodanwei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ToubiaodanweiEntity toubiaodanwei, 
		HttpServletRequest request){
        EntityWrapper<ToubiaodanweiEntity> ew = new EntityWrapper<ToubiaodanweiEntity>();

		PageUtils page = toubiaodanweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, toubiaodanwei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ToubiaodanweiEntity toubiaodanwei){
       	EntityWrapper<ToubiaodanweiEntity> ew = new EntityWrapper<ToubiaodanweiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( toubiaodanwei, "toubiaodanwei")); 
        return R.ok().put("data", toubiaodanweiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ToubiaodanweiEntity toubiaodanwei){
        EntityWrapper< ToubiaodanweiEntity> ew = new EntityWrapper< ToubiaodanweiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( toubiaodanwei, "toubiaodanwei")); 
		ToubiaodanweiView toubiaodanweiView =  toubiaodanweiService.selectView(ew);
		return R.ok("查询投标单位成功").put("data", toubiaodanweiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ToubiaodanweiEntity toubiaodanwei = toubiaodanweiService.selectById(id);
        return R.ok().put("data", toubiaodanwei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ToubiaodanweiEntity toubiaodanwei = toubiaodanweiService.selectById(id);
        return R.ok().put("data", toubiaodanwei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ToubiaodanweiEntity toubiaodanwei, HttpServletRequest request){
    	toubiaodanwei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(toubiaodanwei);
    	ToubiaodanweiEntity u = toubiaodanweiService.selectOne(new EntityWrapper<ToubiaodanweiEntity>().eq("toubiaodanwei", toubiaodanwei.getToubiaodanwei()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		toubiaodanwei.setId(new Date().getTime());
                toubiaodanwei.setMima(MD5Util.md5(toubiaodanwei.getMima())); 
        toubiaodanweiService.insert(toubiaodanwei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ToubiaodanweiEntity toubiaodanwei, HttpServletRequest request){
    	toubiaodanwei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(toubiaodanwei);
    	ToubiaodanweiEntity u = toubiaodanweiService.selectOne(new EntityWrapper<ToubiaodanweiEntity>().eq("toubiaodanwei", toubiaodanwei.getToubiaodanwei()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		toubiaodanwei.setId(new Date().getTime());
                toubiaodanwei.setMima(MD5Util.md5(toubiaodanwei.getMima()));
        toubiaodanweiService.insert(toubiaodanwei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ToubiaodanweiEntity toubiaodanwei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(toubiaodanwei);
	ToubiaodanweiEntity toubiaodanweiEntity = toubiaodanweiService.selectById(toubiaodanwei.getId());
        if(StringUtils.isNotBlank(toubiaodanwei.getMima()) && !toubiaodanwei.getMima().equals(toubiaodanweiEntity.getMima())) {
                toubiaodanwei.setMima(MD5Util.md5(toubiaodanwei.getMima()));
        }
        toubiaodanweiService.updateById(toubiaodanwei);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        toubiaodanweiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ToubiaodanweiEntity> wrapper = new EntityWrapper<ToubiaodanweiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = toubiaodanweiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
