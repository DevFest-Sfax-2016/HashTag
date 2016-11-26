package com.example.daoud.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.daoud.siwar_models.R;


/* * A placeholder fragment containing a simple view.
 */
public  class RetourFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    EditText editTextNumOperation;
    EditText editTextNameClt;
    EditText editTextReste;
    EditText editTextAvance;
    EditText editTextPrix;

    ImageButton imagebuttonAjout;
    ImageButton imagebuttonModif;
    ImageButton imagebuttonSupp;
    ImageButton imagebuttonAffiche;

    public RetourFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static RetourFragment newInstance(int sectionNumber) {
        RetourFragment fragment = new RetourFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_retour, container, false);
        editTextNumOperation=(EditText)rootView.findViewById(R.id.editTextNumOperation);
        editTextNameClt=(EditText)rootView.findViewById(R.id.editTextNameClt);
        editTextReste=(EditText)rootView.findViewById(R.id.editTextReste);
        editTextAvance=(EditText)rootView.findViewById(R.id.editTextAvance);
        editTextPrix=(EditText)rootView.findViewById(R.id.editTextPrix);

        imagebuttonAjout=(ImageButton)rootView.findViewById(R.id.imageButtonAjout);
        imagebuttonModif=(ImageButton)rootView.findViewById(R.id.imageButtonModif);
        imagebuttonSupp=(ImageButton)rootView.findViewById(R.id.imageButtonSupp);
        imagebuttonAffiche=(ImageButton)rootView.findViewById(R.id.imagebuttonAffiche);

        return rootView;
    }

}

