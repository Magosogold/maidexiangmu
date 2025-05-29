package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhaobiaodanweiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhaobiaodanweiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhaobiaodanweiView;


/**
 * 招标单位
 *
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
public interface ZhaobiaodanweiService extends IService<ZhaobiaodanweiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhaobiaodanweiVO> selectListVO(Wrapper<ZhaobiaodanweiEntity> wrapper);
   	
   	ZhaobiaodanweiVO selectVO(@Param("ew") Wrapper<ZhaobiaodanweiEntity> wrapper);
   	
   	List<ZhaobiaodanweiView> selectListView(Wrapper<ZhaobiaodanweiEntity> wrapper);
   	
   	ZhaobiaodanweiView selectView(@Param("ew") Wrapper<ZhaobiaodanweiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhaobiaodanweiEntity> wrapper);
   	

}

