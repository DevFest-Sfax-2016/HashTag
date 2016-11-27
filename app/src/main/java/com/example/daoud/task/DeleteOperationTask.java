package com.example.daoud.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.daoud.model.Operation;
import com.example.daoud.util.HostServer;
import com.example.daoud.util.JSONParser;

import org.apache.http.NameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by daoud on 06/02/2016.
 */
public class DeleteOperationTask extends AsyncTask<String,Integer,JSONObject> {
    Context context;
    Operation tmpOperation;
    private ProgressDialog pBar;

    public DeleteOperationTask(Context context ,Operation tmpOperation) {
        this.tmpOperation=tmpOperation;
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


        JSONObject json=jParser.makeHttpRequest("http://"+ HostServer.IP+"/RestAPI.svc/DeleteOperation/"+tmpOperation.getNumoperation(),"GET",data);

        Log.e("http response", json.toString());

        return json;
    }
    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        pBar.dismiss();

        super.onPostExecute(jsonObject);

    }
}