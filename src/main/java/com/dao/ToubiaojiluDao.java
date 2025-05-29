package com.dao;

import com.entity.ToubiaojiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ToubiaojiluVO;
import com.entity.view.ToubiaojiluView;


/**
 * 投标记录
 * 
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
public interface ToubiaojiluDao extends BaseMapper<ToubiaojiluEntity> {
	
	List<ToubiaojiluVO> selectListVO(@Param("ew") Wrapper<ToubiaojiluEntity> wrapper);
	
	ToubiaojiluVO selectVO(@Param("ew") Wrapper<ToubiaojiluEntity> wrapper);
	
	List<ToubiaojiluView> selectListView(@Param("ew") Wrapper<ToubiaojiluEntity> wrapper);

	List<ToubiaojiluView> selectListView(Pagination page,@Param("ew") Wrapper<ToubiaojiluEntity> wrapper);
	
	ToubiaojiluView selectView(@Param("ew") Wrapper<ToubiaojiluEntity> wrapper);
	

}
