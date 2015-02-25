package es.ual.itsi.prestashopsoap;

import java.util.ArrayList;
import java.util.List;

public class Response {

	
	private String result;
	private Object response;
	private Error[] errors;
	private Request request;
	
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public Error[] getErrors() {
		return errors;
	}
	public void setErrors(Error[] errors) {
		this.errors = errors;
	}
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public void addError(String summary,String detail){
		this.result="KO";
		List<Error> errores = new ArrayList<Error>();
		if(this.errors!=null){
		for (Error error : this.errors) {
			errores.add(error);
		}
		}
		Error error = new Error();
		error.setDetail(detail);
		error.setSummary(summary);
		errores.add(error);
		this.errors= new Error[errores.size()];
		errores.toArray(this.errors);
	}
	
}
