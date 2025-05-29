package com.dao;

import com.entity.PingbiaozhuanjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PingbiaozhuanjiaVO;
import com.entity.view.PingbiaozhuanjiaView;


/**
 * 评标专家
 * 
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
public interface PingbiaozhuanjiaDao extends BaseMapper<PingbiaozhuanjiaEntity> {
	
	List<PingbiaozhuanjiaVO> selectListVO(@Param("ew") Wrapper<PingbiaozhuanjiaEntity> wrapper);
	
	PingbiaozhuanjiaVO selectVO(@Param("ew") Wrapper<PingbiaozhuanjiaEntity> wrapper);
	
	List<PingbiaozhuanjiaView> selectListView(@Param("ew") Wrapper<PingbiaozhuanjiaEntity> wrapper);

	List<PingbiaozhuanjiaView> selectListView(Pagination page,@Param("ew") Wrapper<PingbiaozhuanjiaEntity> wrapper);
	
	PingbiaozhuanjiaView selectView(@Param("ew") Wrapper<PingbiaozhuanjiaEntity> wrapper);
	

}
