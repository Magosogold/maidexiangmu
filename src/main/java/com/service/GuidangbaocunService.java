package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GuidangbaocunEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GuidangbaocunVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GuidangbaocunView;


/**
 * 归档保存
 *
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
public interface GuidangbaocunService extends IService<GuidangbaocunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GuidangbaocunVO> selectListVO(Wrapper<GuidangbaocunEntity> wrapper);
   	
   	GuidangbaocunVO selectVO(@Param("ew") Wrapper<GuidangbaocunEntity> wrapper);
   	
   	List<GuidangbaocunView> selectListView(Wrapper<GuidangbaocunEntity> wrapper);
   	
   	GuidangbaocunView selectView(@Param("ew") Wrapper<GuidangbaocunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GuidangbaocunEntity> wrapper);
   	

}

