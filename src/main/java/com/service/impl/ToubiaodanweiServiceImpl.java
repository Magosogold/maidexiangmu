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


import com.dao.ToubiaodanweiDao;
import com.entity.ToubiaodanweiEntity;
import com.service.ToubiaodanweiService;
import com.entity.vo.ToubiaodanweiVO;
import com.entity.view.ToubiaodanweiView;

@Service("toubiaodanweiService")
public class ToubiaodanweiServiceImpl extends ServiceImpl<ToubiaodanweiDao, ToubiaodanweiEntity> implements ToubiaodanweiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ToubiaodanweiEntity> page = this.selectPage(
                new Query<ToubiaodanweiEntity>(params).getPage(),
                new EntityWrapper<ToubiaodanweiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ToubiaodanweiEntity> wrapper) {
		  Page<ToubiaodanweiView> page =new Query<ToubiaodanweiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ToubiaodanweiVO> selectListVO(Wrapper<ToubiaodanweiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ToubiaodanweiVO selectVO(Wrapper<ToubiaodanweiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ToubiaodanweiView> selectListView(Wrapper<ToubiaodanweiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ToubiaodanweiView selectView(Wrapper<ToubiaodanweiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
