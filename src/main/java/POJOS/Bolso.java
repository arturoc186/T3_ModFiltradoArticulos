package POJOS;

public class Bolso extends Accesorio {
    // atributos de Bolso
    private int capacidad;
    private String tipoCierreBolso;

    public Bolso(int codArt, String nombre, float precio, String marca, String descripcion, boolean activo,
                 String imagen, String color, Material material, String estilo, boolean esPersonalizado, int capacidad,
                 String tipoCierreBolso) {
        super(codArt, nombre, precio, marca, descripcion, activo, imagen, color, material, estilo, esPersonalizado);
        this.capacidad = capacidad;
        this.tipoCierreBolso = tipoCierreBolso;
    }

    public Bolso(int codArt, String nombre, float precio, String marca, String descripcion, String estilo,
                 boolean esPersonalizado, int capacidad, String tipoCierreBolso) {
        super(codArt, nombre, precio, marca, descripcion, estilo, esPersonalizado);
        this.capacidad = capacidad;
        this.tipoCierreBolso = tipoCierreBolso;
    }

    public Bolso(int codArt, String nombre, float precio, String estilo, boolean esPersonalizado, int capacidad,
                 String tipoCierreBolso) {
        super(codArt, nombre, precio, estilo, esPersonalizado);
        this.capacidad = capacidad;
        this.tipoCierreBolso = tipoCierreBolso;
    }

    public Bolso(String nombre, float precio, String marca, String descripcion, boolean activo, String imagen,
                 String color, Material material, String estilo, boolean esPersonalizado, int capacidad,
                 String tipoCierreBolso) {
        super(nombre, precio, marca, descripcion, activo, imagen, color, material, estilo, esPersonalizado);
        this.capacidad = capacidad;
        this.tipoCierreBolso = tipoCierreBolso;
    }

    public Bolso(String nombre, float precio, String marca, String descripcion, String estilo, boolean esPersonalizado,
                 int capacidad, String tipoCierreBolso) {
        super(nombre, precio, marca, descripcion, estilo, esPersonalizado);
        this.capacidad = capacidad;
        this.tipoCierreBolso = tipoCierreBolso;
    }

    public Bolso(String nombre, float precio, String estilo, boolean esPersonalizado, int capacidad,
                 String tipoCierreBolso) {
        super(nombre, precio, estilo, esPersonalizado);
        this.capacidad = capacidad;
        this.tipoCierreBolso = tipoCierreBolso;
    }

    public Bolso() {
        super();
        this.capacidad = 0;
        this.tipoCierreBolso = "";
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipoCierreBolso() {
        return tipoCierreBolso;
    }

    public void setTipoCierreBolso(String tipoCierreBolso) {
        this.tipoCierreBolso = tipoCierreBolso;
    }

}

