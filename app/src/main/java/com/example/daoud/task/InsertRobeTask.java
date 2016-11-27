package com.example.daoud.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.daoud.model.Robe;
import com.example.daoud.wedding_dresses.Menus;
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
public class InsertRobeTask extends AsyncTask<String,Integer,Boolean> {
    Context context;
    Robe tmpRobe;
    private ProgressDialog pBar;
    private boolean statuts;

    public InsertRobeTask(Context context, Robe tmpRobe) {
        this.context = context;
        this.tmpRobe = tmpRobe;
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
        data.add(new BasicNameValuePair("num robe", tmpRobe.getNumrobe()));
        data.add(new BasicNameValuePair("designation", tmpRobe.getDesignation()));
        data.add(new BasicNameValuePair("prix totale", tmpRobe.getPrixtotal() + ""));

        JSONObject json = jParser.makeHttpRequest("http://"+ HostServer.IP+"/RestAPI.svc/InsertRobe/"+tmpRobe.getNumrobe()+"/"+tmpRobe.getDesignation()+"/"+tmpRobe.getPrixtotal(), "GET", data);
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