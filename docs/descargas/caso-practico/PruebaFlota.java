// PruebaFlota.java
public class PruebaFlota {
    public static void main(String[] args) {

        // Vehículos: objetos que existen por sí mismos
        Vehiculo focus = new Coche("5671BCD", "Ford", "Focus", "rojo", 130, 5);
        Vehiculo ibiza = new Coche("4410KLM", "Seat", "Ibiza", "azul", 95, 3);
        Vehiculo fh = new Camion("1234XYZ", "Volvo", "FH", "blanco", 460, 18000);

        // La flota los agrupa (agregación)
        Flota flota = new Flota("Flota Centro");
        flota.incorporar(focus);
        flota.incorporar(ibiza);
        flota.incorporar(fh);

        System.out.println("=== Flota ===");
        for (Vehiculo v : flota.getVehiculos()) {
            System.out.println(v.getMatricula() + " - " + v.getMarca() + " "
                    + v.getModelo() + " - " + v.getColor());
        }

        System.out.println();
        System.out.println("=== Un vehículo completo ===");
        System.out.println(focus);

        // Mensajes a los objetos: cambian su estado
        focus.ponerEnMarcha();
        focus.acelerar(200);
        fh.ponerEnMarcha();
        fh.acelerar(200);

        System.out.println();
        System.out.println("=== Velocidades ===");
        for (Vehiculo v : flota.getVehiculos()) {
            System.out.println(v.getMatricula() + " circula a " + v.getVelocidad() + " km/h");
        }

        // Alquileres: asocian vehículo y conductor y componen sus extras
        Conductor ana = new Conductor("12345678Z", "Ana");
        Conductor luis = new Conductor("87654321X", "Luis");

        Alquiler a1 = new Alquiler(focus, ana, 3);
        a1.anadirExtra("GPS", 5.0);
        a1.anadirExtra("Silla infantil", 3.5);
        Alquiler a2 = new Alquiler(fh, luis, 2);

        Alquiler[] alquileres = { a1, a2 };

        System.out.println();
        System.out.println("=== Facturación ===");
        double total = 0;
        for (Alquiler a : alquileres) {
            System.out.println(a.getConductor().getNombre() + " paga " + a.getTotal()
                    + " EUR por " + a.getVehiculo().getMarca() + " " + a.getVehiculo().getModelo());
            total += a.getTotal();
        }
        System.out.println("Total: " + total + " EUR");

        System.out.println();
        System.out.println("=== Encapsulación ===");
        try {
            ibiza.acelerar(50);          // el Ibiza no está en marcha
        } catch (IllegalStateException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
