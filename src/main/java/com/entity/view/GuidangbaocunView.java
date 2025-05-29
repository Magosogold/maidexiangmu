package com.entity.view;

import com.entity.GuidangbaocunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 归档保存
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
@TableName("guidangbaocun")
public class GuidangbaocunView  extends GuidangbaocunEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GuidangbaocunView(){
	}
 
 	public GuidangbaocunView(GuidangbaocunEntity guidangbaocunEntity){
 	try {
			BeanUtils.copyProperties(this, guidangbaocunEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
