package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ToubiaodanweiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ToubiaodanweiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ToubiaodanweiView;


/**
 * 投标单位
 *
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
public interface ToubiaodanweiService extends IService<ToubiaodanweiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ToubiaodanweiVO> selectListVO(Wrapper<ToubiaodanweiEntity> wrapper);
   	
   	ToubiaodanweiVO selectVO(@Param("ew") Wrapper<ToubiaodanweiEntity> wrapper);
   	
   	List<ToubiaodanweiView> selectListView(Wrapper<ToubiaodanweiEntity> wrapper);
   	
   	ToubiaodanweiView selectView(@Param("ew") Wrapper<ToubiaodanweiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ToubiaodanweiEntity> wrapper);
   	

}

