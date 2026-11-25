// PruebaPlantilla.java
public class PruebaPlantilla {
    public static void main(String[] args) {

        // Un departamento (objeto) compartido por varios empleados
        Departamento informatica = new Departamento("1Inf", "Informática", "Madrid");

        // Un array de Empleado que contiene también un Ejecutivo
        Empleado[] plantilla = {
            new Empleado("153647458S", "Pepe", 35, "casado", "Analista", 1500, informatica),
            new Empleado("452697419Z", "Maria", 25, "soltera", "Programadora", 1000, informatica),
            new Ejecutivo("987654321X", "Lucía", 48, "casada", "Directora", 3000, informatica, 500)
        };

        System.out.println("=== Plantilla ===");
        for (Empleado e : plantilla) {
            System.out.println(e.getNombre() + " - " + e.getCargo()
                    + " - " + e.getDepartamento().getNombre());
        }

        System.out.println();
        System.out.println("=== Un empleado completo ===");
        System.out.println(plantilla[1]);

        // Mensaje a un objeto: cambia su estado
        plantilla[1].subeSueldo(100);

        System.out.println();
        System.out.println("=== Nómina ===");
        double total = 0;
        for (Empleado e : plantilla) {
            System.out.println(e.getNombre() + " cobra " + e.calcularPago());
            total += e.calcularPago();
        }
        System.out.println("Total: " + total);

        System.out.println();
        System.out.println("=== Encapsulación ===");
        try {
            plantilla[0].setEdad(-1);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
