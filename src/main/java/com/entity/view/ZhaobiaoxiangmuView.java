package com.entity.view;

import com.entity.ZhaobiaoxiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 招标项目
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
@TableName("zhaobiaoxiangmu")
public class ZhaobiaoxiangmuView  extends ZhaobiaoxiangmuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhaobiaoxiangmuView(){
	}
 
 	public ZhaobiaoxiangmuView(ZhaobiaoxiangmuEntity zhaobiaoxiangmuEntity){
 	try {
			BeanUtils.copyProperties(this, zhaobiaoxiangmuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
