// Vehiculo.java
public abstract class Vehiculo implements Alquilable {

    private final String matricula;
    private String marca;
    private String modelo;
    private String color;
    private int potencia;
    private int velocidad;
    private boolean enMarcha;

    public Vehiculo(String matricula, String marca, String modelo, String color, int potencia) {
        if (potencia <= 0) {
            throw new IllegalArgumentException("La potencia debe ser positiva");
        }
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.potencia = potencia;
    }

    public void ponerEnMarcha() {
        enMarcha = true;
    }

    public void parar() {
        velocidad = 0;
        enMarcha = false;
    }

    public void acelerar(int incremento) {
        if (incremento <= 0) {
            throw new IllegalArgumentException("El incremento debe ser positivo");
        }
        if (!enMarcha) {
            throw new IllegalStateException("El vehículo está parado: hay que ponerlo en marcha");
        }
        velocidad = Math.min(velocidad + incremento, getVelocidadMaxima());
    }

    public void frenar(int decremento) {
        if (decremento <= 0) {
            throw new IllegalArgumentException("El decremento debe ser positivo");
        }
        velocidad = Math.max(0, velocidad - decremento);
    }

    public int getVelocidadMaxima() {
        return 180;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public boolean isEnMarcha() {
        return enMarcha;
    }

    public void pintar(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehiculo{matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo
                + ", color=" + color + ", velocidad=" + velocidad + " km/h}";
    }
}
