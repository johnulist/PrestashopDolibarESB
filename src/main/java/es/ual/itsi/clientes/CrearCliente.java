package es.ual.itsi.clientes;

import javax.xml.rpc.holders.StringHolder;

import org.mule.api.annotations.param.Payload;

import es.ual.itsi.dolibar.DolibarClass;
import es.ual.itsi.dolibar.common.Authentication;
import es.ual.itsi.dolibar.holders.ResultHolder;
import es.ual.itsi.dolibar.terceros.Thirdparty;
import es.ual.itsi.dolibar.terceros.WebServicesDolibarrThirdPartyLocator;
import es.ual.itsi.dolibar.terceros.WebServicesDolibarrThirdPartyPortType;
import es.ual.itsi.prestashopsoap.Response;

public class CrearCliente extends DolibarClass {


	@Override
	public Response makeOperation(@Payload Response respuesta) {
		Thirdparty tercero = new Thirdparty();
		tercero.setRef((String)respuesta.getRequest().getParameter("ref"));
		tercero.setAddress((String)respuesta.getRequest().getParameter("address"));
		tercero.setClient("1");
		tercero.setEmail((String)respuesta.getRequest().getParameter("email"));
		tercero.setStatus("1");
		tercero.setFk_user_author(getAutentication().getLogin());
		StringHolder resp=createDolibarClient(tercero);
		
			if(resp.value!=null){
				
				respuesta.setResponse(resp.value);
				respuesta.setResult("OK");
			}
		
		return respuesta;
	}
	
	private StringHolder createDolibarClient(Thirdparty tercero){
		tercero.setClient("1");
		WebServicesDolibarrThirdPartyLocator locator = new WebServicesDolibarrThirdPartyLocator();
		try {
			WebServicesDolibarrThirdPartyPortType tparty=locator.getWebServicesDolibarrThirdPartyPort();
			setAutenticationKeys("48a8f4baefe4e216054d96eee812daf8", "pperez", "sb5cxywv");
			Authentication autentication= getAutentication();
			ResultHolder holder = new ResultHolder();
			StringHolder id = new StringHolder();
			StringHolder ref = new StringHolder();
			tparty.createThirdParty(autentication, tercero, holder, id, ref);
			return id;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
