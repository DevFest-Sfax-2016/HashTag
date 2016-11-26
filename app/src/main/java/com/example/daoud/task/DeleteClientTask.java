package com.example.daoud.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.daoud.adapter.ClientAdapter;
import com.example.daoud.model.Client;
import com.example.daoud.siwar_models.R;
import com.example.daoud.util.HostServer;
import com.example.daoud.util.JSONParser;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by daoud on 06/02/2016.
 */
public class DeleteClientTask extends AsyncTask<String,Integer,JSONObject> {
    Context context;
    Client tmpClient;
    private ProgressDialog pBar;

    public DeleteClientTask(Context context ,Client tmpClient) {
        this.tmpClient=tmpClient;
        this.context = context;

    }
    @Override
    protected void onPreExecute() {

        pBar=new ProgressDialog(context);
        pBar.setMessage("Please Wait ...");
        pBar.show();
        super.onPreExecute();
    }
    @Override
    protected JSONObject doInBackground(String... params) {

        JSONParser jParser=new JSONParser();
        ArrayList<NameValuePair> data=new ArrayList<NameValuePair>();


        JSONObject json=jParser.makeHttpRequest("http://"+HostServer.IP+"/RestAPI.svc/DeleteClient/"+tmpClient.getCin(),"GET",data);

        Log.e("http response",json.toString());

        return json;
    }
    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        pBar.dismiss();

        super.onPostExecute(jsonObject);

    }
}