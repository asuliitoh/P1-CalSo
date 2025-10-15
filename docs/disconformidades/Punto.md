# Disconformidades encontradas en Punto.java

### ✅ Disconformidad 1

- **Línea:** `3`.
- **Impacto:** Bajo en Mantenibilidad.
- **Descripción:** Unnecesary imports should be removed.
- **Modificación aplicada:** Se ha eliminado la importación de la librería `java.lang.Math`, debido a que todas las librerias contenidas en `java.lang` estan implícitamente importadas. También se ha eliminado `java.util.Random` al no ser utilizada.

---

### ✅ Disconformidad 2

- **Línea:** `10`.
- **Impacto:** Bajo en Mantenibilidad.
- **Descripción:** Modifiers should be declared in the correct order.
- **Modificación aplicada:** Se ha utilizado el modificador `static` antes que el `final` en la declaración de la variable `defaultValue` para cumplir con el orden de la especificación de java.

---

### ✅ Disconformidad 3

- **Línea:** `10`.
- **Impacto:** Alto en Mantenibilidad.
- **Descripción:** Constant names should comply with a naming convention.
- **Modificación aplicada:** : Al tratarse de una constante, según la convención, su nombre debe estar escrito en mayúsculas. Se cambia el nombre de la variable `defaultValue` a `DEFAULTVALUE`.

---

### ✅ Disconformidad 4

- **Línea:** `50`.
- **Impacto:** Bajo en Mantenibilidad.
- **Descripción:** Method names should comply with a naming convention.
- **Modificación aplicada:** : Según la convención, para los nombres de los métodos, la primera palabra debe ir en minúsculas y el resto de palabras deben empezar con mayúscula. Se cambia el nombre de la función `Adyacente()` a `adyacente()`.

---

### ✅ Disconformidad 5

- **Línea:** `81`.
- **Impacto:** Bajo en Mantenibilidad.
- **Descripción:** Method names should comply with a naming convention.
- **Modificación aplicada:** : Además de lo anterior mencionado, tampoco se permiten el uso de guiones bajos. Se cambia el nombre de la función `situacion_relativa()` a `situacionRelativa()`.

---

### ✅ Disconformidad 5

- **Línea:** `113`.
- **Impacto:** Medio en Mantenibilidad.
- **Descripción:** Unused "private" methods should be removed.
- **Modificación aplicada:** : Aquellas funciones privadas que no son llamadas dentro de la clase se consideran código muerto. Su eliminación previene la introducción de bugs, facilita el entendimiento del código y reduce el código que mantener. Se elimina el método `distancia()`.
---

### ✅ Disconformidad 6

- **Línea:** `125`.
- **Impacto:** Medio en Mantenibilidad.
- **Descripción:** "equals" method overrides should accept "Object" parameters.
- **Modificación aplicada:** : El método `equals()` definido en clase no es una redefinición del proporcionado por la clase `Object`, debido a que este útlimo requiere como parámetro un objeto tipo `Object`. Para corregir esta disconformidad, se tiene que redefinir este método  o cambiarle el nombre a la función definida dentro de esta clase para evitar confusiones. Se ha optado por la primera solución.

---

### ✅ Disconformidad 7

- **Línea:** `125`.
- **Impacto:** Bajo en fiabilidad.
- **Descripción:** "equals(Object obj)" should test the argument's type.
- **Modificación aplicada:** : Esta disconformidad aparece tras corregir la anterior, ya que no se realiza comprobación antes del casteo de `obj`, lo que provocaría una excepción en el caso de que los dos objetos no sean del mismo tipo. Para solucionarlo, se añade una comprobación previa y se devuelve falso en caso de que `obj` no sea de tipo `Punto`.

---

### ✅ Disconformidad 8

- **Línea:** `125`.
- **Impacto:** Bajo en fiabilidad.
- **Descripción:** "equals(Object obj)" and "hashCode()" should be overriden in pairs.
- **Modificación aplicada:** : De acuerdo a la especificación de Java, existe un contrato entre estos dos métodos de tal manera que, si dos objetos son iguales según `equals()`, el valor que produce la función `hashCode()` debe ser el mismo para los dos objetos. Para solucionarlo, se debe sobreescribir la última función mencionada, utilizando para el cálculo del hash los mismos campos que `equals()` comprueba.

```java

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (! (obj instanceof Punto)) return false;
		Punto other = (Punto) obj;
		return  (x == other.x && y == other.y);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(this.x, this.y);
	}

```
---

### ✅ Disconformidad 9

- **Línea:** `139`.
- **Impacto:** Alto en mantenibilidad.
- **Descripción:** "clone" should not be overriden.
- **Modificación aplicada:** : El mecanismo de copia mediante `Object.clone` se considera roto debido a que no ejecuta previamente el constructor, por lo que si este validaba precondiciones, inicializaba estructuras o realizaba otra acción, la copia resultante de este método puede estar incompleto o ser incorrecto. Se recomiendan otros mecanismos, como la copia mediante el constructor.

```java
	
// Constructor por defecto
	public Punto() {
		this (0, 0);
	
	}

	// Constructor
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// Constructor de copia
	public Punto(Punto otra) {
		this(otra.x, otra.y);
	}

```

---