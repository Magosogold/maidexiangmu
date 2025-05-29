package com.entity.view;

import com.entity.PingbiaozhuanjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 评标专家
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
@TableName("pingbiaozhuanjia")
public class PingbiaozhuanjiaView  extends PingbiaozhuanjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PingbiaozhuanjiaView(){
	}
 
 	public PingbiaozhuanjiaView(PingbiaozhuanjiaEntity pingbiaozhuanjiaEntity){
 	try {
			BeanUtils.copyProperties(this, pingbiaozhuanjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
