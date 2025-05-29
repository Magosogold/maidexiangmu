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

import com.entity.GuidangbaocunEntity;
import com.entity.view.GuidangbaocunView;

import com.service.GuidangbaocunService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 归档保存
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
@RestController
@RequestMapping("/guidangbaocun")
public class GuidangbaocunController {
    @Autowired
    private GuidangbaocunService guidangbaocunService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GuidangbaocunEntity guidangbaocun,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhaobiaodanwei")) {
			guidangbaocun.setZhaobiaodanwei((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("toubiaodanwei")) {
			guidangbaocun.setToubiaodanwei((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GuidangbaocunEntity> ew = new EntityWrapper<GuidangbaocunEntity>();

		PageUtils page = guidangbaocunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guidangbaocun), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GuidangbaocunEntity guidangbaocun, 
		HttpServletRequest request){
        EntityWrapper<GuidangbaocunEntity> ew = new EntityWrapper<GuidangbaocunEntity>();

		PageUtils page = guidangbaocunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guidangbaocun), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GuidangbaocunEntity guidangbaocun){
       	EntityWrapper<GuidangbaocunEntity> ew = new EntityWrapper<GuidangbaocunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( guidangbaocun, "guidangbaocun")); 
        return R.ok().put("data", guidangbaocunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GuidangbaocunEntity guidangbaocun){
        EntityWrapper< GuidangbaocunEntity> ew = new EntityWrapper< GuidangbaocunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( guidangbaocun, "guidangbaocun")); 
		GuidangbaocunView guidangbaocunView =  guidangbaocunService.selectView(ew);
		return R.ok("查询归档保存成功").put("data", guidangbaocunView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GuidangbaocunEntity guidangbaocun = guidangbaocunService.selectById(id);
        return R.ok().put("data", guidangbaocun);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GuidangbaocunEntity guidangbaocun = guidangbaocunService.selectById(id);
        return R.ok().put("data", guidangbaocun);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GuidangbaocunEntity guidangbaocun, HttpServletRequest request){
    	guidangbaocun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(guidangbaocun);
        guidangbaocunService.insert(guidangbaocun);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GuidangbaocunEntity guidangbaocun, HttpServletRequest request){
    	guidangbaocun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(guidangbaocun);
        guidangbaocunService.insert(guidangbaocun);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GuidangbaocunEntity guidangbaocun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guidangbaocun);
        guidangbaocunService.updateById(guidangbaocun);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        guidangbaocunService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GuidangbaocunEntity> wrapper = new EntityWrapper<GuidangbaocunEntity>();
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

		int count = guidangbaocunService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
