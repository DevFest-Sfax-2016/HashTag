package com.example.daoud.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.daoud.model.Client;
import com.example.daoud.siwar_models.R;
import com.example.daoud.task.DeleteClientTask;
import com.example.daoud.task.DeleteOperationTask;
import com.example.daoud.task.InsertClientTask;
import com.example.daoud.task.UpdateClientTask;


/* * A placeholder fragment containing a simple view.
 */
public  class ClientFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    EditText editTextCin;
    EditText editTextNameClt;
    EditText editTextAdresse;
    EditText editTextTel;

    ImageButton imagebuttonAjout;
    ImageButton imagebuttonModif;
    ImageButton imagebuttonSupp;
    ImageButton imagebuttonAffiche;

    public ClientFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ClientFragment newInstance(int sectionNumber) {
        ClientFragment fragment = new ClientFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_client, container, false);
        editTextCin=(EditText)rootView.findViewById(R.id.editTextCin);
        editTextNameClt=(EditText)rootView.findViewById(R.id.editTextNameClt);
        editTextAdresse=(EditText)rootView.findViewById(R.id.editTextAdresse);
        editTextTel=(EditText)rootView.findViewById(R.id.editTextTel);

        imagebuttonAjout=(ImageButton)rootView.findViewById(R.id.imageButtonAjout);
        imagebuttonModif=(ImageButton)rootView.findViewById(R.id.imageButtonModif);
        imagebuttonSupp=(ImageButton)rootView.findViewById(R.id.imageButtonSupp);
        imagebuttonAffiche=(ImageButton)rootView.findViewById(R.id.imagebuttonAffiche);


        imagebuttonAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Client tmpClient = new Client();
                String  varContent=editTextCin.toString();
                if (varContent.equals("")|| varContent.length()<8)
                {
                    tmpClient.setCin(Integer.parseInt(editTextCin.getText().toString()));
                }
                else
                {
                    tmpClient.setNomclient(editTextNameClt.getText().toString());
                    tmpClient.setAdresse(editTextAdresse.getText().toString());
                    tmpClient.setTelephone(editTextTel.getText().toString());
                }
                new InsertClientTask(getActivity(),tmpClient).execute();

            }
        });
        imagebuttonModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Client tmpClient = new Client();
                String  varContent=editTextCin.toString();
                if (varContent.equals("")|| varContent.length()<8)
                {
                    tmpClient.setCin(Integer.parseInt(editTextCin.getText().toString()));
                }
                else
                {
                    tmpClient.setNomclient(editTextNameClt.getText().toString());
                    tmpClient.setAdresse(editTextAdresse.getText().toString());
                    tmpClient.setTelephone(editTextTel.getText().toString());
                }

                new UpdateClientTask(getActivity(),tmpClient).execute();
            }
        });
        imagebuttonSupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Client tmpClient = new Client();
                tmpClient.setCin(Integer.parseInt(editTextCin.getText().toString()));
                tmpClient.setNomclient(editTextNameClt.getText().toString());
                tmpClient.setAdresse(editTextAdresse.getText().toString());
                tmpClient.setTelephone(editTextTel.getText().toString());

                new DeleteClientTask(getActivity(),tmpClient).execute();
            }
        });
        imagebuttonAffiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return rootView;
    }

}

