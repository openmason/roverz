package net.roverz;

import net.roverz.network.AsyncClient;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.loopj.android.http.JsonHttpResponseHandler;

public class Launcher extends Activity {

	static JsonHttpResponseHandler responseHdlr = new JsonHttpResponseHandler() {
		@Override
		public void onStart() {
			System.err.println("Starting the call");
		}

		@Override
		public void onFailure(Throwable e) {
			System.err.println("Call failed" + e);
		}

		@Override
		public void onSuccess(JSONArray resp) {
			System.err.println("Call success arr:" + resp.toString());
		}

		@Override
		public void onSuccess(JSONObject resp) {
			System.err.println("Call success obj:" + resp.toString());
		}

		@Override
		public void onSuccess(String timeline) {
			System.err.println("Call success str:" + timeline.toString());
		}
	};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AsyncClient.get("http://192.168.128.2:8080/api/v1/todos", responseHdlr);
        setContentView(R.layout.activity_launcher);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_launcher, menu);
        return true;
    }
}
