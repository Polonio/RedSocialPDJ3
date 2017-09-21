package es.cice.redsocialpdj3;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cice on 21/9/17.
 */

public class PubListViewAdapter extends ArrayAdapter<Publicacion> {

    static class ViewHolder {
        protected TextView texto;
        protected TextView publicadoEl;
        protected TextView meGustas;
        protected TextView comentarios;
        protected TextView fecha;
        protected TextView cantidadLikes;
        protected TextView cantidadComents;
        protected TextView usuario;
        protected ImageView imagenUser;
        protected ImageView imagenPub;
        protected Button meGusta;
        protected Button compartir;

        protected LinearLayout ll;

    }


    private Activity ctx = null;
    private ArrayList<Publicacion> modelo;

    public PubListViewAdapter(Activity ctx, ArrayList<Publicacion> modelo) {
        super(ctx, R.layout.list_view, modelo);
        this.ctx = ctx;
        this.modelo = modelo;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            row = ctx.getLayoutInflater().inflate(R.layout.list_view, null);

            ViewHolder vh = new ViewHolder();
            vh.texto = (TextView) row.findViewById(R.id.coment);
            vh.fecha = (TextView) row.findViewById(R.id.fecha);
            vh.cantidadComents = (TextView) row.findViewById(R.id.cantidadComentario);
            vh.cantidadLikes = (TextView) row.findViewById(R.id.cantidadLikes);
            vh.usuario = (TextView) row.findViewById(R.id.nombreUser);
            vh.imagenUser = (ImageView) row.findViewById(R.id.imageUser);
            vh.imagenPub = (ImageView) row.findViewById(R.id.imagePub);
            vh.publicadoEl = (TextView) row.findViewById(R.id.publicado_el);
            vh.meGustas = (TextView) row.findViewById(R.id.meGustas);

            vh.meGusta = (Button) row.findViewById(R.id.btn_megusta);
            vh.compartir = (Button) row.findViewById(R.id.btn_compartir);

            vh.ll = (LinearLayout) row.findViewById(R.id.pubLayout);
            row.setTag(vh);
        }

        ViewHolder vh = (ViewHolder) row.getTag();
        vh.publicadoEl = (TextView) row.findViewById(R.id.publicado_el);
        vh.meGustas = (TextView) row.findViewById(R.id.meGustas);

        vh.meGusta = (Button) row.findViewById(R.id.btn_megusta);
        vh.compartir = (Button) row.findViewById(R.id.btn_compartir);

        vh.ll = (LinearLayout) row.findViewById(R.id.pubLayout);
        Publicacion p = modelo.get(position);



        vh.texto.setText(p.getTexto());
        vh.fecha.setText(p.getFecha());
        //vh.imagenPub.setText(p.getImg().to);



        return row;

    }
}
