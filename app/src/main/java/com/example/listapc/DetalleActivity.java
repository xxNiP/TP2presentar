package com.example.listapc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetalleActivity extends AppCompatActivity {

    private TextView txtProductoNombreD, txtProductoDescripD, txtProductoPrecioD;
    private ImageView imgProductoD;
    private Button btnCompra;


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
            case R.id.Refresh:
                Toast.makeText(DetalleActivity.this, "Actualizar", Toast.LENGTH_SHORT).show();

                return true;
            case R.id.Atras:
                Toast.makeText(DetalleActivity.this, "Atras", Toast.LENGTH_SHORT).show();

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        getSupportActionBar().setTitle("Producto");
        findViews();

        Intent intent =getIntent();

        Bundle extras = intent.getExtras();
        txtProductoDescripD.setText(extras.getString("E_DESCRIPCION"));
        txtProductoNombreD.setText(extras.getString("E_NOMBRE"));
        txtProductoPrecioD.setText("$"+String.valueOf(extras.getFloat("E_PRECIO")));
        Picasso.get().load("https://http2.mlstatic.com/D_NQ_NP_634540-MLA42609806883_072020-W.jpg"+extras.getInt("E_ID")).into(imgProductoD);

    }

    private void findViews(){
        txtProductoPrecioD = findViewById(R.id.txtProductoPrecioD);
        txtProductoNombreD = findViewById(R.id.txtProductoNombreD);
        txtProductoDescripD = findViewById(R.id.txtProductoDescripD);
        imgProductoD = findViewById(R.id.imgProductoD);
        btnCompra = findViewById(R.id.btnCompra);

        btnCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetalleActivity.this, "Compra", Toast.LENGTH_SHORT).show();
            }
        });



    }
}