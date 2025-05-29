package com.dao;

import com.entity.GuidangbaocunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GuidangbaocunVO;
import com.entity.view.GuidangbaocunView;


/**
 * 归档保存
 * 
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
public interface GuidangbaocunDao extends BaseMapper<GuidangbaocunEntity> {
	
	List<GuidangbaocunVO> selectListVO(@Param("ew") Wrapper<GuidangbaocunEntity> wrapper);
	
	GuidangbaocunVO selectVO(@Param("ew") Wrapper<GuidangbaocunEntity> wrapper);
	
	List<GuidangbaocunView> selectListView(@Param("ew") Wrapper<GuidangbaocunEntity> wrapper);

	List<GuidangbaocunView> selectListView(Pagination page,@Param("ew") Wrapper<GuidangbaocunEntity> wrapper);
	
	GuidangbaocunView selectView(@Param("ew") Wrapper<GuidangbaocunEntity> wrapper);
	

}
