package com.example.daoud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daoud.model.Client;
import com.example.daoud.siwar_models.R;

import java.util.ArrayList;

/**
 * Created by daoud on 09/02/2016.
 */
public class ClientAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<Client> data;
    private LayoutInflater inflater;

    public ClientAdapter(Context context, int layout, ArrayList<Client> data) {
        this.context = context;
        this.layout = layout;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View itemView = new View(context);

        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView=inflater.inflate(layout,null);

        TextView textViewCin= (TextView) itemView.findViewById(R.id.textViewCin);
        TextView textViewNomClient=(TextView) itemView.findViewById(R.id.textViewNomClient);
        TextView textViewAdresse=(TextView) itemView.findViewById(R.id.textViewAdresse);
        TextView textViewTelephone=(TextView) itemView.findViewById(R.id.textViewTelephone);
        Client tmpClient = data.get(i);
        textViewCin.setText(tmpClient.getCin()+"");
        textViewNomClient.setText(tmpClient.getNomclient());
        textViewAdresse.setText(tmpClient.getAdresse());
        textViewTelephone.setText(tmpClient.getTelephone());

        return itemView;
    }
}
