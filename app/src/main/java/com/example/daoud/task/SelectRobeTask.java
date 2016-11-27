package com.example.daoud.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import com.example.daoud.adapter.RobeAdapter;
import com.example.daoud.model.Robe;
import com.example.daoud.wedding_dresses.R;
import com.example.daoud.util.HostServer;
import com.example.daoud.util.JSONParser;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by daoud on 11/02/2016.
 */
public class SelectRobeTask extends AsyncTask<String,Integer,JSONObject> {
    Context context;
    ArrayList<Robe> data;
    ListView listViewRobe;
    Robe tmpRobe;
    private ProgressDialog pBar;
    private RobeAdapter adapter;

    public SelectRobeTask(Context context ,ArrayList<Robe> data,ListView listViewRobe) {
        this.data=data;
        this.context = context;
        this.listViewRobe=listViewRobe;
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

        JSONObject json=jParser.makeHttpRequest("http://"+ HostServer.IP+"/RestAPI.svc/AfficheRobe/"+tmpRobe.getNumrobe(),"GET",data);

        return json;
    }
    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        pBar.dismiss();
        try {
            //2
            JSONArray Robes = jsonObject.getJSONArray("Robe");
            for(int i=0;i<Robes.length();i++)
            {
                JSONObject tmpRobe = Robes.getJSONObject(i);
                int pirxtotal =tmpRobe.getInt("pirxtotal");
                String designation=tmpRobe.getString("designation");
                String numrobe=tmpRobe.getString("numrobe");


                Robe dataRobe = new Robe();

                dataRobe.setNumrobe(numrobe);
                dataRobe.setDesignation(designation);
                dataRobe.setPrixtotal(pirxtotal);

                data.add(dataRobe);
            }
            //3
            adapter=new RobeAdapter(context, R.layout.prototyperobe,data);
            //4
            listViewRobe.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        super.onPostExecute(jsonObject);

    }
}
