package com.entity.model;

import com.entity.ToubiaodanweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 投标单位
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
public class ToubiaodanweiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String mima;
		
	/**
	 * 联系人
	 */
	
	private String lianxiren;
		
	/**
	 * 投标级别
	 */
	
	private String toubiaojibie;
		
	/**
	 * 办公地址
	 */
	
	private String bangongdizhi;
		
	/**
	 * 经营范围
	 */
	
	private String jingyingfanwei;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
				
	
	/**
	 * 设置：密码
	 */
	 
	public void setMima(String mima) {
		this.mima = mima;
	}
	
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
				
	
	/**
	 * 设置：联系人
	 */
	 
	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}
	
	/**
	 * 获取：联系人
	 */
	public String getLianxiren() {
		return lianxiren;
	}
				
	
	/**
	 * 设置：投标级别
	 */
	 
	public void setToubiaojibie(String toubiaojibie) {
		this.toubiaojibie = toubiaojibie;
	}
	
	/**
	 * 获取：投标级别
	 */
	public String getToubiaojibie() {
		return toubiaojibie;
	}
				
	
	/**
	 * 设置：办公地址
	 */
	 
	public void setBangongdizhi(String bangongdizhi) {
		this.bangongdizhi = bangongdizhi;
	}
	
	/**
	 * 获取：办公地址
	 */
	public String getBangongdizhi() {
		return bangongdizhi;
	}
				
	
	/**
	 * 设置：经营范围
	 */
	 
	public void setJingyingfanwei(String jingyingfanwei) {
		this.jingyingfanwei = jingyingfanwei;
	}
	
	/**
	 * 获取：经营范围
	 */
	public String getJingyingfanwei() {
		return jingyingfanwei;
	}
				
	
	/**
	 * 设置：联系电话
	 */
	 
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
			
}
