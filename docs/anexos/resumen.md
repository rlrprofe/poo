# Resumen de una página

## Elementos

| Concepto | En una frase |
|---|---|
| **Clase** | Plantilla de objetos: módulo y tipo de dato. Se compone de atributos y métodos. |
| **Objeto** | Datos (atributos) + procedimientos (métodos), con identidad y estado. |
| **Instancia** | Objeto creado con `new` a partir de una clase. |
| **Mensaje** | Un objeto pide un servicio a otro llamando a uno de sus métodos. |

## Principios

| Principio | Idea | Java |
|---|---|---|
| **Encapsulación** | Ocultar datos, exponer servicios | `private` + métodos públicos, getters y setters con validación |
| **Herencia** | Reutilizar y especializar («es-un») | `extends`, `super`, `@Override` |
| **Polimorfismo** | Mismo mensaje, respuestas distintas | Redefinición + enlace dinámico, clases abstractas, interfaces |

## Relaciones entre clases

| Relación | Tipo | Java | UML |
|---|---|---|---|
| Herencia | «es-un» | `extends` | Triángulo hueco, línea continua |
| Realización | «cumple el contrato» | `implements` | Triángulo hueco, línea discontinua |
| Asociación | «conoce a» | Atributo | Línea (flecha si es dirigida) |
| Agregación | «está formada por» (partes independientes) | Colección; partes recibidas | Rombo hueco |
| Composición | «está formada por» (partes dependientes) | Colección; partes creadas por el todo | Rombo relleno |
| Dependencia | «usa» | Parámetro / variable local | Flecha discontinua |

## Java, de un vistazo

```java
public class Camion extends Vehiculo {                       // herencia

    private final double cargaMaxima;                         // encapsulación

    public Camion(String matricula, String marca, String modelo, String color,
                  int potencia, double cargaMaxima) {
        super(matricula, marca, modelo, color, potencia);     // constructor de la superclase
        this.cargaMaxima = cargaMaxima;                       // this: el propio objeto
    }

    @Override
    public double costeAlquiler(int dias) {                   // redefinición / implementación
        return 85.0 * dias + 50.0;
    }
}

Alquilable a = new Camion("1234XYZ", "Volvo", "FH", "blanco", 460, 18000);   // polimorfismo
a.costeAlquiler(3);                                           // enlace dinámico
```

## Visibilidad

| Modificador | UML | Quién accede |
|---|:---:|---|
| `private` | `-` | Solo la clase |
| *(ninguno)* | `~` | La clase y su paquete |
| `protected` | `#` | Paquete y subclases |
| `public` | `+` | Todos |

## Cardinalidad

`1` exactamente uno · `0..1` cero o uno · `*` o `0..*` cero o más · `1..*` uno o más
