package com.example.listapc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class CargaProducto extends AppCompatActivity {

    private EditText edtCargaTitulo, edtCargaDescripcion, edtCargaPrecio;
    private Switch swtEnvio;
    private Button btnImagen;


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


        private void findViews(){
            edtCargaTitulo = findViewById(R.id.edtCargaTitulo);
            edtCargaDescripcion = findViewById(R.id.edtCargaDescripcion);
            edtCargaPrecio = findViewById(R.id.edtCargaPrecio);
            swtEnvio = findViewById(R.id.swtEnvio);
            btnImagen = findViewById(R.id.btnImagen);

            btnImagen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(CargaProducto.this, "Cargaria Imagen", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
