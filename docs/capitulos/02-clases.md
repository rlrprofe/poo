# 2. Clases

## 2.1. De los objetos a las clases

En un banco hay miles de cuentas. Todas tienen un titular, un número y un saldo, y en todas se puede ingresar y retirar dinero. Escribir cada cuenta por separado sería absurdo: lo razonable es describir **una sola vez** cómo es una cuenta y crear después tantas como haga falta.

Esa descripción común es una **clase**. En el mundo real agrupamos los elementos en **categorías** (cualquier tipo de coche pertenece a la categoría *automóvil*); en el programa, los objetos que comparten la misma estructura y el mismo comportamiento se agrupan en **clases**.

## 2.2. Qué es una clase

Una **clase** es una plantilla que describe objetos que van a tener **la misma estructura** (atributos) y **el mismo comportamiento** (métodos). Determina:

- los **atributos**: la estructura de almacenamiento de cada objeto de la clase;
- los **métodos**: las operaciones aplicables a esos objetos, que son la única vía para acceder a los atributos.

Una clase tiene una **doble naturaleza**:

| Como... | Una clase es... |
|---|---|
| **Módulo** | Un mecanismo para organizar el software: encapsula en un mismo sitio los datos y las operaciones relacionados. |
| **Tipo de dato** | Un nuevo tipo que podemos usar para declarar variables, igual que `int` o `double`. Define los valores posibles y las operaciones aplicables. |

!!! info "Un programa orientado a objetos es una colección estructurada de clases"
    Escribir un programa OO consiste, en gran medida, en **definir clases** y hacer que sus objetos colaboren.

## 2.3. Instanciación

La clase es un **generador de objetos**. Crear un objeto a partir de una clase se llama **instanciación**, y el objeto resultante es una **instancia** de la clase. Pueden existir muchas instancias de una misma clase a la vez en memoria, cada una con **sus propios valores**.

La clase `Cuenta` define los atributos `titular`, `numero` y `saldo` y los métodos `imprimir()`, `ingresar(cantidad)` y `retirar(cantidad)`. Cada instancia guarda sus propios valores:

| Instancia | `titular` | `numero` | `saldo` |
|---|---|---|---|
| `cuenta1` | Pérez | 154000345 | 2000 |
| `cuenta2` | García | 112899665 | -100 |

El **estado de un objeto** es el valor de sus atributos; cambia con el paso del tiempo, y los métodos permiten consultarlo y modificarlo.

!!! tip "En UML"
    Una clase se dibuja como un rectángulo con tres compartimentos: **nombre**, **atributos** y **operaciones**.

    ```mermaid
    classDiagram
        class Cuenta {
            titular
            numero
            saldo
            imprimir()
            ingresar(cantidad)
            retirar(cantidad)
        }
    ```

## 2.4. Declarar una clase en Java

La clase es la unidad fundamental de programación en Java. Define la **interfaz** (lo que ofrece) y la **implementación** (cómo lo hace) de sus objetos, y **todo objeto es instancia de alguna clase**.

```java
public class NombreClase {
    // atributos
    // constructores
    // métodos
}
```

!!! note "Reglas básicas"
    - Una clase `public` debe estar en un archivo con **su mismo nombre** (`Cuenta` en `Cuenta.java`).
    - Por convención, los nombres de clase empiezan por **mayúscula** (`Cuenta`, `Departamento`) y los de atributos y métodos por **minúscula** (`saldo`, `ingresar`).
    - Java no admite variables ni métodos «sueltos»: todo está dentro de alguna clase.
    - Más adelante conocerás los modificadores `final` (la clase no puede tener subclases) y `abstract` (clase abstracta).

## 2.5. Atributos

Los atributos son las variables que guarda cada objeto. Pueden ser de un tipo primitivo (`int`, `double`, `boolean`, `char`...), de otra clase (`String`, `Cuenta`...) o arrays de ellos. La sintaxis básica es:

```text
[final] [static] acceso tipo nombre;
```

```java
private String titular;
private double minimo, maximo;
final static int MAX_INSTANCIAS = 10;   // constante compartida
```

