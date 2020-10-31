package com.example.listapc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class CargaProducto extends AppCompatActivity implements View.OnClickListener {

    private EditText edtCargaTitulo, edtCargaDescripcion, edtCargaPrecio;
    private Switch swtEnvio;
    private Button btnImagen, btnCancelar, btnPublicar;




    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Salir:
                finish();
                return true;

            case R.id.Atras:
                finish();

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_producto);
    }


    private void findViews() {
        edtCargaTitulo = findViewById(R.id.edtCargaTitulo);
        edtCargaDescripcion = findViewById(R.id.edtCargaDescripcion);
        edtCargaPrecio = findViewById(R.id.edtCargaPrecio);
        swtEnvio = findViewById(R.id.swtEnvio);
        btnImagen = findViewById(R.id.btnImagen);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnPublicar = findViewById(R.id.btnPublicar);

        // clic listeners
        btnCancelar.setOnClickListener(this);
        btnPublicar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCancelar:
                Intent intent = new Intent(CargaProducto.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btnPublicar:

                break;
        }

    }
}

