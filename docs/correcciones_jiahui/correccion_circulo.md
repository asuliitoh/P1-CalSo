## Disconformidad 1  

**Línea:** 5  
**Archivo:** `circulo.java`  
**Ubicación:** `/P1-CalSo/p1-calso/src/main/java/juego/geometria`  

**Impacto:**  
Medio — Afecta a la **seguridad y encapsulación** del código. Un campo `public static` es modificable desde fuera de la clase, lo que rompe el principio de ocultación de información, provocando inconsistencias.  

**Descripción:**  

> *Make DEFAULT_RADIO a static final constant or non-public and provide accessors if needed.*  

El campo `DEFAULT_RADIO` está declarado como `public static`, lo que expone su valor a las demás clases y permite su modificación. Debería restringirse su acceso o declararse como constante usando `final`.  

**Modificación aplicada:**  
Se cambia el modificador de acceso a `private` y se agrega un método público para obtener su valor.  

```java
// Antes
public static int DEFAULT_RADIO = 5;

// Después
private static int DEFAULT_RADIO = 5;

public static int getDefaultRadio() {
    return DEFAULT_RADIO;
}
```


---


## Disconformidad 2  

**Línea:** 5  
**Archivo:** `circulo.java`  
**Ubicación:** `/P1-CalSo/p1-calso/src/main/java/juego/geometria`  

**Impacto:**  
Medio — Afecta a la **inmutabilidad**. Una constante que define un valor fijo debería ser `final` para evitar modificaciones en tiempo de ejecución.  

**Descripción:**

> *Make this "public static DEFAULT_RADIO" field final.*

El campo `DEFAULT_RADIO` no está declarado como `final`, lo que permite modificar su valor más adelante.

**Modificación aplicada:**
Se declara el campo como `final` para garantizar su inmutabilidad.

```java
// Antes
private static int DEFAULT_RADIO = 5;

// Después
private static final int DEFAULT_RADIO = 5;
```


---


## Disconformidad 3

**Línea:** 3  
**Archivo:** `circulo.java`  
**Ubicación:** `/P1-CalSo/p1-calso/src/main/java/juego/geometria`  

**Impacto:**  
Bajo — Afecta a la **convención de nomenclatura** y a la **coherencia del código**. El incumplimiento de las convenciones de nombres puede dificultar la legibilidad y mantenimiento del código, así como causar confusión.  

**Descripción:**  

> *Rename this class name to match the regular expression '^[A-Z][a-zA-Z0-9]*$'.*  

La clase `circulo` no sigue la convención de nombres de clases en Java, que deben comenzar con una letra mayúscula. Esto contraviene las recomendaciones de estilo de código establecidas en la guía de Java y las reglas de SonarLint.  

**Modificación aplicada:**  
Se renombra la clase de `circulo` a `Circulo` y se actualiza el nombre del archivo.  

```java
// Antes
package juego.geometria;

public class circulo {
    ...
}

// Después

package juego.geometria;

public class Circulo {
    ...
}
```


Además, se **renombra el archivo** y se actualizan las referencias en el código:  

```
circulo.java → Circulo.java
```


---

## Disconformidad 4  

**Línea:** 13  
**Archivo:** `circulo.java`  
**Ubicación:** `/P1-CalSo/p1-calso/src/main/java/juego/geometria`  

**Impacto:**  
Alto — Afecta a la **claridad del código** y puede inducir errores lógicos. El parámetro `centroIni` se pasa al constructor pero no se utiliza, lo que sugiere un error de implementación.  

**Descripción:**  

> *Remove this unused method parameter "centroIni".*  

El parámetro `centroIni` en el constructor `Circulo(Punto centroIni, int radioIni)` no se usa en el cuerpo del método. De modo que `centro` nunca se inicializa usando este constructor, lo cual podría causar excepciones al invocar otros métodos que utilicen `centro`.  

**Modificación aplicada:**  
Se utiliza el parámetro `centroIni` para inicializar correctamente el atributo `centro`. De esta forma, se elimina la disconformidad y se asegura el correcto funcionamiento de la clase.

```java
// Antes
public Circulo(Punto centroIni, int radioIni){
    radio = radioIni;
}

// Después

public Circulo(Punto centroIni, int radioIni){
    centro = new Punto(centroIni);
    radio = radioIni;
}
```


---