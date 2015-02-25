import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.mule.api.annotations.param.Payload;


public class CallPshop {

	private static final String APIKEY="HA85VUQQY3NAZTDES1AXL6841HXBJXAL";
	private static final String HOST="localhost:8888";
	private static final String PshopPath="/testpshop/prestashop/";
	
	public String callApi(@Payload String  payload){
		DefaultHttpClient client = new DefaultHttpClient();
		String url = "http://"+APIKEY+"@"+HOST+PshopPath+"api/products";
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
