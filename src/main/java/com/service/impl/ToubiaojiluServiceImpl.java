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


import com.dao.ToubiaojiluDao;
import com.entity.ToubiaojiluEntity;
import com.service.ToubiaojiluService;
import com.entity.vo.ToubiaojiluVO;
import com.entity.view.ToubiaojiluView;

@Service("toubiaojiluService")
public class ToubiaojiluServiceImpl extends ServiceImpl<ToubiaojiluDao, ToubiaojiluEntity> implements ToubiaojiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ToubiaojiluEntity> page = this.selectPage(
                new Query<ToubiaojiluEntity>(params).getPage(),
                new EntityWrapper<ToubiaojiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ToubiaojiluEntity> wrapper) {
		  Page<ToubiaojiluView> page =new Query<ToubiaojiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ToubiaojiluVO> selectListVO(Wrapper<ToubiaojiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ToubiaojiluVO selectVO(Wrapper<ToubiaojiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ToubiaojiluView> selectListView(Wrapper<ToubiaojiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ToubiaojiluView selectView(Wrapper<ToubiaojiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
