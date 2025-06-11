package POJOS;

import java.util.Objects;

public abstract class Articulo {
    // atributos
    private int codArt;
    private String nombre;
    private float precio;
    private String marca;
    private String descripcion;
    private boolean activo;
    private String imagen;
    private String color;
    private Material material;

    public Articulo(int codArt, String nombre, float precio, String marca,
                    String descripcion, boolean activo, String imagen,
                    String color, Material material) {
        this.codArt = codArt;
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.descripcion = descripcion;
        this.activo = activo;
        this.imagen = imagen;
        this.color = color;
        this.material = material;
    }

    public Articulo(int codArt, String nombre, float precio, String marca, String descripcion) {
        this.codArt = codArt;
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.descripcion = descripcion;
    }

    public Articulo(int codArt, String nombre, float precio) {
        this.codArt = codArt;
        this.nombre = nombre;
        this.precio = precio;
    }

    // constructores sin codArt
    public Articulo(String nombre, float precio, String marca,
                    String descripcion, boolean activo, String imagen,
                    String color, Material material) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.descripcion = descripcion;
        this.activo = activo;
        this.imagen = imagen;
        this.color = color;
        this.material = material;
    }

    public Articulo(String nombre, float precio, String marca, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.descripcion = descripcion;
    }

    public Articulo(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // crea una copia del objeto
    public Articulo(Articulo art) {
        this.codArt = art.getCodArt();
        this.nombre = art.getNombre();
        this.precio = art.getPrecio();
        this.marca = art.getMarca();
        this.descripcion = art.getDescripcion();
        this.activo = art.isActivo();
        this.imagen = art.getImagen();
        this.color = art.getColor();
        this.material = art.getMaterial();
    }

    public Articulo() {
        this.codArt = 0;
        this.nombre = "";
        this.precio = 0;
        this.marca = "";
        this.descripcion = "";
        this.activo = false;
        this.imagen = "";
        this.color = "";
        this.material = null;
    }


    public int getCodArt() {
        return codArt;
    }

    public void setcodArt(int codArt) {
        this.codArt = codArt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public abstract float calculaPrecioVenta(float dto);

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return codArt == articulo.codArt;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codArt);
    }
}
