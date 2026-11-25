// PlazaGaraje.java
public class PlazaGaraje implements Alquilable {

    private final String codigo;

    public PlazaGaraje(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public double costeAlquiler(int dias) {
        return 5.0 * dias;
    }
}