- `acceso` indica quién puede ver el atributo (`public`, `private`, `protected` o ninguno). Lo estudiaremos en el [capítulo 3](03-encapsulacion.md); por ahora usa `private`.
- `final` significa que el valor **no se puede modificar** después de asignarlo (constante).
- `static` significa que el atributo es **de la clase** y lo comparten todas las instancias (sección 2.10).

### Valores por defecto

Java da un valor inicial a los atributos que no inicializas explícitamente, según su tipo:

| Tipo del atributo | Valor inicial |
|---|---|
| `boolean` | `false` |
| `char` | `'\u0000'` (carácter nulo) |
| `byte`, `short`, `int`, `long` | `0` |
| `float`, `double` | `0.0` |
| Referencia a un objeto (`String`, `Cuenta`...) | `null` |

!!! warning "Las variables locales no tienen valor por defecto"
    Las variables declaradas **dentro de un método** o constructor deben recibir un valor antes de usarse; si no, el programa no compila.

    ```java
    int x;
    System.out.println(x);   // error: variable x might not have been initialized
    ```

Un atributo puede **no inicializarse** (toma el valor por defecto) o **inicializarse en su declaración**:

```java
private String miNombre = "Juan " + "Carlos";
private int contador = 0;
```

## 2.6. Métodos

Los métodos son las funciones de la clase: implementan el comportamiento de los objetos. Su sintaxis básica es:

```text
[final] [static] [abstract] acceso tipo nombre(parámetros) { ... }
```

- `tipo` es el **tipo de retorno**: un tipo primitivo, una clase, un array o `void` si no devuelve nada.
- `parámetros` es una lista de cero o más elementos con la forma `tipo nombre`, separados por comas.
- Todo método que no sea `void` debe terminar con un `return` seguido de una expresión del tipo de retorno.

```java
public double potencia(double base, double exponente) {
    return Math.pow(base, exponente);
}

public void imprimir() {
    System.out.println(titular + ": " + saldo);
}
```

### Sobrecarga de métodos

Una clase puede tener **varios métodos con el mismo nombre** si difieren en el número, el tipo o el orden de sus parámetros. El compilador elige el que corresponde a los argumentos con los que se invoca. Esto se llama **sobrecarga**.

```java
// Calculadora.java
public class Calculadora {

    public int producto(int a, int b) {
        return a * b;
    }

    public double producto(double a, double b) {
        return a * b;
    }
}
```

```java
// PruebaCalculadora.java
public class PruebaCalculadora {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        System.out.println(calc.producto(2, 3));      // usa la versión int
        System.out.println(calc.producto(2.0, 3.5));  // usa la versión double
    }
}
```

```text
6
7.0
```

!!! warning "El tipo de retorno no basta"
    Dos métodos que solo se diferencian en el tipo de retorno **no** son una sobrecarga válida: el compilador no podría decidir cuál usar.

## 2.7. Constructores

Un **constructor** es un método especial que se ejecuta al crear un objeto y se encarga de **dejarlo en un estado inicial válido**. Se reconoce porque:

- se llama **exactamente igual que la clase**;
- **no tiene tipo de retorno** (ni siquiera `void`).

```java
// Cuenta.java
public class Cuenta {

    // Atributos
    private String titular;
    private String numero;
    private double saldo;

    // Constructor
    public Cuenta(String titular, String numero, double saldo) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo;
    }

    // Métodos
    public void imprimir() {
        System.out.println(titular + " (" + numero + "): " + saldo + " EUR");
    }

    public void ingresar(double cantidad) {
        saldo = saldo + cantidad;
    }

    public void retirar(double cantidad) {
        saldo = saldo - cantidad;
    }

    public double getSaldo() {
        return saldo;
    }
}
```

!!! info "Constructor por defecto"
    Si **no escribes ningún constructor**, el compilador genera uno sin parámetros que deja los atributos con sus valores por defecto. En cuanto escribes **alguno**, ese constructor automático deja de existir. Una clase puede tener varios constructores (sobrecarga).

## 2.8. La referencia `this`

Dentro de los métodos no estáticos y de los constructores, `this` es una referencia **al propio objeto** que está ejecutando el código. Se usa sobre todo para distinguir un atributo de un parámetro con el mismo nombre:

