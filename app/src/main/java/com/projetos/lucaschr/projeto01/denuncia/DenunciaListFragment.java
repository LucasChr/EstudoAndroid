package com.projetos.lucaschr.projeto01.denuncia;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.projetos.lucaschr.projeto01.R;

import java.util.List;

public class DenunciaListFragment extends Fragment implements AdapterView.OnItemClickListener {

    List<Denuncia> denuncias;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_denuncia_list,container, false);

        ListView listView = (ListView) view.findViewById(R.id.fragment_denuncia_list_listview);
        listView.setEmptyView(view.findViewById(android.R.id.empty));
        listView.setOnItemClickListener(this);
        //listView.setEmptyView();

        DenunciaDAO denunciaDAO = new DenunciaDAO(getActivity());
        denuncias = denunciaDAO.listar();

        DenunciaListAdapter adapter = new DenunciaListAdapter(getActivity(),
                R.layout.fragment_denuncia_list_item, denuncias);

        listView.setAdapter(adapter);

        return view;
    }

    //Faz abrir o item selecionado em uma lista
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Denuncia denuncia = denuncias.get(position);

        Intent it = new Intent(getActivity(), DenunciaActivity.class);
        String id1 = String.valueOf(getId());
        it.putExtra(Denuncia.ID, id1);
        startActivityForResult(it,1);
    }
}
