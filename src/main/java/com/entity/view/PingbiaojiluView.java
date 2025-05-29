package com.entity.view;

import com.entity.PingbiaojiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 评标记录
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
@TableName("pingbiaojilu")
public class PingbiaojiluView  extends PingbiaojiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PingbiaojiluView(){
	}
 
 	public PingbiaojiluView(PingbiaojiluEntity pingbiaojiluEntity){
 	try {
			BeanUtils.copyProperties(this, pingbiaojiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
