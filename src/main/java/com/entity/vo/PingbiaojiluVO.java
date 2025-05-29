package com.entity.vo;

import com.entity.PingbiaojiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 评标记录
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
public class PingbiaojiluVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 标书价格
	 */
	
	private Integer biaoshujiage;
		
	/**
	 * 招标单位
	 */
	
	private String zhaobiaodanwei;
		
	/**
	 * 评标情况
	 */
	
	private String pingbiaoqingkuang;
		
	/**
	 * 投标单位
	 */
	
	private String toubiaodanwei;
		
	/**
	 * 评标内容
	 */
	
	private String pingbiaoneirong;
		
	/**
	 * 评标日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date pingbiaoriqi;
		
	/**
	 * 专家姓名
	 */
	
	private String zhuanjiaxingming;
				
	
	/**
	 * 设置：标书价格
	 */
	 
	public void setBiaoshujiage(Integer biaoshujiage) {
		this.biaoshujiage = biaoshujiage;
	}
	
	/**
	 * 获取：标书价格
	 */
	public Integer getBiaoshujiage() {
		return biaoshujiage;
	}
				
	
	/**
	 * 设置：招标单位
	 */
	 
	public void setZhaobiaodanwei(String zhaobiaodanwei) {
		this.zhaobiaodanwei = zhaobiaodanwei;
	}
	
	/**
	 * 获取：招标单位
	 */
	public String getZhaobiaodanwei() {
		return zhaobiaodanwei;
	}
				
	
	/**
	 * 设置：评标情况
	 */
	 
	public void setPingbiaoqingkuang(String pingbiaoqingkuang) {
		this.pingbiaoqingkuang = pingbiaoqingkuang;
	}
	
	/**
	 * 获取：评标情况
	 */
	public String getPingbiaoqingkuang() {
		return pingbiaoqingkuang;
	}
				
	
	/**
	 * 设置：投标单位
	 */
	 
	public void setToubiaodanwei(String toubiaodanwei) {
		this.toubiaodanwei = toubiaodanwei;
	}
	
	/**
	 * 获取：投标单位
	 */
	public String getToubiaodanwei() {
		return toubiaodanwei;
	}
				
	
	/**
	 * 设置：评标内容
	 */
	 
	public void setPingbiaoneirong(String pingbiaoneirong) {
		this.pingbiaoneirong = pingbiaoneirong;
	}
	
	/**
	 * 获取：评标内容
	 */
	public String getPingbiaoneirong() {
		return pingbiaoneirong;
	}
				
	
	/**
	 * 设置：评标日期
	 */
	 
	public void setPingbiaoriqi(Date pingbiaoriqi) {
		this.pingbiaoriqi = pingbiaoriqi;
	}
	
	/**
	 * 获取：评标日期
	 */
	public Date getPingbiaoriqi() {
		return pingbiaoriqi;
	}
				
	
	/**
	 * 设置：专家姓名
	 */
	 
	public void setZhuanjiaxingming(String zhuanjiaxingming) {
		this.zhuanjiaxingming = zhuanjiaxingming;
	}
	
	/**
	 * 获取：专家姓名
	 */
	public String getZhuanjiaxingming() {
		return zhuanjiaxingming;
	}
			
}
