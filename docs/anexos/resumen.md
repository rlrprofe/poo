# Resumen de una página

## Elementos

| Concepto | En una frase |
|---|---|
| **Objeto** | Datos (atributos) + procedimientos (métodos), con identidad y estado. |
| **Clase** | Plantilla de objetos: módulo y tipo de dato. |
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
public class Empleado extends Persona implements Pagable {   // herencia + interfaz

    private double sueldo;                                    // encapsulación

    public Empleado(String dni, String nombre, int edad, String ec, double sueldo) {
        super(dni, nombre, edad, ec);                         // constructor de la superclase
        this.sueldo = sueldo;                                 // this: el propio objeto
    }

    @Override
    public double calcularPago() {                            // redefinición
        return sueldo;
    }
}

Pagable p = new Empleado("1A", "Ana", 30, "soltera", 1200);   // polimorfismo
p.calcularPago();                                             // enlace dinámico
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
