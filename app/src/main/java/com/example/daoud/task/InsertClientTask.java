package com.example.daoud.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.daoud.model.Client;
import com.example.daoud.siwar_models.Menus;
import com.example.daoud.siwar_models.R;
import com.example.daoud.util.HostServer;
import com.example.daoud.util.JSONParser;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by daoud on 06/02/2016.
 */
public class InsertClientTask extends AsyncTask<String,Integer,Boolean> {
    Context context;
    Client tmpClient;
    private ProgressDialog pBar;
    private boolean statuts;

    public InsertClientTask(Context context, Client tmpClient) {
        this.context = context;
        this.tmpClient = tmpClient;
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

        JSONParser jParser=new JSONParser();
        ArrayList<NameValuePair> data=new ArrayList<NameValuePair>();
        data.add(new BasicNameValuePair("cin",tmpClient.getCin()+""));
        data.add(new BasicNameValuePair("nom client",tmpClient.getNomclient()));
        data.add(new BasicNameValuePair("adresse",tmpClient.getAdresse()));
        data.add(new BasicNameValuePair("telephone",tmpClient.getTelephone()));

        JSONObject json=jParser.makeHttpRequest("http://"+ HostServer.IP+"/RestAPI.svc/InsertClient/"+tmpClient.getCin()+"/"+tmpClient.getNomclient()+"/"+tmpClient.getAdresse()+"/"+tmpClient.getTelephone(),"GET",data);

        try {
            int success=json.getInt("success");
            if(success==1)
            {
                statuts=true;
            }
            else
            {
                statuts=false;
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

        if (statuts==true)
        {
            Toast.makeText(context,"Insert success",Toast.LENGTH_LONG).show();
            Intent iHome=new Intent(context, Menus.class);
            context.startActivity(iHome);
        }
        else
        {
            Toast.makeText(context,"Error Insert",Toast.LENGTH_LONG).show();
        }
    }
}