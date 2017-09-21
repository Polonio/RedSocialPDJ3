package es.cice.redsocialpdj3;

/**
 * Created by cice on 21/9/17.
 */

public class Publicacion {

    private int id_user;
    private String img;
    private String texto;
    private String fecha;
    private int like;
    private int coments;

    public Publicacion(int id_user, String img, String texto, String fecha, int like, int coments) {
        this.id_user = id_user;
        this.img = img;
        this.texto = texto;
        this.fecha = fecha;
        this.like = like;
        this.coments = coments;
    }


    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getComents() {
        return coments;
    }

    public void setComents(int coments) {
        this.coments = coments;
    }
}
