// Coche.java
public class Coche extends Vehiculo {

    private final int numPuertas;

    public Coche(String matricula, String marca, String modelo, String color,
                 int potencia, int numPuertas) {
        super(matricula, marca, modelo, color, potencia);
        this.numPuertas = numPuertas;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    @Override
    public double costeAlquiler(int dias) {
        return 40.0 * dias;
    }

    @Override
    public String toString() {
        return super.toString() + " | Coche{puertas=" + numPuertas + "}";
    }
}
