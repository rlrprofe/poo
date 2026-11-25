// Camion.java
public class Camion extends Vehiculo {

    private final double cargaMaxima;

    public Camion(String matricula, String marca, String modelo, String color,
                  int potencia, double cargaMaxima) {
        super(matricula, marca, modelo, color, potencia);
        this.cargaMaxima = cargaMaxima;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    @Override
    public int getVelocidadMaxima() {
        return 90;
    }

    @Override
    public double costeAlquiler(int dias) {
        return 85.0 * dias + 50.0;       // tarifa diaria + seguro fijo
    }

    @Override
    public String toString() {
        return super.toString() + " | Camion{cargaMaxima=" + cargaMaxima + " kg}";
    }
}
