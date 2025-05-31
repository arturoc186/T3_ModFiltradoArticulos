package POJOS;

public class Zapatos extends Accesorio {
    // Atributos de Zapatos
    private int tallaZapato;
    private String tipoSuela;

    public Zapatos(int codArt, String nombre, float precio, String marca, String descripcion, boolean activo,
                   String imagen, String color, Material material, String estilo, boolean esPersonalizado,
                   int tallaZapato, String tipoSuela) {
        super(codArt, nombre, precio, marca, descripcion, activo, imagen, color, material, estilo, esPersonalizado);
        this.tallaZapato = tallaZapato;
        this.tipoSuela = tipoSuela;
    }

    public Zapatos(int codArt, String nombre, float precio, String marca, String descripcion, String estilo,
                   boolean esPersonalizado, int tallaZapato, String tipoSuela) {
        super(codArt, nombre, precio, marca, descripcion, estilo, esPersonalizado);
        this.tallaZapato = tallaZapato;
        this.tipoSuela = tipoSuela;
    }

    public Zapatos(int codArt, String nombre, float precio, String estilo, boolean esPersonalizado,
                   int tallaZapato, String tipoSuela) {
        super(codArt, nombre, precio, estilo, esPersonalizado);
        this.tallaZapato = tallaZapato;
        this.tipoSuela = tipoSuela;
    }

    public Zapatos(String nombre, float precio, String marca, String descripcion, boolean activo, String imagen,
                   String color, Material material, String estilo, boolean esPersonalizado, int tallaZapato,
                   String tipoSuela) {
        super(nombre, precio, marca, descripcion, activo, imagen, color, material, estilo, esPersonalizado);
        this.tallaZapato = tallaZapato;
        this.tipoSuela = tipoSuela;
    }

    public Zapatos(String nombre, float precio, String marca, String descripcion, String estilo,
                   boolean esPersonalizado, int tallaZapato, String tipoSuela) {
        super(nombre, precio, marca, descripcion, estilo, esPersonalizado);
        this.tallaZapato = tallaZapato;
        this.tipoSuela = tipoSuela;
    }

    public Zapatos(String nombre, float precio, String estilo, boolean esPersonalizado, int tallaZapato,
                   String tipoSuela) {
        super(nombre, precio, estilo, esPersonalizado);
        this.tallaZapato = tallaZapato;
        this.tipoSuela = tipoSuela;
    }

    public Zapatos() {
        super();
        this.tallaZapato = 0;
        this.tipoSuela = "";
    }

    public int getTallaZapato() {
        return tallaZapato;
    }

    public void setTallaZapato(int tallaZapato) {
        this.tallaZapato = tallaZapato;
    }

    public String getTipoSuela() {
        return tipoSuela;
    }

    public void setTipoSuela(String tipoSuela) {
        this.tipoSuela = tipoSuela;
    }

    @Override
    public String mostrarInformacion() {
        return super.toString() + "\n" +
                "Zapatos :\n" +
                "\t Tipo de suela :" + getTipoSuela() + " " +
                ", Talla :" + getTallaZapato();
    }

}
