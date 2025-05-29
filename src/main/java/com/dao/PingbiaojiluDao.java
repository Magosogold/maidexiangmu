package com.dao;

import com.entity.PingbiaojiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PingbiaojiluVO;
import com.entity.view.PingbiaojiluView;


/**
 * 评标记录
 * 
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
public interface PingbiaojiluDao extends BaseMapper<PingbiaojiluEntity> {
	
	List<PingbiaojiluVO> selectListVO(@Param("ew") Wrapper<PingbiaojiluEntity> wrapper);
	
	PingbiaojiluVO selectVO(@Param("ew") Wrapper<PingbiaojiluEntity> wrapper);
	
	List<PingbiaojiluView> selectListView(@Param("ew") Wrapper<PingbiaojiluEntity> wrapper);

	List<PingbiaojiluView> selectListView(Pagination page,@Param("ew") Wrapper<PingbiaojiluEntity> wrapper);
	
	PingbiaojiluView selectView(@Param("ew") Wrapper<PingbiaojiluEntity> wrapper);
	

}
