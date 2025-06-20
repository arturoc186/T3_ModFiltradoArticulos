package POJOS;

public class Departamento {
    // atributos de instancia
    private int codigo;
    private String nombre;

    public Departamento(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Departamento :" +
                "codigo=" + codigo + " " +nombre + '\n';
    }
}
