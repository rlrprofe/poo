// Ejecutivo.java
public class Ejecutivo extends Empleado {

    private double bonus;

    public Ejecutivo(String dni, String nombre, int edad, String estadoCivil,
                     String cargo, double sueldo, Departamento departamento,
                     double bonus) {
        super(dni, nombre, edad, estadoCivil, cargo, sueldo, departamento);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public double calcularPago() {
        return super.calcularPago() + bonus;
    }

    @Override
    public String toString() {
        return super.toString() + " | Ejecutivo{bonus=" + bonus + "}";
    }
}
