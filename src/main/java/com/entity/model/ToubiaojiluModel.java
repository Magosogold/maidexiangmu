package com.entity.model;

import com.entity.ToubiaojiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 投标记录
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
public class ToubiaojiluModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 招标名称
	 */
	
	private String zhaobiaomingcheng;
		
	/**
	 * 标书价格
	 */
	
	private Integer biaoshujiage;
		
	/**
	 * 招标单位
	 */
	
	private String zhaobiaodanwei;
		
	/**
	 * 投标日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date toubiaoriqi;
		
	/**
	 * 投标文件
	 */
	
	private String toubiaowenjian;
		
	/**
	 * 投标内容
	 */
	
	private String toubiaoneirong;
		
	/**
	 * 评标状态
	 */
	
	private String pingbiaozhuangtai;
		
	/**
	 * 投标单位
	 */
	
	private String toubiaodanwei;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 跨表用户id
	 */
	
	private Long crossuserid;
		
	/**
	 * 跨表主键id
	 */
	
	private Long crossrefid;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：招标名称
	 */
	 
	public void setZhaobiaomingcheng(String zhaobiaomingcheng) {
		this.zhaobiaomingcheng = zhaobiaomingcheng;
	}
	
	/**
	 * 获取：招标名称
	 */
	public String getZhaobiaomingcheng() {
		return zhaobiaomingcheng;
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
	 * 设置：投标日期
	 */
	 
	public void setToubiaoriqi(Date toubiaoriqi) {
		this.toubiaoriqi = toubiaoriqi;
	}
	
	/**
	 * 获取：投标日期
	 */
	public Date getToubiaoriqi() {
		return toubiaoriqi;
	}
				
	
	/**
	 * 设置：投标文件
	 */
	 
	public void setToubiaowenjian(String toubiaowenjian) {
		this.toubiaowenjian = toubiaowenjian;
	}
	
	/**
	 * 获取：投标文件
	 */
	public String getToubiaowenjian() {
		return toubiaowenjian;
	}
				
	
	/**
	 * 设置：投标内容
	 */
	 
	public void setToubiaoneirong(String toubiaoneirong) {
		this.toubiaoneirong = toubiaoneirong;
	}
	
	/**
	 * 获取：投标内容
	 */
	public String getToubiaoneirong() {
		return toubiaoneirong;
	}
				
	
	/**
	 * 设置：评标状态
	 */
	 
	public void setPingbiaozhuangtai(String pingbiaozhuangtai) {
		this.pingbiaozhuangtai = pingbiaozhuangtai;
	}
	
	/**
	 * 获取：评标状态
	 */
	public String getPingbiaozhuangtai() {
		return pingbiaozhuangtai;
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
				
	
	/**
	 * 设置：跨表用户id
	 */
	 
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
				
	
	/**
	 * 设置：跨表主键id
	 */
	 
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
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
			
}
