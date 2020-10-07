package com.example.listapc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listapc.models.Producto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView lvProductos;
    private ProductoAdapter adaptador;
    private List<Producto> listaProductos;


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
                Toast.makeText(MainActivity.this, "Actualizar", Toast.LENGTH_SHORT).show();

                return true;
            case R.id.Atras:
                Toast.makeText(MainActivity.this, "Atras", Toast.LENGTH_SHORT).show();

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProductos = findViewById(R.id.lvProductos);
        List<Producto> listaProductos = new ArrayList<>();

        this.cargarDatos(listaProductos);

        adaptador = new ProductoAdapter(listaProductos);


        lvProductos.setAdapter(new ProductoAdapter(listaProductos));

        lvProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                //Toast.makeText(MainActivity.this, "Clik en elemento" + i, Toast.LENGTH_SHORT).show();
                cargaDetalle(i);
            }
        });


    }

    private void cargaDetalle(int i){
        Producto producto = adaptador.getItem(i);
        Intent intent = new Intent(MainActivity.this, DetalleActivity.class);

        intent.putExtra("E_ID", producto.getId());
        intent.putExtra("E_NOMBRE", producto.getNombre());
        intent.putExtra("E_PRECIO", producto.getPrecio());
        intent.putExtra("E_DESCRIPCION", producto.getDescripcion());

        startActivity(intent);





    }


    private void cargarDatos(List<Producto> listaProductos) {

        listaProductos.add(new Producto(1, "PC Gamer completa", 52.999f, "MICRO: AMD RYZEN 5 3400\n" + "VIDEO: RX VEGA 11\n" + "MOTHER: A320 - DDR4 - USB 3.0 - SATA3\n" + "DISCO: 240GB SSD\n" + "MEMORIA RAM: 8GB 2400MHZ DDR4\n" + "GABINETE KIT: ATX (TECLADO MOUSE PARLANTES)", 0));
        listaProductos.add(new Producto(2, "CPU Gamer", 32.892f, "Procesador AMD A8 9600 Quad Core 3.1/3.4Ghz\n" + "Mother A320 con salida HDMI\n" + "Memoria 4GB DDR4\n" + "Disco Solido SSD 120Gb\n" + "Gabinete ATX Black tipo Sentey G28 o similar con fuente acorde al equipo\n" + "Placa de Video Radeon R7 Incluida en el procesador", 0));
        listaProductos.add(new Producto(3, "Mouse de juego Logitech Prodigy G Series G203 negro", 5.660f, "Sensor óptico.\n" + "Resolución: 8000dpi.\n" + "Contiene cable.\n" + "Cuenta con 6 botones.\n" + "Con luces.\n" + "Creado para llevar a todas partes.", 0));
        listaProductos.add(new Producto(4, "Mouse de juego Razer Viper Mini negro", 8.849f, "Sensor óptico.\n" + "Resolución: 8500dpi.\n" + "Contiene cable.\n" + "Cuenta con 6 botones.\n" + "Con luces.\n" + "Creado para llevar a todas partes.", 0));
        listaProductos.add(new Producto(5, "Teclado gamer Redragon Visnu K561 QWERTY OUTEMU Blue español latinoamérica de color negro con luz rainbow", 6.269f, "Es resistente a salpicaduras, por lo que tomar bebibas mientras navegás ya no será un inconveniente.\n" + "Tipo mecánico.\n" + "Forma de las teclas: cilíndrica.\n" + "Función anti-ghosting integrada, para evitar fallas al tocar varias teclas al mismo tiempo.\n" + "Tipo de conector: USB.\n" + "Peso: 1.4kg.\n" + "Medidas de 16.5cm de alto, por 36.3cm de ancho, por 3.3cm de profundidad.\n" + "Indispensable para tu actividades diarias.\n" + "Imágenes ilustrativas.", 0));
        listaProductos.add(new Producto(6, "Teclado gamer inalámbrico Nisuta NSKBGZ61 QWERTY OUTEMU Brown español España de color negro con luz RGB", 7.999f, "Tipo mecánico.\n" + "Forma de las teclas: cilíndrica.\n" + "Al ser inálambrico vas a poder utilizarlo desde la ubicación que desees sin necesidad de conectar cables molestos.\n" + "Función anti-ghosting integrada, para evitar fallas al tocar varias teclas al mismo tiempo.\n" + "También es compatible con conector USB.\n" + "Indispensable para tu actividades diarias.\n" + "Imágenes ilustrativas.", 0));
        listaProductos.add(new Producto(7, "Monitor curvo Samsung C24RG50FQL led 23.5 negro 110V/220V", 41.297f, "Pantalla led.\n" + "Tamaño: 23.5\".\n" + "Curvo.\n" + "Tiene una resolución de 1920px-1080px.\n" + "Su brillo es de 250cd/m².\n" + "Tipos de conexión: DisplayPort, HDMI.", 0));
        listaProductos.add(new Producto(8, "Monitor ViewSonic XG2401 led 24 negro 100V/240V", 91.299f, "Frecuencia de refresco: 144 Hz\n" + "Tipo de pantalla: LED\n" + "Tipo de resolución: Full HD\n" + "Resolución de la pantalla: 1920 px x 1080 px\n" + "Conexiones del monitor: DisplayPort, HDMI, USB\n" + "Tecnología de la pantalla: TN\n" + "Relación de aspecto: 16:9\n" + "Contraste: 1000:1\n" + "Ángulo de visión horizontal: 170°\n" + "Ángulo de visión vertical: 160°\n" + "Brillo: 350 cd/m²\n" + "Tiempo de respuesta: 1 ms\n" + "Con altavoces incorporados: Sí", 0));

    }
}