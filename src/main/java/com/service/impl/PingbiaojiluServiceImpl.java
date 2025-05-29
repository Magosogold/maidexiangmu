package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.PingbiaojiluDao;
import com.entity.PingbiaojiluEntity;
import com.service.PingbiaojiluService;
import com.entity.vo.PingbiaojiluVO;
import com.entity.view.PingbiaojiluView;

@Service("pingbiaojiluService")
public class PingbiaojiluServiceImpl extends ServiceImpl<PingbiaojiluDao, PingbiaojiluEntity> implements PingbiaojiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PingbiaojiluEntity> page = this.selectPage(
                new Query<PingbiaojiluEntity>(params).getPage(),
                new EntityWrapper<PingbiaojiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PingbiaojiluEntity> wrapper) {
		  Page<PingbiaojiluView> page =new Query<PingbiaojiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PingbiaojiluVO> selectListVO(Wrapper<PingbiaojiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PingbiaojiluVO selectVO(Wrapper<PingbiaojiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PingbiaojiluView> selectListView(Wrapper<PingbiaojiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PingbiaojiluView selectView(Wrapper<PingbiaojiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
