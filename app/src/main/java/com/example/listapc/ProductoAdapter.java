package com.example.listapc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listapc.models.Producto;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductoAdapter extends BaseAdapter {

    private List<Producto> listaProductos;

    public ProductoAdapter(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public int getCount() {
        return listaProductos.size();
    }

    @Override
    public Producto getItem(int i) {
        return listaProductos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return getItem(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        View view;

        if(convertView==null){

             view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        }
        else {
            view = convertView;

        }


        Producto producto = getItem(i);
        ImageView imgProducto = view.findViewById(R.id.imgProducto);
        TextView txtProductoNombre = view.findViewById(R.id.txtProductoNombre);
        TextView txtProductoDescrip = view.findViewById(R.id.txtProductoDescrip);
        TextView txtProductoPrecio = view.findViewById(R.id.txtProductoPrecio);


        //imgProducto.setImageResource(producto.getImagen());
        txtProductoNombre.setText(producto.getNombre());
        txtProductoDescrip.setText(producto.getDescripcion());
        txtProductoPrecio.setText(String.valueOf("$"+ producto.getPrecio()));
        Picasso.get().load("https://img2.freepng.es/20180619/xae/kisspng-megaport-pc-gamer-amd-fx-6100-gaming-computer-desk-spec-5b28e48c9b4b21.4764759715294066046361.jpg").into(imgProducto);



        return view;
    }
}
