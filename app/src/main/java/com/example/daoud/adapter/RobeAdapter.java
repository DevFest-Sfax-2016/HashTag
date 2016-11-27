package com.example.daoud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.daoud.model.Robe;
import com.example.daoud.wedding_dresses.R;

import java.util.ArrayList;

/**
 * Created by daoud on 09/02/2016.
 */
public class RobeAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<Robe> data;
    private LayoutInflater inflater;

    public RobeAdapter(Context context, int layout, ArrayList<Robe> data) {
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView = inflater.inflate(layout, null);

        TextView textViewDesignation = (TextView) itemView.findViewById(R.id.textViewDesignation);
        TextView textViewNumrobe = (TextView) itemView.findViewById(R.id.textViewNumrobe);
        TextView textViewPrix = (TextView) itemView.findViewById(R.id.textViewPrix);

        Robe tmpRobe = data.get(i);

        textViewNumrobe.setText(tmpRobe.getNumrobe());
        textViewDesignation.setText(tmpRobe.getDesignation());
        textViewPrix.setText(tmpRobe.getPrixtotal() + "");

        return itemView;
    }
}