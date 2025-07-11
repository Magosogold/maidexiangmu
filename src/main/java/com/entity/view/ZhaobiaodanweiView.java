package com.entity.view;

import com.entity.ZhaobiaodanweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 招标单位
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
@TableName("zhaobiaodanwei")
public class ZhaobiaodanweiView  extends ZhaobiaodanweiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhaobiaodanweiView(){
	}
 
 	public ZhaobiaodanweiView(ZhaobiaodanweiEntity zhaobiaodanweiEntity){
 	try {
			BeanUtils.copyProperties(this, zhaobiaodanweiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
