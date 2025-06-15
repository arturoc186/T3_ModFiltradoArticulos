package POJOS;

public abstract class Accesorio extends Articulo {
    private String estilo;
    private boolean esPersonalizado;

    public Accesorio(int codArt, String nombre, float precio, String marca,
                     String descripcion, boolean activo, String imagen, String color,
                     Material material, String estilo, boolean esPersonalizado) {
        super(codArt, nombre, precio, marca, descripcion, activo, imagen, color, material);
        this.estilo = estilo;
        this.esPersonalizado = esPersonalizado;
    }

    public Accesorio(int codArt, String nombre, float precio, String marca,
                     String descripcion, String estilo, boolean esPersonalizado) {
        super(codArt, nombre, precio, marca, descripcion);
        this.estilo = estilo;
        this.esPersonalizado = esPersonalizado;
    }

    public Accesorio(int codArt, String nombre, float precio, String estilo,
                     boolean esPersonalizado) {
        super(codArt, nombre, precio);
        this.estilo = estilo;
        this.esPersonalizado = esPersonalizado;
    }

    public Accesorio(String nombre, float precio, String marca, String descripcion,
                     boolean activo, String imagen, String color, Material material,
                     String estilo, boolean esPersonalizado) {
        super(nombre, precio, marca, descripcion, activo, imagen, color, material);
        this.estilo = estilo;
        this.esPersonalizado = esPersonalizado;
    }

    public Accesorio(String nombre, float precio, String marca, String descripcion,
                     String estilo, boolean esPersonalizado) {
        super(nombre, precio, marca, descripcion);
        this.estilo = estilo;
        this.esPersonalizado = esPersonalizado;
    }

    public Accesorio(String nombre, float precio, String estilo, boolean esPersonalizado) {
        super(nombre, precio);
        this.estilo = estilo;
        this.esPersonalizado = esPersonalizado;
    }

    public Accesorio() {
        super();
        this.estilo = "";
        this.esPersonalizado = false;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public boolean isEsPersonalizado() {
        return esPersonalizado;
    }

    public void setEsPersonalizado(boolean esPersonalizado) {
        this.esPersonalizado = esPersonalizado;
    }

    public String getMaterialName() {
        return getMaterial() != null ? getMaterial().getDenominacion() : "";
    }

    @Override
    public String toString() {
        String art = "Articulo : " +
                "Código de artículo : " + getCodArt() + "\n" +
                "\t nombre : " + getNombre() + "\n" +
                "\t precio : " + getPrecio() + "\n" +
                "\t marca  : " + getMarca() + "\n" +
                "\t descripcion : " + getDescripcion() + "\n" +
                "\t activo : " + isActivo() + "\n" +
                "\t imagen : " + getImagen() + "\n" +
                "\t color  : " + getColor() + "\n" +
                "\t material : " + getMaterialName() + "\n";
        art += "Accesorio :\n" +
                "\t estilo :" + estilo +
                ", es Personalizado :" + esPersonalizado;
        return art;
    }
}
