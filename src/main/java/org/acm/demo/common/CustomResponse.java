package org.acm.demo.common;

import java.io.Serializable;

public class CustomResponse<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private int code;

	private String msg;

	private T data;

	public CustomResponse(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public CustomResponse(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "CustomResponse{" +
				"code=" + code +
				", msg='" + msg + '\'' +
				'}';
	}
}
