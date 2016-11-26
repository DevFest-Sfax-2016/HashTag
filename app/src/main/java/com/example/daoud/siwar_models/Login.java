package com.example.daoud.siwar_models;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {

    EditText editTextUsername;
    EditText editTextPassword;
    Button buttonSing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = (EditText)findViewById(R.id.editTextUsername);
        editTextUsername.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int i, KeyEvent event) {
                if (i == EditorInfo.IME_ACTION_NEXT || i == EditorInfo.IME_ACTION_DONE) {
                    editTextPassword.requestFocus();
                    return true;
                }
                return false;
            }
        });

        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        editTextPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int i, KeyEvent event)
            {
                if (i == EditorInfo.IME_ACTION_DONE) {
                    veriflogin();
                    return true;
                }
                return false;
            }
        });

        buttonSing = (Button)findViewById(R.id.buttonSing);
        buttonSing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veriflogin();
            }
        });
    }

    private void veriflogin()
    {
        String Username=editTextUsername.getText().toString();
        String Password=editTextPassword.getText().toString();

        if (TextUtils.isEmpty(Username))
        {
            editTextUsername.setError(getString(R.string.erreur_Username));
            return;
        }
        else
        if (TextUtils.isEmpty(Password))
        {
            editTextPassword.setError(getString(R.string.erreur_Password));
            return;
        }

        if (Username.equals("siwar") && Password.equals("bassem"))
        {
            Intent page = new Intent(Login.this , Menus.class);
            startActivity(page);
        }
        else
        {
            Toast.makeText(getApplicationContext(),getString(R.string.erreur_invalid),
                    Toast.LENGTH_LONG).show();
        }
    }
}
