package POJOS;

public class Material {
    // atributos
    private int codigo;
    private String denominacion;

    public Material(int codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }

    public Material(String denominacion) {
        this.denominacion = denominacion;
    }

    public Material() {
        codigo = 0;
        denominacion = "";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Override
    public String toString() {
        return "Material: " +
                "codigo=" + codigo +
                ", denominacion='" + denominacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Material)) return false;

        Material material = (Material) o;

        return getCodigo() == material.getCodigo();
    }

    @Override
    public int hashCode() {
        return getCodigo();
    }
}
