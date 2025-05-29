package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ToubiaojiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ToubiaojiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ToubiaojiluView;


/**
 * 投标记录
 *
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
public interface ToubiaojiluService extends IService<ToubiaojiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ToubiaojiluVO> selectListVO(Wrapper<ToubiaojiluEntity> wrapper);
   	
   	ToubiaojiluVO selectVO(@Param("ew") Wrapper<ToubiaojiluEntity> wrapper);
   	
   	List<ToubiaojiluView> selectListView(Wrapper<ToubiaojiluEntity> wrapper);
   	
   	ToubiaojiluView selectView(@Param("ew") Wrapper<ToubiaojiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ToubiaojiluEntity> wrapper);
   	

}

