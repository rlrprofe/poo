// Alquiler.java
import java.util.ArrayList;
import java.util.List;

public class Alquiler {

    private final Vehiculo vehiculo;                       // asociación (1)
    private final Conductor conductor;                     // asociación (1)
    private final int dias;
    private final List<Extra> extras = new ArrayList<>();  // composición (0..*)

    public Alquiler(Vehiculo vehiculo, Conductor conductor, int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException("El alquiler debe ser de al menos un día");
        }
        this.vehiculo = vehiculo;
        this.conductor = conductor;
        this.dias = dias;
    }

    public void anadirExtra(String descripcion, double precioDia) {
        extras.add(new Extra(descripcion, precioDia));     // el alquiler CREA sus extras
    }

    public int getNumExtras() {
        return extras.size();
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public double getTotal() {
        double total = vehiculo.costeAlquiler(dias);
        for (Extra e : extras) {
            total += e.getPrecioDia() * dias;
        }
        return total;
    }
}
