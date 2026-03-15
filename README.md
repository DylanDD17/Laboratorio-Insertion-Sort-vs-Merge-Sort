# Comparación de Algoritmos de Ordenamiento: Insertion Sort vs Merge Sort

Este repositorio contiene la implementación de los algoritmos de ordenamiento **Insertion Sort** y **Merge Sort** con el objetivo de analizar y comparar su rendimiento utilizando diferentes tamaños de arreglos.

Los algoritmos fueron implementados en **Python** y **Java**, permitiendo observar diferencias tanto en complejidad algorítmica como en el rendimiento según el lenguaje de programación.

## Archivos del proyecto

* `ISvsMS.java` → Implementación de Insertion Sort y Merge Sort en Java.
* `ISvsMS.py` → Implementación de Insertion Sort y Merge Sort en Python.

## Tamaños de prueba utilizados

Los algoritmos se ejecutan utilizando arreglos con los siguientes tamaños:

* 1 000 elementos
* 10 000 elementos
* 100 000 elementos
* 1 000 000 elementos
* 10 000 000 elementos

---

# Cómo ejecutar el código

## Ejecución en Python

### Requisitos

* Tener instalado **Python 3.x**.

### Pasos

1. Abrir una terminal o consola en la carpeta del proyecto.
2. Ejecutar el siguiente comando:

```bash
python ISvsMS.py
```

3. El programa ejecutará los algoritmos **Insertion Sort** y **Merge Sort** y mostrará los tiempos de ejecución para los diferentes tamaños de arreglos.

---

## Ejecución en Java

### Requisitos

* Tener instalado **Java JDK 8 o superior**.

### Pasos

1. Abrir una terminal en la carpeta donde se encuentra el archivo.
2. Compilar el programa:

```bash
javac ISvsMS.java
```

3. Ejecutar el programa:

```bash
java ISvsMS
```

4. El programa ejecutará los algoritmos de ordenamiento y mostrará los tiempos de ejecución obtenidos.

---

## Notas

* **Insertion Sort** presenta complejidad aproximada de **O(n²)**, por lo que su tiempo de ejecución aumenta rápidamente con arreglos grandes.
* **Merge Sort** presenta complejidad **O(n log n)**, lo que lo hace más eficiente para grandes volúmenes de datos.

Los tiempos de ejecución dependen de bastantes factores: Máquina, Lenguaje y Entorno de Desarrollo.
