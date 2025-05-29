package com.entity.vo;

import com.entity.ZhaobiaoxiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 招标项目
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
public class ZhaobiaoxiangmuVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 项目图片
	 */
	
	private String xiangmutupian;
		
	/**
	 * 招标文件
	 */
	
	private String zhaobiaowenjian;
		
	/**
	 * 标书价格
	 */
	
	private Integer biaoshujiage;
		
	/**
	 * 补充说明
	 */
	
	private String buchongshuoming;
		
	/**
	 * 招标内容
	 */
	
	private String zhaobiaoneirong;
		
	/**
	 * 发布日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date faburiqi;
		
	/**
	 * 招标单位
	 */
	
	private String zhaobiaodanwei;
		
	/**
	 * 咨询电话
	 */
	
	private String zixundianhua;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
		
	/**
	 * 倒计结束时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date reversetime;
				
	
	/**
	 * 设置：项目图片
	 */
	 
	public void setXiangmutupian(String xiangmutupian) {
		this.xiangmutupian = xiangmutupian;
	}
	
	/**
	 * 获取：项目图片
	 */
	public String getXiangmutupian() {
		return xiangmutupian;
	}
				
	
	/**
	 * 设置：招标文件
	 */
	 
	public void setZhaobiaowenjian(String zhaobiaowenjian) {
		this.zhaobiaowenjian = zhaobiaowenjian;
	}
	
	/**
	 * 获取：招标文件
	 */
	public String getZhaobiaowenjian() {
		return zhaobiaowenjian;
	}
				
	
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
	 * 设置：补充说明
	 */
	 
	public void setBuchongshuoming(String buchongshuoming) {
		this.buchongshuoming = buchongshuoming;
	}
	
	/**
	 * 获取：补充说明
	 */
	public String getBuchongshuoming() {
		return buchongshuoming;
	}
				
	
	/**
	 * 设置：招标内容
	 */
	 
	public void setZhaobiaoneirong(String zhaobiaoneirong) {
		this.zhaobiaoneirong = zhaobiaoneirong;
	}
	
	/**
	 * 获取：招标内容
	 */
	public String getZhaobiaoneirong() {
		return zhaobiaoneirong;
	}
				
	
	/**
	 * 设置：发布日期
	 */
	 
	public void setFaburiqi(Date faburiqi) {
		this.faburiqi = faburiqi;
	}
	
	/**
	 * 获取：发布日期
	 */
	public Date getFaburiqi() {
		return faburiqi;
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
	 * 设置：咨询电话
	 */
	 
	public void setZixundianhua(String zixundianhua) {
		this.zixundianhua = zixundianhua;
	}
	
	/**
	 * 获取：咨询电话
	 */
	public String getZixundianhua() {
		return zixundianhua;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
				
	
	/**
	 * 设置：倒计结束时间
	 */
	 
	public void setReversetime(Date reversetime) {
		this.reversetime = reversetime;
	}
	
	/**
	 * 获取：倒计结束时间
	 */
	public Date getReversetime() {
		return reversetime;
	}
			
}
