package com.igti.filesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtTextNome = (EditText)findViewById(R.id.edtNome);
        final EditText edtTextSobrenome = (EditText)findViewById(R.id.edtSobrenome);
        Button btnSalvar = (Button)findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = edtTextNome.getText().toString()+"\n";
                String sobrenome = edtTextSobrenome.getText().toString();
                try {
                    FileOutputStream fileOutputStream = openFileOutput("usuarios", Context.MODE_PRIVATE);
                    fileOutputStream.write(nome.getBytes());
                    fileOutputStream.write(sobrenome.getBytes());
                    fileOutputStream.close();

                    Toast.makeText(MainActivity.this, "Usuario salvo com sucesso",Toast.LENGTH_LONG).show();

                    startActivity(new Intent(MainActivity.this,UsuarioActivity.class));

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}