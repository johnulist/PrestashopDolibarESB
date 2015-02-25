package es.ual.itsi.pedidos;

import org.mule.api.annotations.param.Payload;

import es.ual.itsi.prestashopsoap.Response;

public class ListarPedidos extends es.ual.itsi.dolibar.DolibarClass {

	
	

	@Override
	public Response makeOperation(@Payload Response respuesta) {
		
		return respuesta;
	}
}
