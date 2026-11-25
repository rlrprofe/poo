// Persona.java
public class Persona {

    private final String dni;
    private String nombre;
    private int edad;
    private String estadoCivil;

    public Persona(String dni, String nombre, int edad, String estadoCivil) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = validarEdad(edad);
        this.estadoCivil = estadoCivil;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = validarEdad(edad);
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void cumpleanos() {
        edad++;
    }

    // Utilidad interna: no forma parte del servicio que ofrece la clase
    private static int validarEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        return edad;
    }

    @Override
    public String toString() {
        return "Persona{dni=" + dni + ", nombre=" + nombre
                + ", edad=" + edad + ", estadoCivil=" + estadoCivil + "}";
    }
}
