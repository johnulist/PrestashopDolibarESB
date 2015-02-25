package es.ual.itsi.productos;

import org.json.JSONArray;
import org.mule.api.annotations.param.Payload;

import es.ual.itsi.dolibar.DolibarClass;
import es.ual.itsi.dolibar.common.Authentication;
import es.ual.itsi.prestashopsoap.Response;
import es.ual.itsi.productos.holders.ProductsArray2Holder;
import es.ual.itsi.productos.holders.ResultHolder;

public class ListarProductos extends DolibarClass {

	@Override
	public Response makeOperation(@Payload Response respuesta) {
		WebServicesDolibarrProductOrServiceLocator locator = new WebServicesDolibarrProductOrServiceLocator();
		try {
			Authentication autentication = new Authentication("48a8f4baefe4e216054d96eee812daf8", "", "pperez", "sb5cxywv", "");
			String type = (String) respuesta.getRequest().getParameter("type");
			String toSell = (String) respuesta.getRequest().getParameter("status_tobuy");
			String tobuy = (String) respuesta.getRequest().getParameter("status_tosell");
			Filterproduct filter = new Filterproduct(type, tobuy, toSell);
			WebServicesDolibarrProductOrServicePortType porttype = locator.getWebServicesDolibarrProductOrServicePort();
			ResultHolder resholder = new ResultHolder();
			ProductsArray2Holder parray2holder = new ProductsArray2Holder();
			porttype.getListOfProductsOrServices(autentication, filter, resholder, parray2holder);
			JSONArray array = new JSONArray(parray2holder.value);
			respuesta.setResponse(array.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		return respuesta;
	}

	
}
