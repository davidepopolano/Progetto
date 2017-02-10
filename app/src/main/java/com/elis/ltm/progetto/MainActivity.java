package com.elis.ltm.progetto;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    Button call;
    Button go;
    TextView numero;
    TextView via;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //view activity_main
        setContentView(R.layout.activity_main);

        call = (Button) findViewById(R.id.call_btn);
        go = (Button) findViewById(R.id.go_btn);
        numero = (TextView) findViewById(R.id.numerotelefono);
        via = (TextView) findViewById(R.id.address);
        call.setOnClickListener(this);
        go.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.call_btn){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri uri = Uri.parse("tel:" + numero.getText().toString());
            intent.setData(uri);
            startActivity(intent);
        }else if(v.getId() == R.id.go_btn){

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri uri = Uri.parse("geo:0,0?q=" + via.getText().toString());
            intent.setData(uri);
            startActivity(intent);
        }




    }
}
