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


import com.dao.PingbiaozhuanjiaDao;
import com.entity.PingbiaozhuanjiaEntity;
import com.service.PingbiaozhuanjiaService;
import com.entity.vo.PingbiaozhuanjiaVO;
import com.entity.view.PingbiaozhuanjiaView;

@Service("pingbiaozhuanjiaService")
public class PingbiaozhuanjiaServiceImpl extends ServiceImpl<PingbiaozhuanjiaDao, PingbiaozhuanjiaEntity> implements PingbiaozhuanjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PingbiaozhuanjiaEntity> page = this.selectPage(
                new Query<PingbiaozhuanjiaEntity>(params).getPage(),
                new EntityWrapper<PingbiaozhuanjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PingbiaozhuanjiaEntity> wrapper) {
		  Page<PingbiaozhuanjiaView> page =new Query<PingbiaozhuanjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PingbiaozhuanjiaVO> selectListVO(Wrapper<PingbiaozhuanjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PingbiaozhuanjiaVO selectVO(Wrapper<PingbiaozhuanjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PingbiaozhuanjiaView> selectListView(Wrapper<PingbiaozhuanjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PingbiaozhuanjiaView selectView(Wrapper<PingbiaozhuanjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
