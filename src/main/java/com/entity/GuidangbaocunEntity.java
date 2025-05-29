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
 * 归档保存
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
@TableName("guidangbaocun")
public class GuidangbaocunEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GuidangbaocunEntity() {
		
	}
	
	public GuidangbaocunEntity(T t) {
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
	 * 归档单号
	 */
					
	private String guidangdanhao;
	
	/**
	 * 招标名称
	 */
					
	private String zhaobiaomingcheng;
	
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
	 * 归档文件
	 */
					
	private String guidangwenjian;
	
	/**
	 * 归档说明
	 */
					
	private String guidangshuoming;
	
	/**
	 * 归档日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date guidangriqi;
	
	/**
	 * 跨表用户id
	 */
					
	private Long crossuserid;
	
	/**
	 * 跨表主键id
	 */
					
	private Long crossrefid;
	
	
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
	 * 设置：归档单号
	 */
	public void setGuidangdanhao(String guidangdanhao) {
		this.guidangdanhao = guidangdanhao;
	}
	/**
	 * 获取：归档单号
	 */
	public String getGuidangdanhao() {
		return guidangdanhao;
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
	 * 设置：归档文件
	 */
	public void setGuidangwenjian(String guidangwenjian) {
		this.guidangwenjian = guidangwenjian;
	}
	/**
	 * 获取：归档文件
	 */
	public String getGuidangwenjian() {
		return guidangwenjian;
	}
	/**
	 * 设置：归档说明
	 */
	public void setGuidangshuoming(String guidangshuoming) {
		this.guidangshuoming = guidangshuoming;
	}
	/**
	 * 获取：归档说明
	 */
	public String getGuidangshuoming() {
		return guidangshuoming;
	}
	/**
	 * 设置：归档日期
	 */
	public void setGuidangriqi(Date guidangriqi) {
		this.guidangriqi = guidangriqi;
	}
	/**
	 * 获取：归档日期
	 */
	public Date getGuidangriqi() {
		return guidangriqi;
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

}
