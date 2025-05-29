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

import com.entity.PingbiaojiluEntity;
import com.entity.view.PingbiaojiluView;

import com.service.PingbiaojiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 评标记录
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
@RestController
@RequestMapping("/pingbiaojilu")
public class PingbiaojiluController {
    @Autowired
    private PingbiaojiluService pingbiaojiluService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PingbiaojiluEntity pingbiaojilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhaobiaodanwei")) {
			pingbiaojilu.setZhaobiaodanwei((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("toubiaodanwei")) {
			pingbiaojilu.setToubiaodanwei((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("pingbiaozhuanjia")) {
			pingbiaojilu.setZhuanjiaxingming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PingbiaojiluEntity> ew = new EntityWrapper<PingbiaojiluEntity>();

		PageUtils page = pingbiaojiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingbiaojilu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PingbiaojiluEntity pingbiaojilu, 
		HttpServletRequest request){
        EntityWrapper<PingbiaojiluEntity> ew = new EntityWrapper<PingbiaojiluEntity>();

		PageUtils page = pingbiaojiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingbiaojilu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PingbiaojiluEntity pingbiaojilu){
       	EntityWrapper<PingbiaojiluEntity> ew = new EntityWrapper<PingbiaojiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( pingbiaojilu, "pingbiaojilu")); 
        return R.ok().put("data", pingbiaojiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PingbiaojiluEntity pingbiaojilu){
        EntityWrapper< PingbiaojiluEntity> ew = new EntityWrapper< PingbiaojiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( pingbiaojilu, "pingbiaojilu")); 
		PingbiaojiluView pingbiaojiluView =  pingbiaojiluService.selectView(ew);
		return R.ok("查询评标记录成功").put("data", pingbiaojiluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PingbiaojiluEntity pingbiaojilu = pingbiaojiluService.selectById(id);
        return R.ok().put("data", pingbiaojilu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PingbiaojiluEntity pingbiaojilu = pingbiaojiluService.selectById(id);
        return R.ok().put("data", pingbiaojilu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PingbiaojiluEntity pingbiaojilu, HttpServletRequest request){
    	pingbiaojilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(pingbiaojilu);
        pingbiaojiluService.insert(pingbiaojilu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PingbiaojiluEntity pingbiaojilu, HttpServletRequest request){
    	pingbiaojilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(pingbiaojilu);
        pingbiaojiluService.insert(pingbiaojilu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PingbiaojiluEntity pingbiaojilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(pingbiaojilu);
        pingbiaojiluService.updateById(pingbiaojilu);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        pingbiaojiluService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<PingbiaojiluEntity> wrapper = new EntityWrapper<PingbiaojiluEntity>();
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
		if(tableName.equals("pingbiaozhuanjia")) {
			wrapper.eq("zhuanjiaxingming", (String)request.getSession().getAttribute("username"));
		}

		int count = pingbiaojiluService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