```java
public Cuenta(String titular, String numero, double saldo) {
    this.titular = titular;   // atributo = parámetro
    this.numero = numero;
    this.saldo = saldo;
}
```

Sin `this`, `titular = titular;` asignaría el parámetro a sí mismo y el atributo no cambiaría.

## 2.9. Crear objetos y referencias

Una variable cuyo tipo es una clase **no contiene el objeto**, sino una **referencia** (la «dirección») a él. Declarar la variable no crea ningún objeto: el objeto se crea explícitamente con el operador `new`.

```java
Cuenta cuenta1;                                       // referencia: vale null
cuenta1 = new Cuenta("Pérez", "154000345", 2000);     // se crea el objeto
cuenta1.ingresar(500);                                // mensaje al objeto
```

Dos variables pueden referirse **al mismo objeto**. Copiar una referencia no copia el objeto:

```java
// PruebaReferencias.java
public class PruebaReferencias {
    public static void main(String[] args) {
        Cuenta a = new Cuenta("Pérez", "154000345", 2000);
        Cuenta b = a;                    // b apunta al MISMO objeto que a
        b.ingresar(500);
        System.out.println(a.getSaldo()); // el objeto es uno solo
    }
}
```

```text
2500.0
```

Una referencia que vale `null` no apunta a ningún objeto. Enviarle un mensaje provoca el error `NullPointerException`:

```java
Cuenta c = null;
c.imprimir();    // NullPointerException en tiempo de ejecución
```

### El recolector de basura

Los objetos consumen memoria mientras existen. En Java **no tienes que liberarla a mano**: un proceso llamado **recolector de basura** (*garbage collector*) detecta los objetos a los que ya no apunta ninguna referencia y recupera su espacio.

```java
Cuenta c = new Cuenta("García", "112899665", 100);
c = new Cuenta("López", "200300400", 50);   // el objeto de García queda sin referencias
```

## 2.10. Atributos y métodos estáticos

Normalmente cada objeto tiene **su propia copia** de cada atributo. Si queremos un valor **compartido por todas las instancias** de una clase usamos `static`. Los atributos estáticos pertenecen a la **clase** y se manejan con **métodos estáticos**, que se invocan con el nombre de la clase.

```java
// Documento.java
public class Documento {

    private static int version;          // uno solo para toda la clase
    private int numeroDeCapitulos;       // uno por cada objeto

    public Documento(int numeroDeCapitulos) {
        this.numeroDeCapitulos = numeroDeCapitulos;
    }

    public void anadirCapitulo() {
        numeroDeCapitulos++;
    }

    public int getNumeroDeCapitulos() {
        return numeroDeCapitulos;
    }

    public static void modificarVersion(int nuevaVersion) {
        version = nuevaVersion;
    }

    public static int getVersion() {
        return version;
    }
}
```

```java
// PruebaDocumentos.java
public class PruebaDocumentos {
    public static void main(String[] args) {
        Documento doc1 = new Documento(5);
        Documento doc2 = new Documento(7);
        Documento doc3 = new Documento(15);

        doc1.anadirCapitulo();                          // método de objeto
        System.out.println("Capítulos de doc1: " + doc1.getNumeroDeCapitulos());
        System.out.println("Capítulos de doc2: " + doc2.getNumeroDeCapitulos());

        Documento.modificarVersion(10);                 // método de clase
        System.out.println("Versión (compartida): " + Documento.getVersion());
    }
}
```

```text
Capítulos de doc1: 6
Capítulos de doc2: 7
Versión (compartida): 10
```

Hay tres objetos, cada uno con su número de capítulos, pero **una única** `version` para todos.

!!! warning "Un método estático solo accede a miembros estáticos"
    Un método `static` no pertenece a ningún objeto en concreto, así que **no puede usar `this`** ni acceder a atributos de instancia.

## 2.11. Ejemplo completo: la clase `Persona`

Esta clase nos acompañará durante todo el curso.

