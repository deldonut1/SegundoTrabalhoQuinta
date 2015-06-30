package br.com.ufg.segundotrabalhoquinta.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import br.com.ufg.segundotrabalhoquinta.R;


public class Login_activity extends ActionBarActivity {

    Button loginButton;
    EditText editTextUsuario;
    EditText editTextSenha;

    public static HashMap<String, String> listaContas = new HashMap<String, String>(){{
        put("admin","admin");
        put("root","123");
        put("Ayrton","Denner");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        editTextUsuario = (EditText) findViewById(R.id.editTextUsuario);
        editTextSenha = (EditText) findViewById(R.id.editTextSenha);

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Carregando...", Toast.LENGTH_SHORT).show();

                String conta = listaContas.get(editTextUsuario.getText().toString());

                if(conta != null)
                {
                    if(conta.toString().equals(editTextSenha.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(), "Correto!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), WaitingActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Essa senha nao procede!", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Usuario nao existente!", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
