package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PingbiaozhuanjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PingbiaozhuanjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PingbiaozhuanjiaView;


/**
 * 评标专家
 *
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
public interface PingbiaozhuanjiaService extends IService<PingbiaozhuanjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PingbiaozhuanjiaVO> selectListVO(Wrapper<PingbiaozhuanjiaEntity> wrapper);
   	
   	PingbiaozhuanjiaVO selectVO(@Param("ew") Wrapper<PingbiaozhuanjiaEntity> wrapper);
   	
   	List<PingbiaozhuanjiaView> selectListView(Wrapper<PingbiaozhuanjiaEntity> wrapper);
   	
   	PingbiaozhuanjiaView selectView(@Param("ew") Wrapper<PingbiaozhuanjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PingbiaozhuanjiaEntity> wrapper);
   	

}

