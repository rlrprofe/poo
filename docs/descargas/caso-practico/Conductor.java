// Conductor.java
public class Conductor {

    private final String dni;
    private final String nombre;
    private Vehiculo vehiculoAsignado;      // asociación: 0 ó 1 vehículo

    public Conductor(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public Vehiculo getVehiculoAsignado() {
        return vehiculoAsignado;
    }

    public void asignar(Vehiculo vehiculo) {
        this.vehiculoAsignado = vehiculo;
    }

    public void liberarVehiculo() {
        this.vehiculoAsignado = null;
    }

    public String describirAsignacion() {
        if (vehiculoAsignado == null) {
            return nombre + " no tiene vehículo asignado";
        }
        return nombre + " conduce " + vehiculoAsignado.getMarca() + " "
                + vehiculoAsignado.getModelo() + " (" + vehiculoAsignado.getMatricula() + ")";
    }
}
