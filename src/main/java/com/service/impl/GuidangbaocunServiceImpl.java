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


import com.dao.GuidangbaocunDao;
import com.entity.GuidangbaocunEntity;
import com.service.GuidangbaocunService;
import com.entity.vo.GuidangbaocunVO;
import com.entity.view.GuidangbaocunView;

@Service("guidangbaocunService")
public class GuidangbaocunServiceImpl extends ServiceImpl<GuidangbaocunDao, GuidangbaocunEntity> implements GuidangbaocunService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuidangbaocunEntity> page = this.selectPage(
                new Query<GuidangbaocunEntity>(params).getPage(),
                new EntityWrapper<GuidangbaocunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GuidangbaocunEntity> wrapper) {
		  Page<GuidangbaocunView> page =new Query<GuidangbaocunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GuidangbaocunVO> selectListVO(Wrapper<GuidangbaocunEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GuidangbaocunVO selectVO(Wrapper<GuidangbaocunEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GuidangbaocunView> selectListView(Wrapper<GuidangbaocunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GuidangbaocunView selectView(Wrapper<GuidangbaocunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
