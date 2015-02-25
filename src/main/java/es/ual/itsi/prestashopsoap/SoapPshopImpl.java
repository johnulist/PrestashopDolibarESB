package es.ual.itsi.prestashopsoap;

import javax.jws.WebService;

@WebService(endpointInterface="es.ual.itsi.prestashopsoap",name="mule2pshop")
public class SoapPshopImpl implements SoapPshop {

	@Override
	public Response listProducts(String type,String status_tobuy,String status_tosell) throws Exception {
		
		Request request = new Request();
		request.setBe(Request.BEPRODUCTS);
		request.setOp("LIST");
		try{
		Response response = new Response();
		response.setRequest(request);
		request.getParameters().put("type", type);
		request.getParameters().put("status_tobuy", status_tobuy);
		request.getParameters().put("status_tosell", status_tosell);
		return response;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Response listClients(String id) throws Exception {
		Request request = new Request();
		request.setBe(Request.BECLIENTS);
		request.setOp("LIST");
		try{
		Response response = new Response();
		response.setRequest(request);
	
		return response;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Response CreateClient(String ref, String email, String address)
			throws Exception {
		Request request = new Request();
		request.setBe(Request.BECLIENTS);
		request.setOp("CREATE");
		try{
		Response response = new Response();
		response.setRequest(request);
		request.getParameters().put("ref", ref);
		request.getParameters().put("email", email);
		request.getParameters().put("address", address);
		
		return response;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
