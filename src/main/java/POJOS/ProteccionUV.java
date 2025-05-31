package POJOS;

import java.util.Objects;

public class ProteccionUV {

    private String nivel;

    public ProteccionUV(String nivel) {
        super();
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "ProteccionUV{" +
                "nivel='" + nivel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProteccionUV that = (ProteccionUV) o;
        return Objects.equals(nivel, that.nivel);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nivel);
    }
}
