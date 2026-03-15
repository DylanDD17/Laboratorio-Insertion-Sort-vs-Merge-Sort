import time
import random

# Insertion Sort
def insertion_sort(arr):
    # Recorre el arreglo desde el segundo elemento hasta el final
    for i in range(1, len(arr)):
        # Guarda el elemento actual que se va a insertar
        key = arr[i]
        # j apunta al elemento anterior al actual
        j = i - 1
        # Mueve hacia la derecha todos los elementos mayores que key
        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j -= 1
        # Inserta key en su posición correcta
        arr[j + 1] = key
    return arr

# Merge Sort
def merge_sort(arr):
    # Si el arreglo tiene 1 o 0 elementos, pues ya está ordenado
    if len(arr) <= 1:
        return arr
    # Encuentra el punto medio del arreglo
    mid = len(arr) // 2
    # Ordena recursivamente la mitad izquierda
    left = merge_sort(arr[:mid])
    # Ordena recursivamente la mitad derecha
    right = merge_sort(arr[mid:])
    # Une las dos mitades ordenadas
    return merge(left, right)

def merge(left, right):
    # Crea un arreglo vacío para almacenar el resultado
    result = []
    # i recorre la mitad izquierda, j la derecha
    i = j = 0
    # Compara elemento por elemento de ambas mitades
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            # El elemento izquierdo es menor, va primero
            result.append(left[i]); i += 1
        else:
            # El elemento derecho es menor, va primero
            result.append(right[j]); j += 1
    
    # Agrega los elementos restantes de cada mitad
    result.extend(left[i:])
    result.extend(right[j:])

    return result

# Comparación con n valores distintos
ns = [1000, 10000, 100000, 1000000, 10000000]

print(f"{'n':>12} | {'Insertion Sort (s)':>15} | {'Merge Sort (s)':>15}")
print("-" * 55)

for n in ns:
    # Genera el arreglo aleatorio (este tiempo NO se cuenta)
    arr = random.sample(range(n * 10), n)

# Mide Insertion Sort solo si n es pequeño, si no tarda horas
    if n <= 100000:
        arr1 = arr.copy() # Copia el arreglo para no modificar el original
        t0 = time.perf_counter() # Inicia el tiempo
        insertion_sort(arr1) # Corre el algoritmo
        t1 = time.perf_counter() # Para el tiempo
        tiempo_insertion = f"{t1 - t0:.6f}" # Calcula el tiempo transcurrido
    else:
        # Para n=1000000 y n=10000000 se omite porque sería demasiado lento
        tiempo_insertion = "muy lento (omitido)"

# Mide Merge Sort para todos los valores de n
    arr2 = arr.copy()
    t0 = time.perf_counter()
    merge_sort(arr2)
    t1 = time.perf_counter()
    tiempo_merge = f"{t1 - t0:.6f}"

    print(f"{n:>12} | {tiempo_insertion:>20} | {tiempo_merge:>16}")