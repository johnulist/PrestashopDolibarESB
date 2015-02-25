package es.ual.itsi.clientes;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.mule.api.annotations.param.Payload;

import es.ual.itsi.dolibar.DolibarClass;
import es.ual.itsi.dolibar.common.Authentication;
import es.ual.itsi.dolibar.holders.ResultHolder;
import es.ual.itsi.dolibar.holders.ThirdPartiesArray2Holder;
import es.ual.itsi.dolibar.terceros.Filterthirdparty;
import es.ual.itsi.dolibar.terceros.WebServicesDolibarrThirdPartyLocator;
import es.ual.itsi.dolibar.terceros.WebServicesDolibarrThirdPartyPortType;
import es.ual.itsi.prestashopsoap.Response;

public class ListarCliente extends DolibarClass{

	

	@Override
	public Response makeOperation(@Payload Response respuesta) {

		WebServicesDolibarrThirdPartyLocator locator = new WebServicesDolibarrThirdPartyLocator();
		try {
			WebServicesDolibarrThirdPartyPortType tparty=locator.getWebServicesDolibarrThirdPartyPort();
			setAutenticationKeys("48a8f4baefe4e216054d96eee812daf8", "pperez", "sb5cxywv");
			Authentication autentication= getAutentication();
			Filterthirdparty filtro = new Filterthirdparty();
			String client=(String) respuesta.getRequest().getParameter("client");
			String category=(String) respuesta.getRequest().getParameter("category");
			String supplier= (String) respuesta.getRequest().getParameter("supplier");
			filtro.setClient(client);
			filtro.setCategory(category);
			filtro.setSupplier(supplier);
			ResultHolder resultado = new ResultHolder();
			ThirdPartiesArray2Holder tpholder = new ThirdPartiesArray2Holder();
			tparty.getListOfThirdParties(autentication, filtro, resultado, tpholder);
			respuesta.setResult("OK");
			
			respuesta.setResponse(tpholder.value);
		} catch (RemoteException e) {
			respuesta.addError(e.getMessage(), e.getLocalizedMessage());
			
		} catch (ServiceException e) {
//			respuesta.addError(e.getMessage(), e.getLocalizedMessage());
		} 
		
		return respuesta;
	}
}
