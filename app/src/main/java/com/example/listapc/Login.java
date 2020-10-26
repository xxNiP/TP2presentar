package com.example.listapc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import com.squareup.picasso.Picasso;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private Button btnIngresar;
    private ImageView imgLogin;
    private EditText edtEmail, edtPw;
    private Switch swtRecordar;

    private SharedPreferences preferences;
    public static final String PREFS_NAME = "mis_preferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setTitle("Iniciar Sesion");
        // getSupportActionBar().hide();

        findViewsById();

        // operaciones con shared preferences
        preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String email = preferences.getString("nombreUsuario","");
        String password = preferences.getString("passwordUsuario","");


        // cargamos controles con prefs obtenidas o valores por defecto
        this.cargarCredencialesPrefs(password, email);
    }

    private void findViewsById() {
        btnIngresar = findViewById(R.id.btnIngresar);
        edtEmail = findViewById(R.id.edtEmail);
        edtPw = findViewById(R.id.edtPw);
        swtRecordar = findViewById(R.id.swtRecordar);
        imgLogin = findViewById(R.id.imgLogin);
        Picasso.get().load("https://media.istockphoto.com/illustrations/login-icon-glassy-purple-round-button-illustration-id1169619637").into(imgLogin);

        btnIngresar.setOnClickListener(this);
    }

    private void cargarCredencialesPrefs(String password, String email){
        edtPw.setText(password);
        edtEmail.setText(email);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnIngresar:

                // si esta activo recordar guardamos credenciales, sino las limpiamos
                if(swtRecordar.isChecked()){
                    this.grabarCredencialesPrefs(edtPw.getText().toString(), edtEmail.getText().toString());
                }else{
                    this.limpiarCredencialesPrefs();
                }

                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);

        }
    }

    private void grabarCredencialesPrefs(String password, String email){
        SharedPreferences.Editor editor = preferences.edit();
        // OJO: encriptar password antes de almacenar
        String p = Utils.convertirSHA256(password);
        editor.putString("passwordUsuario", p);
        editor.putString("emailUsuario", email);
        editor.commit();
        //notificacion Mediante Snackbar -> requiere Support Design Library
        // Snackbar.make(findViewById(R.id.main_layout),"Valores Grabados OK",Snackbar.LENGTH_SHORT).show();

    }

    private void limpiarCredencialesPrefs(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
        edtPw.setText("");
        edtEmail.setText("");
        //notificacion Mediante Snackbar -> requiere Support Design Library
        // Snackbar.make(findViewById(R.id.main_layout),"Valores Borrados OK",Snackbar.LENGTH_SHORT).show();
    }
}