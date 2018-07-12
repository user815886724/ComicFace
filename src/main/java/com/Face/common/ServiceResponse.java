package com.Face.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//保证序列化json的时候，如果是null对象，key也会消失
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServiceResponse<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int status;
	private String msg;
	private T data;
	
	private ServiceResponse(int status){
		this.status = status;
	}
	private ServiceResponse(int status,T data){
		this.status = status;
		this.data=data;
	}
	private ServiceResponse(int status,String msg,T data){
		this.status = status;
		this.msg=msg;
		this.data=data;
	}
	private ServiceResponse(int status,String msg){
		this.status = status;
		this.msg=msg;
	}

	//使之不在json序列化结果当中
	@JsonIgnore
	public boolean isSuccess(){
		return this.status == ResponseCode.SUCCESS.getCode();
	}
	public int getStatus(){
		return status;
	}
	public T getData() {
		return data;
	}
	public String getMsg() {
		return msg;
	}
	//成功的构造器
	public static <T> ServiceResponse<T> createBySuccess(){
		return new ServiceResponse<T>(ResponseCode.SUCCESS.getCode());
	}
	public static <T> ServiceResponse<T> createBySuccessMessage(String message){
		return new ServiceResponse<T>(ResponseCode.SUCCESS.getCode(),message);
	}
	public static <T> ServiceResponse<T> createBySuccess(T data){
		return new ServiceResponse<T>(ResponseCode.SUCCESS.getCode(),data);
	}
	public static <T> ServiceResponse<T> createBySuccess(String message,T data){
		return new ServiceResponse<T>(ResponseCode.SUCCESS.getCode(),message,data);
	}
	//退出的构造器
	public static <T> ServiceResponse<T> outToLogin(){
		return new ServiceResponse<T>(ResponseCode.NEED_LOGIN.getCode());
	}
	
	
	//失败的构造器
	public static <T> ServiceResponse<T> createByError(){
		return new ServiceResponse<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
	}
	public static <T>ServiceResponse<T> createByErrorMessage(String errorMessage){
		return new ServiceResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
	}
	public static <T>ServiceResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
		return new ServiceResponse<T>(errorCode,errorMessage);
	}
	
	
}
