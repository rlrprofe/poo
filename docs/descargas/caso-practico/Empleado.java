// Empleado.java
public class Empleado extends Persona implements Pagable {

    private String cargo;
    private double sueldo;
    private Departamento departamento;      // asociación

    public Empleado(String dni, String nombre, int edad, String estadoCivil,
                    String cargo, double sueldo, Departamento departamento) {
        super(dni, nombre, edad, estadoCivil);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void subeSueldo(double cantidad) {
        sueldo += cantidad;
    }

    @Override
    public double calcularPago() {
        return sueldo;
    }

    @Override
    public String toString() {
        return super.toString() + " | Empleado{cargo=" + cargo + ", sueldo=" + sueldo
                + ", departamento=" + departamento + "}";
    }
}
