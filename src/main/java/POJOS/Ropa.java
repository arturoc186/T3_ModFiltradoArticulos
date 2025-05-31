package POJOS;

public abstract class Ropa extends Articulo {
    // atributos de clase
    private static final float RECARGO = 0.08f;

    // atributos de instancia
    private String tallaRopa;
    private String tipoCierre;

    public Ropa(int codArt, String nombre, float precio, String marca, String descripcion,
                boolean activo, String imagen, String color, Material material,
                String talla_ropa, String tipo_cierre) {
        super(codArt, nombre, precio, marca, descripcion, activo, imagen, color, material);
        this.tallaRopa = talla_ropa;
        this.tipoCierre = tipo_cierre;
    }

    public Ropa(int codArt, String nombre, float precio, String marca, String descripcion,
                String talla_ropa, String tipo_cierre) {
        super(codArt, nombre, precio, marca, descripcion);
        this.tallaRopa = talla_ropa;
        this.tipoCierre = tipo_cierre;
    }

    public Ropa(int codArt, String nombre, float precio, String talla_ropa,
                String tipo_cierre) {
        super(codArt, nombre, precio);
        this.tallaRopa = talla_ropa;
        this.tipoCierre = tipo_cierre;
    }

    public Ropa(Ropa art) {
        super(art);
        this.tallaRopa = art.getTallaRopa();
        this.tipoCierre = art.getTipoCierre();
    }

    public Ropa(String nombre, float precio, String marca, String descripcion, boolean activo,
                String imagen, String color, Material material, String talla_ropa,
                String tipo_cierre) {
        super(nombre, precio, marca, descripcion, activo, imagen, color, material);
        this.tallaRopa = talla_ropa;
        this.tipoCierre = tipo_cierre;
    }

    public Ropa(String nombre, float precio, String marca, String descripcion, String talla_ropa,
                String tipo_cierre) {
        super(nombre, precio, marca, descripcion);
        this.tallaRopa = talla_ropa;
        this.tipoCierre = tipo_cierre;
    }

    public Ropa(String nombre, float precio, String talla_ropa, String tipo_cierre) {
        super(nombre, precio);
        this.tallaRopa = talla_ropa;
        this.tipoCierre = tipo_cierre;
    }

    public Ropa() {
        super();
        this.tallaRopa = "";
        this.tipoCierre = "";
    }

    public String getTallaRopa() {
        return tallaRopa;
    }

    public void setTallaRopa(String tallaRopa) {
        this.tallaRopa = tallaRopa;
    }

    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }

    @Override
    public String toString() {
        String art = "Articulo : \n" +
                "\t codArt: " + getCodArt() + "\n" +
                "\t nombre : " + getNombre() + "\n" +
                "\t precio : " + getPrecio() + "\n" +
                "\t marca  : " + getMarca() + "\n" +
                "\t descripción : " + getDescripcion() + "\n" +
                "\t activo : " + isActivo() + "\n" +
                "\t imagen : " + getImagen() + "\n" +
                "\t color  : " + getColor() + "\n" +
                "\t " + getMaterial().toString() + "\n";
        art +=
                "Ropa :\n" +
                        "\t talla :" + tallaRopa + ' ' + ", tipo de cierre :'" + tipoCierre;
        return art;
    }

    @Override
    public float calculaPrecioVenta(float dto) {
        float total;
        total = ((getPrecio() * (1 + RECARGO)) * (1 - (dto / 100f)));
        return total;
    }

}
