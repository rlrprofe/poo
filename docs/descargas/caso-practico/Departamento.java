// Departamento.java
public class Departamento {

    private final String id;
    private String nombre;
    private String localizacion;

    public Departamento(String id, String nombre, String localizacion) {
        this.id = id;
        this.nombre = nombre;
        this.localizacion = localizacion;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @Override
    public String toString() {
        return "Departamento{id=" + id + ", nombre=" + nombre
                + ", localizacion=" + localizacion + "}";
    }
}
