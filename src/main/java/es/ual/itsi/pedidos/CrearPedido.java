package es.ual.itsi.pedidos;

import org.mule.api.annotations.param.Payload;

import es.ual.itsi.dolibar.DolibarClass;
import es.ual.itsi.prestashopsoap.Response;

public class CrearPedido extends DolibarClass {

	

	@Override
	public Response makeOperation(@Payload Response respuesta) {
		return respuesta;
	}
}
