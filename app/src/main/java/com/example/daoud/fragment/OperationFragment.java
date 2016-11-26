package com.example.daoud.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.daoud.model.Client;
import com.example.daoud.model.Operation;
import com.example.daoud.siwar_models.R;
import com.example.daoud.task.DeleteOperationTask;
import com.example.daoud.task.InsertOperationTask;
import com.example.daoud.task.UpdateClientTask;
import com.example.daoud.task.UpdateOperationTask;


/* * A placeholder fragment containing a simple view.
 */
public  class OperationFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    EditText editTextNumOperation;
    EditText editTextCin;
    EditText editTextNameClt;
    EditText editTextDress;
    EditText editTextAvance;
    EditText editTextDate;

    ImageButton imagebuttonAjout;
    ImageButton imagebuttonModif;
    ImageButton imagebuttonSupp;
    ImageButton imagebuttonAffiche;

    public OperationFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static OperationFragment newInstance(int sectionNumber) {
        OperationFragment fragment = new OperationFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_operation, container, false);
        editTextNumOperation=(EditText)rootView.findViewById(R.id.editTextNumOperation);
        editTextCin=(EditText)rootView.findViewById(R.id.editTextCin);
        editTextNameClt=(EditText)rootView.findViewById(R.id.editTextNameClt);
        editTextDress=(EditText)rootView.findViewById(R.id.editTextDress);
        editTextAvance=(EditText)rootView.findViewById(R.id.editTextAvance);
        editTextDate=(EditText)rootView.findViewById(R.id.editTextDate);

        imagebuttonAjout=(ImageButton)rootView.findViewById(R.id.imageButtonAjout);
        imagebuttonModif=(ImageButton)rootView.findViewById(R.id.imageButtonModif);
        imagebuttonSupp=(ImageButton)rootView.findViewById(R.id.imageButtonSupp);
        imagebuttonAffiche=(ImageButton)rootView.findViewById(R.id.imagebuttonAffiche);

        imagebuttonAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operation tmpOperation = new Operation();
                tmpOperation.setNumoperation(editTextNumOperation.getText().toString());
                tmpOperation.setNomclient(editTextCin.getText().toString());
                tmpOperation.setNomclient(editTextNameClt.getText().toString());
                tmpOperation.setNumrobe(editTextDress.getText().toString());
                tmpOperation.setAvance(Integer.parseInt(editTextAvance.getText().toString()));
                tmpOperation.setDatedebut(editTextDate.getText().toString());

                new InsertOperationTask(getActivity(),tmpOperation).execute();

            }
        });
        imagebuttonModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operation tmpOperation = new Operation();
                tmpOperation.setNumoperation(editTextNumOperation.getText().toString());
                tmpOperation.setNomclient(editTextCin.getText().toString());
                tmpOperation.setNomclient(editTextNameClt.getText().toString());
                tmpOperation.setNumrobe(editTextDress.getText().toString());
                tmpOperation.setAvance(Integer.parseInt(editTextAvance.getText().toString()));
                tmpOperation.setDatedebut(editTextDate.getText().toString());

                new UpdateOperationTask(getActivity(),tmpOperation).execute();
            }
        });
        imagebuttonSupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

