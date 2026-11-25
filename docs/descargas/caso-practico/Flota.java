// Flota.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flota {

    private final String nombre;
    private final List<Vehiculo> vehiculos = new ArrayList<>();   // 0..*

    public Flota(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void incorporar(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);                  // el vehículo se crea FUERA de la flota
    }

    public void retirar(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);               // retirarlo no destruye el vehículo
    }

    public int getNumVehiculos() {
        return vehiculos.size();
    }

    public Vehiculo buscarPorMatricula(String matricula) {
        for (Vehiculo v : vehiculos) {
            if (v.getMatricula().equals(matricula)) {
                return v;
            }
        }
        return null;
    }

    public double costeTotal(int dias) {
        double total = 0;
        for (Vehiculo v : vehiculos) {
            total += v.costeAlquiler(dias);       // polimorfismo (capítulo 5)
        }
        return total;
    }

    public List<Vehiculo> getVehiculos() {
        return Collections.unmodifiableList(vehiculos);   // solo lectura: protege la colección
    }
}
