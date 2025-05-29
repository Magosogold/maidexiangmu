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
 * 投标单位
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-02-16 09:25:18
 */
@TableName("toubiaodanwei")
public class ToubiaodanweiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ToubiaodanweiEntity() {
		
	}
	
	public ToubiaodanweiEntity(T t) {
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
	 * 投标单位
	 */
					
	private String toubiaodanwei;
	
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
