package com.projetos.lucaschr.projeto01.denuncia;

/**
 * Created by lucas on 16/11/16.
 */

public class Denuncia {

    private Long id;
    private String categoria;
    private String descricao;
    private String foto;
    private String latitude;
    private String longitude;

    public static final String ID = "_id";
    public  static final String CATEGORIA = "den_categoria";
    public static  final String DESCRICAO = "den_descricao";
    public  static final String FOTO = "den_img";
    public static final String LATITUDE = "den_latitude";
    public static final String LONGITUDE = "den_longitude";

    public static final String TABELA = "cidadelimpa";
    public static final String[] COLUNAS = {ID,CATEGORIA,DESCRICAO,FOTO,LATITUDE,LONGITUDE};


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
