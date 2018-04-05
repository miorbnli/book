package com.book.common.po;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>Title: BasePojo</p>  
 * <p>Description:pojo基类，完成2个任务，2个日期，实现序列化 </p>  
 * @author liyuanbin 
 * @date Mar 25, 2018
 */
public class BasePojo implements Serializable{
	private static final long serialVersionUID = 8291058891687026421L;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") 
	private Date createdtime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") 
    private Date modifiedtime;
	public Date getCreatedtime() {
		return createdtime;
		
	}
	public void setCreatedtime(Date createdTime) {
		this.createdtime = createdTime;
	}
	public Date getModifiedtime() {
		return modifiedtime;
	}
	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}
	
}
