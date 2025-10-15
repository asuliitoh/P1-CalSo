# Disconformidades encontradas en Programa.java

### ✅ Disconformidad 1

- **Línea:** `7`.
- **Impacto:** Bajo en Mantenibilidad.
- **Descripción:** Array designators "[]" should be on the type, not the variable.
- **Modificación aplicada:**: SonarQube avisa de que los designadores del array deben ir junto al tipo de dato para una mejor comprensión del codigo. Para solucionar este error, se ha modificado lo siguiente:

```java

/*Antes
public static void main(String args[]) {

...

}
*/

//Ahora
public static void main(String[] args) {

...
}
```

---

### ✅ Disconformidad 2

- **Línea:** `10`.
- **Impacto:** Bajo en Mantenibilidad.
- **Descripción:** Array designators "[]" should be on the type, not the variable.
- **Modificación aplicada:** Misma solución que en la disconformidad anterior.
---

```java

/*Antes
  Punto puntos[] = new Punto[2];
*/

//Ahora
  Punto[] puntos = new Punto[2];
```

---

### ✅ Disconformidad 3 

- **Línea:** `16`.
- **Impacto:** Medio en fiabilidad.
- **Descripción:** Return values from functions withoud side effects should not be ignored.
- **Modificación aplicada:** : Al llamar a la función `concat()`, este devuelve un objeto `String` con la concatenación hecha. Sin embargo, en el programa original, esta salida se ignora dentro de la función Main. Al no utilizar el resultado que nos devuelve, SonarQube marca este issue, pues entiende que la función es inutil o se ha cometido un error durante la programación. En este caso, ocurre lo último.


```java

/*Antes
 for (Punto punto : puntos)
          info.concat(punto.toString());

*/

//Ahora
for (Punto punto : puntos)
    	  info = info.concat(punto.toString());
```

---

### ✅ Disconformidad 4

- **Línea:** `18`.
- **Impacto:** Medio en fiabilidad.
- **Descripción:** String and Boxed Types should be compared using "equals()".
- **Modificación aplicada:** Este aviso se debe a que, en la mayoría de ocasiones, la comparación entre dos instancias de tipo String mediante `==` suele ser errónea al no estar comparando los valores sino sus referencias. En este caso es así, pues se está comparando una variable con la cadena vacía `""`. Para solucionarlo, se usa el método `equals()`.

```java

/*Antes
  String mensaje = (info == "") ? "no hay puntos" : info; 
*/

//Ahora
  String mensaje = (info.equals("")) ? "no hay puntos" : info; 


```

---

### ✅ Disconformidad 5

- **Línea:** `20`.
- **Impacto:** Medio en Mantenibilidad.
- **Descripción:** Standard outputs should not be used directly to log anything.
- **Modificación aplicada:**: A la hora de realizar registros (logs) en nuestra aplicación, se buscan que sean facilmente accesibles, registrados de forma segura en caso de que guarden datos sensibles, correctamente almacenados y formateados de manera uniforme. Estos requisitos no se cumplen si se escribe directamente desde la salida estándar (en este caso, con `System.out`. SonarQube recomienda utilizar un sistema de registro dedicado, como `java.util.logging`.

```java

/*Antes
      public static void main(String[] args) {
      Punto punto1 = new Punto();
      ... 
     System.out.println(mensaje);
    }
}
*/

//Ahora
 public static void main(String[] args) {
      Logger logger = Logger.getLogger(Programa.class.getName());
      Punto punto1 = new Punto();
      ...
     logger.info(mensaje);
    }

```


