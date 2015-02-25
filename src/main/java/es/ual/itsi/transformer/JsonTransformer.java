package es.ual.itsi.transformer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import es.ual.itsi.prestashopsoap.Response;

public class JsonTransformer extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {

		Response resp = (Response) message.getPayload();
		Object respuesta = resp.getResponse();
		if (!(respuesta instanceof String)) {
			if (respuesta.getClass().isArray()) {
				JSONArray array;
				try {
					array = new JSONArray(respuesta);
					resp.setResponse(array.toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				JSONObject object = new JSONObject(resp.getResponse());
				resp.setResponse(object.toString());
			}
		}
		return resp;
	}

}
