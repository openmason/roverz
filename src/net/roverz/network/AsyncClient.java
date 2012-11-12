package net.roverz.network;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
/*
 * simple wrapper to handle all network calls.
 */
public class AsyncClient {
	static AsyncHttpClient client = new AsyncHttpClient();
	//@todo: generate an appropriate user agent
	static public String ROVER_AGENT = "rover/0.0.1";

	static {
		client.setUserAgent(ROVER_AGENT);
	}
	
	public static void get(String url, AsyncHttpResponseHandler responseHandler) {
        client.get(url, responseHandler);
    }

}
