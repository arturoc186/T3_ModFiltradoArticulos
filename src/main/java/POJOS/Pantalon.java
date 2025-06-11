package POJOS;

public class Pantalon extends Ropa {
    // atributos de Pantalon
    private boolean tieneBolsillos;
    private String tipoPantalon;

    public Pantalon(int codArt, String nombre, float precio, String marca, String descripcion, boolean activo,
                    String imagen, String color, Material material, String talla_ropa, String tipo_cierre,
                    boolean tieneBolsillos, String tipoPantalon) {
        super(codArt, nombre, precio, marca, descripcion, activo, imagen, color, material, talla_ropa, tipo_cierre);
        this.tieneBolsillos = tieneBolsillos;
        this.tipoPantalon = tipoPantalon;
    }

    public Pantalon(int codArt, String nombre, float precio, String marca, String descripcion, String talla_ropa,
                    String tipo_cierre, boolean tieneBolsillos, String tipoPantalon) {
        super(codArt, nombre, precio, marca, descripcion, talla_ropa, tipo_cierre);
        this.tieneBolsillos = tieneBolsillos;
        this.tipoPantalon = tipoPantalon;
    }

    public Pantalon(int codArt, String nombre, float precio, String talla_ropa, String tipo_cierre,
                    boolean tieneBolsillos, String tipoPantalon) {
        super(codArt, nombre, precio, talla_ropa, tipo_cierre);
        this.tieneBolsillos = tieneBolsillos;
        this.tipoPantalon = tipoPantalon;
    }

    public Pantalon(String nombre, float precio, String marca, String descripcion, boolean activo, String imagen,
                    String color, Material material, String talla_ropa, String tipo_cierre, boolean tieneBolsillos,
                    String tipoPantalon) {
        super(nombre, precio, marca, descripcion, activo, imagen, color, material, talla_ropa, tipo_cierre);
        this.tieneBolsillos = tieneBolsillos;
        this.tipoPantalon = tipoPantalon;
    }

    public Pantalon(String nombre, float precio, String marca, String descripcion, String talla_ropa,
                    String tipo_cierre, boolean tieneBolsillos, String tipoPantalon) {
        super(nombre, precio, marca, descripcion, talla_ropa, tipo_cierre);
        this.tieneBolsillos = tieneBolsillos;
        this.tipoPantalon = tipoPantalon;
    }

    public Pantalon(String nombre, float precio, String talla_ropa, String tipo_cierre, boolean tieneBolsillos,
                    String tipoPantalon) {
        super(nombre, precio, talla_ropa, tipo_cierre);
        this.tieneBolsillos = tieneBolsillos;
        this.tipoPantalon = tipoPantalon;
    }

    public Pantalon() {
        super();
        this.tieneBolsillos = false;
        this.tipoPantalon = "";
    }

    public boolean isTieneBolsillos() {
        return tieneBolsillos;
    }

    public void setTieneBolsillos(boolean tieneBolsillos) {
        this.tieneBolsillos = tieneBolsillos;
    }

    public String getTipoPantalon() {
        return tipoPantalon;
    }

    public void setTipoPantalon(String tipoPantalon) {
        this.tipoPantalon = tipoPantalon;
    }

}
