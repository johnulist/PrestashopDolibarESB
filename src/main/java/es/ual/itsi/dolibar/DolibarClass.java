package es.ual.itsi.dolibar;

import org.mule.api.annotations.param.Payload;

import es.ual.itsi.dolibar.common.Authentication;
import es.ual.itsi.prestashopsoap.Response;

public abstract class DolibarClass {

	private String dolibarKey;
	private String dolibarLogin;
	private String dolibarPassword;
	
	public DolibarClass(){
		this.dolibarKey="";
		this.dolibarLogin="";
		this.dolibarPassword="";
	}
	public DolibarClass(String key,String Login, String Password) {
		this.dolibarKey=key;
		this.dolibarLogin=Login;
		this.dolibarPassword=Password;
	}
	protected Authentication getAutentication(){
		Authentication autentication;
		autentication= new Authentication(dolibarKey, "", dolibarLogin, dolibarPassword, "");
		return autentication;
	}
	protected void setAutenticationKeys(String key,String login, String Password){
		this.dolibarKey=key;
		this.dolibarLogin=login;
		this.dolibarPassword=Password;
	}
	
	public abstract Response makeOperation(@Payload Response respuesta);
}