## Disconformidad 1  

**Línea:** 19  
**Archivo:** `Direccion.java`  
**Ubicación:** `/P1-CalSo/p1-calso/src/main/java/juego/geometria`  

**Impacto:**  
Bajo — Afecta a la **coherencia de estilo** del código y la **legibilidad** del mismo. La declaración de arrays con los corchetes `[]` colocados después del nombre de la variable no sigue las convenciones establecidas. Esto no afecta al comportamiento del programa, pero reduce la consistencia de estilo con respecto al resto del código.  

**Descripción:**  

> *Move the array designators [] to the type.*  

El array `Direccion arrayDirecciones[] = Direccion.values();` está declarado con los corchetes a continuación del nombre de la variable.
La convención recomienda colocarlos junto al tipo, es decir: `Direccion[] arrayDirecciones`.  

**Modificación aplicada:**  
Se cambia la posición de los corchetes a continuación del tipo.  

```java
// Antes
Direccion arrayDirecciones[] = Direccion.values();

// Después

Direccion[] arrayDirecciones = Direccion.values();
```


---


## Disconformidad 2  

**Línea:** 21  
**Archivo:** `Direccion.java`  
**Ubicación:** `/P1-CalSo/p1-calso/src/main/java/juego/geometria`  

**Impacto:**
Medio — Afecta a la **eficiencia** y al **rendimiento** del programa. Crear una nueva instancia de `Random` cada vez que se llama al método `aleatoria()` provoca una sobrecarga innecesaria.

**Descripción:**

> *Save and re-use this "Random".*

El objeto `Random rnd = new Random();` se crea dentro del método `aleatoria()`, de modo que se instancia cada vez que se llama al método. De modo que se debería reutilizar una instancia única de `Random` compartido por todas las llamadas.

**Modificación aplicada:**
Se declara una única instancia estática de `Random` en la clase, y se utiliza en el método `aleatoria()`.

### Código original:

```java
//Antes

public Direccion aleatoria() {
    Direccion[] arrayDirecciones = Direccion.values();

    Random rnd = new Random();
    int indice = rnd.nextInt(4);

    return arrayDirecciones[indice];
}

// Después

private static final Random RAND = new Random();

...

public Direccion aleatoria() {
    Direccion[] arrayDirecciones = Direccion.values();
    int indice = RAND.nextInt(4);
    return arrayDirecciones[indice];
}
```


---
