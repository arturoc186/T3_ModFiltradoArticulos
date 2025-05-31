package POJOS;

public class GafasDeSol extends Accesorio{

    private ProteccionUV proteccionUV;
    private String forma;
    private boolean lentesGraduadas;
    private int anchura;

    public GafasDeSol(int codArt, String nombre, float precio, String marca, String descripcion, boolean activo,
                      String imagen, String color, Material material, String estilo, boolean esPersonalizado,
                      ProteccionUV proteccionUV, String forma, boolean lentesGraduadas, int anchura) {
        super(codArt, nombre, precio, marca, descripcion, activo, imagen, color, material, estilo, esPersonalizado);
        this.proteccionUV = proteccionUV;
        this.forma = forma;
        this.lentesGraduadas = lentesGraduadas;
        this.anchura = anchura;
    }

    public GafasDeSol(){
        super();
    }

    public ProteccionUV getProteccionUV() {
        return proteccionUV;
    }

    public void setProteccionUV(ProteccionUV proteccionUV) {
        this.proteccionUV = proteccionUV;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public boolean isLentesGraduadas() {
        return lentesGraduadas;
    }

    public void setLentesGraduadas(boolean lentesGraduadas) {
        this.lentesGraduadas = lentesGraduadas;
    }

    public int getAnchura() {
        return anchura;
    }

    public void setAnchura(int anchura) {
        this.anchura = anchura;
    }

    @Override
    public String mostrarInformacion() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "GafasDeSol{" +
                "proteccionUV=" + proteccionUV +
                ", forma='" + forma + '\'' +
                ", lentesGraduadas=" + lentesGraduadas +
                ", anchura=" + anchura +
                '}';
    }
}
