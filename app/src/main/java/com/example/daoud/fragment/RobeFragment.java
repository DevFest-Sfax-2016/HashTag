package com.example.daoud.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.daoud.model.Robe;
import com.example.daoud.wedding_dresses.R;
import com.example.daoud.task.InsertRobeTask;
import com.example.daoud.task.UpdateRobeTask;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/* * A placeholder fragment containing a simple view.
 */
public class RobeFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    EditText editTextDress;
    private DatabaseReference mDatabase;
    EditText editTextDesig;
    EditText editTextPrix;

    ImageButton imagebuttonAjout;
    ImageButton imagebuttonModif;
    ImageButton imagebuttonSupp;
    ImageButton imagebuttonAffiche;

    public RobeFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static RobeFragment newInstance(int sectionNumber) {
        RobeFragment fragment = new RobeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_robe, container, false);
        editTextDress = (EditText) rootView.findViewById(R.id.editTextDress);
        editTextDesig = (EditText) rootView.findViewById(R.id.editTextDesig);
        editTextPrix = (EditText) rootView.findViewById(R.id.editTextPrix);

        imagebuttonAjout = (ImageButton) rootView.findViewById(R.id.imageButtonAjout);
        imagebuttonModif = (ImageButton) rootView.findViewById(R.id.imageButtonModif);
        imagebuttonSupp = (ImageButton) rootView.findViewById(R.id.imageButtonSupp);
        imagebuttonAffiche = (ImageButton) rootView.findViewById(R.id.imagebuttonAffiche);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        imagebuttonAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Robe tmpRobe = new Robe();
                tmpRobe.setNumrobe(editTextDress.getText().toString());
                tmpRobe.setDesignation(editTextDesig.getText().toString());
                tmpRobe.setPrixtotal(Integer.parseInt(editTextPrix.getText().toString()));*/
                if (!editTextPrix.getText().toString().isEmpty() && !editTextDress.getText().toString().isEmpty() && editTextDesig.getText().toString().isEmpty()) {
                    int aux = Integer.parseInt(editTextPrix.getText().toString());
                    writeNewUser(editTextDress.getText().toString(), editTextDesig.getText().toString(), aux);
                } else {
                    Toast.makeText(getContext().getApplicationContext(), "Verifier les champs", Toast.LENGTH_LONG).show();
                }

                //    new InsertRobeTask(getActivity(),tmpRobe).execute();

            }
        });
        imagebuttonModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Robe tmpRobe = new Robe();
                tmpRobe.setNumrobe(editTextDress.getText().toString());
                tmpRobe.setDesignation(editTextDesig.getText().toString());
                tmpRobe.setPrixtotal(Integer.parseInt(editTextPrix.getText().toString()));

                new UpdateRobeTask(getActivity(), tmpRobe);
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

    private void writeNewUser(String numrobe, String designation, int prixtotal) {
        Robe robe = new Robe(numrobe, designation, prixtotal);

        mDatabase.child("users").push().setValue(robe);
        //    mDatabase.child("users").push().setValue(user);


    }
}

