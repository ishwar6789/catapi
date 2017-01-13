package com.catapi.core;

public class ActionResult<T> {
	
	private boolean result;
	private Exception e;
	private T returnType;
	
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public Exception getE() {
		return e;
	}
	public void setE(Exception e) {
		this.e = e;
	}
	public T getReturnType() {
		return returnType;
	}
	public void setReturnType(T returnType) {
		this.returnType = returnType;
	}
	
	
}
