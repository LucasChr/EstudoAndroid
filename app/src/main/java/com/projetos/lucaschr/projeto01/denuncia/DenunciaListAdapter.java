package com.projetos.lucaschr.projeto01.denuncia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.projetos.lucaschr.projeto01.R;

import java.util.List;

/**
 * Created by lucas on 23/11/16.
 */

public class DenunciaListAdapter extends ArrayAdapter<Denuncia> {

    int layout;
    Context context;
    List<Denuncia> denuncias;

    public DenunciaListAdapter(Context context, int layout, List<Denuncia> denuncias) {
        super(context, layout, denuncias);
        this.context = context;
        this.layout = layout;
        this.denuncias = denuncias;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(layout, null);

        TextView tvCategoria = (TextView) itemView.findViewById(R.id.fragment_denuncia_list_item_tvCategoria);
        TextView tvDescricao = (TextView) itemView.findViewById(R.id.fragment_denuncia_list_item_tvDescricao);

        final Denuncia denuncia = denuncias.get(position);
        tvCategoria.setText(denuncia.getCategoria());
        tvDescricao.setText(denuncia.getDescricao());

        return itemView;
    }
}
