package com.example.daoud.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.daoud.model.Operation;
import com.example.daoud.model.Robe;
import com.example.daoud.siwar_models.Menus;
import com.example.daoud.util.HostServer;
import com.example.daoud.util.JSONParser;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by daoud on 06/02/2016.
 */
public class InsertOperationTask extends AsyncTask<String,Integer,Boolean> {
    Context context;
    Operation tmpOperation;
    private ProgressDialog pBar;
    private boolean statuts;

    public InsertOperationTask(Context context, Operation tmpOperation) {
        this.context = context;
        this.tmpOperation = tmpOperation;
    }

    @Override
    protected void onPreExecute() {

        pBar = new ProgressDialog(context);
        pBar.setMessage("Please Wait ...");
        pBar.show();
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(String... params) {

        JSONParser jParser = new JSONParser();
        ArrayList<NameValuePair> data = new ArrayList<NameValuePair>();
        data.add(new BasicNameValuePair("num operation", tmpOperation.getNumoperation()));
        data.add(new BasicNameValuePair("num robe", tmpOperation.getNumrobe()));
        data.add(new BasicNameValuePair("cin",tmpOperation.getCin()+""));
        data.add(new BasicNameValuePair("nom client", tmpOperation.getNomclient()));
        data.add(new BasicNameValuePair("avance",tmpOperation.getAvance()+""));
        data.add(new BasicNameValuePair("date debut",tmpOperation.getDatedebut()+""));

        JSONObject json = jParser.makeHttpRequest("http://"+ HostServer.IP+"/RestAPI.svc/InsertOperation/"+tmpOperation.getNumoperation()+"/"+tmpOperation.getNumrobe()+"/"+tmpOperation.getCin()+"/"+tmpOperation.getNomclient()+"/"+tmpOperation.getAvance()+"/"+tmpOperation.getDatedebut(), "GET", data);

        try {
            int success = json.getInt("success");
            if (success == 1) {
                statuts = true;
            } else {
                statuts = false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return statuts;
    }

    @Override
    protected void onPostExecute(Boolean statuts) {
        super.onPostExecute(statuts);
        pBar.dismiss();

        if (statuts == true) {
            Toast.makeText(context, "Insert success", Toast.LENGTH_LONG).show();
            Intent iHome = new Intent(context, Menus.class);
            context.startActivity(iHome);
        } else {
            Toast.makeText(context, "Error Insert", Toast.LENGTH_LONG).show();
        }
    }
}