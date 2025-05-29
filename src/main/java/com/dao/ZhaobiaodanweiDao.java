package com.dao;

import com.entity.ZhaobiaodanweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhaobiaodanweiVO;
import com.entity.view.ZhaobiaodanweiView;


/**
 * 招标单位
 * 
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
public interface ZhaobiaodanweiDao extends BaseMapper<ZhaobiaodanweiEntity> {
	
	List<ZhaobiaodanweiVO> selectListVO(@Param("ew") Wrapper<ZhaobiaodanweiEntity> wrapper);
	
	ZhaobiaodanweiVO selectVO(@Param("ew") Wrapper<ZhaobiaodanweiEntity> wrapper);
	
	List<ZhaobiaodanweiView> selectListView(@Param("ew") Wrapper<ZhaobiaodanweiEntity> wrapper);

	List<ZhaobiaodanweiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhaobiaodanweiEntity> wrapper);
	
	ZhaobiaodanweiView selectView(@Param("ew") Wrapper<ZhaobiaodanweiEntity> wrapper);
	

}
