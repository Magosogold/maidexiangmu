package com.dao;

import com.entity.ToubiaodanweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ToubiaodanweiVO;
import com.entity.view.ToubiaodanweiView;


/**
 * 投标单位
 * 
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
public interface ToubiaodanweiDao extends BaseMapper<ToubiaodanweiEntity> {
	
	List<ToubiaodanweiVO> selectListVO(@Param("ew") Wrapper<ToubiaodanweiEntity> wrapper);
	
	ToubiaodanweiVO selectVO(@Param("ew") Wrapper<ToubiaodanweiEntity> wrapper);
	
	List<ToubiaodanweiView> selectListView(@Param("ew") Wrapper<ToubiaodanweiEntity> wrapper);

	List<ToubiaodanweiView> selectListView(Pagination page,@Param("ew") Wrapper<ToubiaodanweiEntity> wrapper);
	
	ToubiaodanweiView selectView(@Param("ew") Wrapper<ToubiaodanweiEntity> wrapper);
	

}
