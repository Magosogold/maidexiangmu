package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 评标记录
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
@TableName("pingbiaojilu")
public class PingbiaojiluEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PingbiaojiluEntity() {
		
	}
	
	public PingbiaojiluEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date pingbiaoriqi;
	
	/**
	 * 专家姓名
	 */
					
	private String zhuanjiaxingming;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
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
