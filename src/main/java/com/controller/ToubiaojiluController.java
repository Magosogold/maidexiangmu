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

import com.entity.ToubiaojiluEntity;
import com.entity.view.ToubiaojiluView;

import com.service.ToubiaojiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 投标记录
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
@RestController
@RequestMapping("/toubiaojilu")
public class ToubiaojiluController {
    @Autowired
    private ToubiaojiluService toubiaojiluService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ToubiaojiluEntity toubiaojilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhaobiaodanwei")) {
			toubiaojilu.setZhaobiaodanwei((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("toubiaodanwei")) {
			toubiaojilu.setToubiaodanwei((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ToubiaojiluEntity> ew = new EntityWrapper<ToubiaojiluEntity>();

		PageUtils page = toubiaojiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, toubiaojilu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ToubiaojiluEntity toubiaojilu, 
		HttpServletRequest request){
        EntityWrapper<ToubiaojiluEntity> ew = new EntityWrapper<ToubiaojiluEntity>();

		PageUtils page = toubiaojiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, toubiaojilu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ToubiaojiluEntity toubiaojilu){
       	EntityWrapper<ToubiaojiluEntity> ew = new EntityWrapper<ToubiaojiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( toubiaojilu, "toubiaojilu")); 
        return R.ok().put("data", toubiaojiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ToubiaojiluEntity toubiaojilu){
        EntityWrapper< ToubiaojiluEntity> ew = new EntityWrapper< ToubiaojiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( toubiaojilu, "toubiaojilu")); 
		ToubiaojiluView toubiaojiluView =  toubiaojiluService.selectView(ew);
		return R.ok("查询投标记录成功").put("data", toubiaojiluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ToubiaojiluEntity toubiaojilu = toubiaojiluService.selectById(id);
        return R.ok().put("data", toubiaojilu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ToubiaojiluEntity toubiaojilu = toubiaojiluService.selectById(id);
        return R.ok().put("data", toubiaojilu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ToubiaojiluEntity toubiaojilu, HttpServletRequest request){
    	toubiaojilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(toubiaojilu);
        toubiaojiluService.insert(toubiaojilu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ToubiaojiluEntity toubiaojilu, HttpServletRequest request){
    	toubiaojilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(toubiaojilu);
        toubiaojiluService.insert(toubiaojilu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ToubiaojiluEntity toubiaojilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(toubiaojilu);
        toubiaojiluService.updateById(toubiaojilu);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        toubiaojiluService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ToubiaojiluEntity> wrapper = new EntityWrapper<ToubiaojiluEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhaobiaodanwei")) {
			wrapper.eq("zhaobiaodanwei", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("toubiaodanwei")) {
			wrapper.eq("toubiaodanwei", (String)request.getSession().getAttribute("username"));
		}

		int count = toubiaojiluService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
