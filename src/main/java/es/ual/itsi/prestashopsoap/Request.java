package es.ual.itsi.prestashopsoap;

import java.util.HashMap;
import java.util.Map;

public class Request {

	public static final String BEPRODUCTS="PRODUCTS";
	public static final String BECLIENTS="CLIENTS";
	
	
	private Map<String,Object> parameters;
	private String be;
	private String op;
	public Request() {
		this.parameters= new HashMap<String, Object>();
		this.be="";
		this.op="";
	}
	public Map<String, Object> getParameters() {
		return parameters;
	}
	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}
	public String getBe() {
		return be;
	}
	public void setBe(String be) {
		this.be = be;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	
	public String toString(){
		String salida ="";
		salida+= "Parameters: "+ parameters.toString()+"\n";
		salida+= "be: " + be+"\n";
		salida+= "op: " + op+"\n";
		
		return salida;
	}
	public Object getParameter(String name){
		Object value=(this.parameters.get(name)!=null)?this.parameters.get(name):"";
		return value;
	}
}