```java
// Persona.java
public class Persona {

    // Atributos (privados)
    private String dni;
    private String nombre;
    private int edad;
    private String estadoCivil;

    // Constructor
    public Persona(String dni, String nombre, int edad, String estadoCivil) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.estadoCivil = estadoCivil;
    }

    // Métodos (públicos)
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
        this.edad = edad;
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

    @Override
    public String toString() {
        return "Persona{dni=" + dni + ", nombre=" + nombre
                + ", edad=" + edad + ", estadoCivil=" + estadoCivil + "}";
    }
}
```

```java
// PruebaPersonas.java
public class PruebaPersonas {
    public static void main(String[] args) {
        // Creamos personas (instanciación)
        Persona per1 = new Persona("153647458S", "Pepe", 35, "casado");
        Persona per2 = new Persona("452697419Z", "Maria", 25, "soltera");

        // Enviamos mensajes (aplicamos métodos)
        System.out.println("Nombre: " + per2.getNombre());
        per2.cumpleanos();
        System.out.println("Edad: " + per2.getEdad());
        System.out.println("Información completa: " + per2.toString());
    }
}
```

```text
Nombre: Maria
Edad: 26
Información completa: Persona{dni=452697419Z, nombre=Maria, edad=26, estadoCivil=soltera}
```

!!! note "`toString()` y `@Override`"
    `toString()` devuelve una representación en texto del objeto. Todas las clases lo tienen aunque no lo escribas, pero la versión por defecto no es útil; aquí la **redefinimos**. Más adelante entenderás por qué (capítulo 4).

!!! tip "En UML"
    ```mermaid
    classDiagram
        class Persona {
            -String dni
            -String nombre
            -int edad
            -String estadoCivil
            +Persona(String dni, String nombre, int edad, String estadoCivil)
            +getDni() String
            +getNombre() String
            +getEdad() int
            +setEdad(int edad) void
            +cumpleanos() void
            +toString() String
        }
    ```

## Resumen del capítulo

- Una **clase** es la plantilla de unos objetos; un **objeto** es una instancia de una clase.
- La clase es a la vez **módulo** (organiza el código) y **tipo de dato**.
- Los **constructores** inicializan el objeto; `new` lo crea; `this` es el propio objeto.
- Las variables de objeto guardan **referencias**; dos referencias pueden apuntar al mismo objeto.
- `static` crea miembros **de la clase**, compartidos por todas las instancias.

## Actividades

**Actividad 1.** Escribe la clase `Libro` con los atributos `titulo`, `autor` y `paginas`, un constructor con los tres, un método `getPaginas()` y un método `toString()`.

??? success "Solución"
    ```java
    // Libro.java
    public class Libro {
        private String titulo;
        private String autor;
        private int paginas;

        public Libro(String titulo, String autor, int paginas) {
            this.titulo = titulo;
            this.autor = autor;
            this.paginas = paginas;
        }

        public int getPaginas() {
            return paginas;
        }

        @Override
        public String toString() {
            return titulo + " (" + autor + ", " + paginas + " págs.)";
        }
    }
    ```

**Actividad 2.** ¿Qué imprime este programa? Explica por qué.

```java
Cuenta x = new Cuenta("Ana", "1", 100);
Cuenta y = new Cuenta("Ana", "1", 100);
Cuenta z = x;
z.ingresar(50);
System.out.println(x.getSaldo());
System.out.println(y.getSaldo());
```

??? success "Solución"
    Imprime `150.0` y `100.0`. `z` es una copia de la **referencia** de `x`, así que ambas apuntan al mismo objeto y el ingreso afecta a `x`. `y` es otro objeto distinto, aunque sus valores coincidan.

**Actividad 3.** Crea la clase `Alumno` con un atributo `nombre` y un **contador estático** que indique cuántos alumnos se han creado. Añade el método estático `getTotalAlumnos()`.

??? success "Solución"
    ```java
    // Alumno.java
    public class Alumno {
        private static int totalAlumnos = 0;   // compartido por todos
        private String nombre;

        public Alumno(String nombre) {
            this.nombre = nombre;
            totalAlumnos++;                    // cada instanciación suma uno
        }

        public String getNombre() {
            return nombre;
        }

        public static int getTotalAlumnos() {
            return totalAlumnos;
        }
    }
    ```
    Tras `new Alumno("Ana"); new Alumno("Luis");`, la llamada `Alumno.getTotalAlumnos()` devuelve `2`.
