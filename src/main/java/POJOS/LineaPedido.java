package POJOS;

public class LineaPedido {
    private int cantidad;
    private Articulo articulo;

    public LineaPedido(int cantidad, Articulo articulo) {
        this.cantidad = cantidad;
        this.articulo = articulo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public double getSubtotal() {
        return cantidad * articulo.getPrecio();
    }

    @Override
    public String toString() {
        return "LineaPedido{" + "cantidad=" + cantidad;
    }
}