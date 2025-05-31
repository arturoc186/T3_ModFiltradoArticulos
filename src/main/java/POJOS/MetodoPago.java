package POJOS;

public class MetodoPago {
    // atributos de instancia
    private int codigo;
    private String descripcion;

    public MetodoPago(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Método Pago código=" + codigo +" "+ descripcion + '\n';
    }
}

