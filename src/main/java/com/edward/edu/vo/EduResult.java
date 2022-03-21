package com.edward.edu.vo;


public class EduResult {
	private int code;
	private String message;
	private Object data;
	
	public static EduResult ok(Object data){
		EduResult result= new EduResult();
		result.setCode(200);
		result.setMessage("成功");
		result.setData(data);

		return result;
	}
	
	public static EduResult error(Object data){
		EduResult result= new EduResult();
		result.setCode(500);
		result.setMessage("失败");
		result.setData(data);

		return result;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "EduResult [code=" + code + ", message=" + message + ", data=" + data + "]";
	}
	
}
