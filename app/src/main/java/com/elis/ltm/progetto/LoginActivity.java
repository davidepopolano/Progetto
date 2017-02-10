package com.elis.ltm.progetto;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity implements View.OnClickListener {

    EditText usernameET;
    EditText passwordET;
    Button loginBtn;
    String usernameprova;
    String passwordprova;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //link activity to layout
        setContentView(R.layout.activity_login);
        // assing xml to item
        usernameET = (EditText) findViewById(R.id.login_et_email);
        passwordET = (EditText) findViewById(R.id.login_et_passw);
        loginBtn = (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(this);
        usernameprova ="davide@popolano.it";
        passwordprova ="provapassword";
    }
    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.login_btn) {
            String name = usernameET.getText().toString();
            String password = passwordET.getText().toString();
            if (onLogin(name, password)) {
                Toast.makeText(LoginActivity.this, getString(R.string.login_succ), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        }
    }

    public boolean onLogin(String username, String password) {
        if(!username.equals(usernameprova)||!password.equals(passwordprova)) {
            Toast.makeText(LoginActivity.this, getString(R.string.storto), Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }
    }


}
