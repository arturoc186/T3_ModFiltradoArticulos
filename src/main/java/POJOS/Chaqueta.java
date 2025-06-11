package POJOS;

public class Chaqueta extends Ropa {
    // atributos de chaqueta
    private boolean impermeable;

    public Chaqueta(int codArt, String nombre, float precio, String marca,
                    String descripcion, boolean activo, String imagen, String color,
                    Material material, String talla_ropa, String tipo_cierre,
                    boolean impermeable) {
        super(codArt, nombre, precio, marca, descripcion, activo, imagen, color,
                material, talla_ropa, tipo_cierre);
        this.impermeable = impermeable;
    }

    public Chaqueta(int codArt, String nombre, float precio, String marca,
                    String descripcion, String talla_ropa, String tipo_cierre,
                    boolean impermeable) {
        super(codArt, nombre, precio, marca, descripcion, talla_ropa, tipo_cierre);
        this.impermeable = impermeable;
    }

    public Chaqueta(int codArt, String nombre, float precio, String talla_ropa,
                    String tipo_cierre, boolean impermeable) {
        super(codArt, nombre, precio, talla_ropa, tipo_cierre);
        this.impermeable = impermeable;
    }

    public Chaqueta(String nombre, float precio, String marca, String descripcion,
                    boolean activo, String imagen, String color, Material material,
                    String talla_ropa, String tipo_cierre, boolean impermeable) {
        super(nombre, precio, marca, descripcion, activo, imagen, color, material,
                talla_ropa, tipo_cierre);
        this.impermeable = impermeable;
    }

    public Chaqueta(String nombre, float precio, String marca, String descripcion,
                    String talla_ropa, String tipo_cierre, boolean impermeable) {
        super(nombre, precio, marca, descripcion, talla_ropa, tipo_cierre);
        this.impermeable = impermeable;
    }

    public Chaqueta(String nombre, float precio, String talla_ropa, String tipo_cierre,
                    boolean impermeable) {
        super(nombre, precio, talla_ropa, tipo_cierre);
        this.impermeable = impermeable;
    }

    public Chaqueta() {
        super();
        this.impermeable = false;
    }


    public boolean isImpermeable() {
        return impermeable;
    }

    public void setImpermeable(boolean impermeable) {
        this.impermeable = impermeable;
    }

}
