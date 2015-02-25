package es.ual.itsi.prestashopsoap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.mule.api.annotations.param.Payload;

public class ProductsPShop {
	private static final String APIKEY="CUBQMK8MFWBATP3YZKJFXWHV61BQ2EDW";
	private static final String HOST="rpbian.ddns.net";
	private static final String PshopPath="/prestashop/";
	
	public Response Products(@Payload Response response){
		Request request = response.getRequest();
		if(request.getOp().equals("LIST")){
			Response resp = new Response();
			String url = "http://"+APIKEY+"@"+HOST+PshopPath+"api/products/";
			String res = makeGet(url);
			resp.setResponse(res);
			if(res!=null)
				resp.setResult("OK");
			else
				resp.setResult("ERROR");
			return resp;
		}
		return null;
	}
	
	private String makeGet(String url){
		DefaultHttpClient client = new DefaultHttpClient();
		
		HttpGet get = new HttpGet(url);
		try {
			HttpResponse response = client.execute(get);
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String output;
			String salida="";
			while((output=br.readLine())!=null){
				salida+=output;
			}
			client.getConnectionManager().shutdown();
			return salida;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
