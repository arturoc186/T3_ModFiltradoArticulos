
package POJOS;

public class Camisa extends Ropa {
    // atributos de Camisa
    private String tipoDeManga;
    private boolean estampada;

    public Camisa(int codArt, String nombre, float precio, String marca, String descripcion, boolean activo,
                  String imagen, String color, Material material, String talla_ropa, String tipo_cierre,
                  String tipoDeManga, boolean estampada) {
        super(codArt, nombre, precio, marca, descripcion, activo, imagen, color, material, talla_ropa, tipo_cierre);
        this.tipoDeManga = tipoDeManga;
        this.estampada = estampada;
    }

    public Camisa(int codArt, String nombre, float precio, String marca, String descripcion, String talla_ropa,
                  String tipo_cierre, String tipoDeManga, boolean estampada) {
        super(codArt, nombre, precio, marca, descripcion, talla_ropa, tipo_cierre);
        this.tipoDeManga = tipoDeManga;
        this.estampada = estampada;
    }

    public Camisa(int codArt, String nombre, float precio, String talla_ropa, String tipo_cierre,
                  String tipoDeManga, boolean estampada) {
        super(codArt, nombre, precio, talla_ropa, tipo_cierre);
        this.tipoDeManga = tipoDeManga;
        this.estampada = estampada;
    }

    public Camisa(Camisa art) {
        super(art);
        this.tipoDeManga = art.getTipoDeManga();
        this.estampada = art.isEstampada();
    }

    public Camisa(String nombre, float precio, String marca, String descripcion, boolean activo, String imagen,
                  String color, Material material, String talla_ropa, String tipo_cierre,
                  String tipoDeManga, boolean estampada) {
        super(nombre, precio, marca, descripcion, activo, imagen, color, material, talla_ropa, tipo_cierre);
        this.tipoDeManga = tipoDeManga;
        this.estampada = estampada;
    }

    public Camisa(String nombre, float precio, String marca, String descripcion, String talla_ropa, String tipo_cierre,
                  String tipoDeManga, boolean estampada) {
        super(nombre, precio, marca, descripcion, talla_ropa, tipo_cierre);
        this.tipoDeManga = tipoDeManga;
        this.estampada = estampada;
    }

    public Camisa(String nombre, float precio, String talla_ropa, String tipo_cierre, String tipoDeManga,
                  boolean estampada) {
        super(nombre, precio, talla_ropa, tipo_cierre);
        this.tipoDeManga = tipoDeManga;
        this.estampada = estampada;
    }

    public Camisa() {
        super();
        this.estampada = false;
        this.tipoDeManga = "";
    }

    public String getTipoDeManga() {
        return tipoDeManga;
    }

    public void setTipoDeManga(String tipoDeManga) {
        this.tipoDeManga = tipoDeManga;
    }

    public boolean isEstampada() {
        return estampada;
    }

    public void setEstampada(boolean estampada) {
        this.estampada = estampada;
    }

    @Override
    public String mostrarInformacion() {
        return super.toString() + "\n" +
                "Camisa:\n" +
                "\t Tipo de manga :" + getTipoDeManga() + " " +
                ", Es estampada :" + isEstampada();
    }
}
