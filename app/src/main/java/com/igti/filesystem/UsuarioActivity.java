package com.igti.filesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        TextView txtViewDados = (TextView)findViewById(R.id.txtDados);
        Button btnVoltar = (Button)findViewById(R.id.btnVoltar);

        try {
            FileInputStream fileInputStream = openFileInput("usuarios");
            StringBuffer stringBuffer = new StringBuffer();
            int i;
            while((i = fileInputStream.read()) != -1){
                stringBuffer.append((char)i);
            }
            fileInputStream.close();
            String detalhes[] = stringBuffer.toString().split("\n");

            txtViewDados.setText("Nome: "+detalhes[0] + "\nSobrenome: "+detalhes[1]);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UsuarioActivity.this, MainActivity.class));
            }
        });
    }
}