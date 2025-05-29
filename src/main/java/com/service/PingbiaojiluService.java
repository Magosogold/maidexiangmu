package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PingbiaojiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PingbiaojiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PingbiaojiluView;


/**
 * 评标记录
 *
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
public interface PingbiaojiluService extends IService<PingbiaojiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PingbiaojiluVO> selectListVO(Wrapper<PingbiaojiluEntity> wrapper);
   	
   	PingbiaojiluVO selectVO(@Param("ew") Wrapper<PingbiaojiluEntity> wrapper);
   	
   	List<PingbiaojiluView> selectListView(Wrapper<PingbiaojiluEntity> wrapper);
   	
   	PingbiaojiluView selectView(@Param("ew") Wrapper<PingbiaojiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PingbiaojiluEntity> wrapper);
   	

}

