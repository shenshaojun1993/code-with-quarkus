package org.acm.demo.common;

import java.io.Serializable;

public class CustomResponse{

	private int code;

	private String msg;

	private Object data;

	public CustomResponse(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public CustomResponse(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "CustomResponse{" +
				"code=" + code +
				", msg='" + msg + '\'' +
				'}';
	}
}
