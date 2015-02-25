package es.ual.itsi.prestashopsoap;

import javax.jws.WebService;

@WebService
public interface SoapPshop {
	
	
	
	public Response listProducts(String type,String status_tobuy,String status_tosell)throws Exception;
	public Response listClients(String id)throws Exception;
	public Response CreateClient(String ref,String email,String address)throws Exception;
}
