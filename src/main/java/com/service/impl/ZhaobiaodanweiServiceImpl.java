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


import com.dao.ZhaobiaodanweiDao;
import com.entity.ZhaobiaodanweiEntity;
import com.service.ZhaobiaodanweiService;
import com.entity.vo.ZhaobiaodanweiVO;
import com.entity.view.ZhaobiaodanweiView;

@Service("zhaobiaodanweiService")
public class ZhaobiaodanweiServiceImpl extends ServiceImpl<ZhaobiaodanweiDao, ZhaobiaodanweiEntity> implements ZhaobiaodanweiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhaobiaodanweiEntity> page = this.selectPage(
                new Query<ZhaobiaodanweiEntity>(params).getPage(),
                new EntityWrapper<ZhaobiaodanweiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaobiaodanweiEntity> wrapper) {
		  Page<ZhaobiaodanweiView> page =new Query<ZhaobiaodanweiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhaobiaodanweiVO> selectListVO(Wrapper<ZhaobiaodanweiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhaobiaodanweiVO selectVO(Wrapper<ZhaobiaodanweiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhaobiaodanweiView> selectListView(Wrapper<ZhaobiaodanweiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhaobiaodanweiView selectView(Wrapper<ZhaobiaodanweiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
