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

    private DbHelper dbHelper;
    private SQLiteDatabase db;
    private Context ctx;




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

        this.ctx = this.getApplicationContext();

        Intent i = getIntent();

        int id = i.getIntExtra("ID",0);

        getSupportActionBar().setTitle("CARGAR PRODUCTO");

        findViewsById();

        //abrimos db en modo escritura
        dbHelper = new DbHelper(this.ctx);
        db = dbHelper.getWritableDatabase();

        if(id!=0){
            Toast.makeText(ctx, "seleccionó: "+ id, Toast.LENGTH_SHORT).show();
            cargarItemSqlite(id);
        }

    }


    private void findViewsById() {
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
        switch (v.getId()){
            case R.id.btnCancelar:
                Intent intent = new Intent(CargaProducto.this, MainActivity.class);
                startActivity(intent);

                finish();
                break;
            case R.id.btnPublicar:
                agregarItemSqlite();

                break;
        }
    }

    private void cargarItemSqlite(int idProducto) {
        // obtenemos datos de SQLite
        //String consulta = "SELECT * FROM Empleados WHERE idempleado="+ ID;

        //seleccionamos todos los registros
        Cursor cursor = db.rawQuery("SELECT * FROM Producto  WHERE idproducto=?", new String[]{String.valueOf(idProducto)});

        //nos posicionamos al inicio del curso
        if(cursor!=null && cursor.moveToLast()) {

            //iteramos todos los registros del cursor y llenamos array con registros
            edtCargaTitulo.setText(cursor.getString(cursor.getColumnIndex("nombre")));
            edtCargaDescripcion.setText(cursor.getString(cursor.getColumnIndex("descripcion")));
            edtCargaPrecio.setText(cursor.getString(cursor.getColumnIndex("precio")));



        }else{
            Toast.makeText(ctx, "No hay registros", Toast.LENGTH_SHORT).show();
        }

        db.close();

    }



    private void agregarItemSqlite(){

        // verificamos que los valores sean validos
        if(validarItems()){

            ContentValues nuevoRegistro = new ContentValues();
            nuevoRegistro.put("nombre", edtCargaTitulo.getText().toString());
            nuevoRegistro.put("descripcion",edtCargaDescripcion.getText().toString());
            nuevoRegistro.put("precio",edtCargaPrecio.getText().toString());

            //insertamos registro nuevo
            db.insert("Producto", null, nuevoRegistro);

            Toast.makeText(ctx, "Registro Grabado OK", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(ctx, "Verifique datos inválidos", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validarItems(){
        // TODO: completar validaciones necesarias pre-grabación del empleado
        boolean valido=true;
        // campo nombre requerido
        if(edtCargaTitulo.getText().toString().isEmpty()){
            valido=false;
            edtCargaTitulo.setError("Debe completar este campo");
        }
        // campo descripcion requerido
        if(edtCargaDescripcion.getText().toString().isEmpty()){
            valido=false;
            edtCargaDescripcion.setError("Debe completar este campo");
        }
        // campo precio requerido
        if(edtCargaPrecio.getText().toString().isEmpty()){
            valido=false;
            edtCargaPrecio.setError("Debe completar este campo");
        }
        return valido;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}

