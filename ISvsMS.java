import java.util.Random;

public class ISvsMS {

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        // Recorre el arreglo desde el segundo elemento hasta el final
        for (int i = 1; i < arr.length; i++) {
            // Guarda el elemento actual que se va a insertar
            int key = arr[i];
            // j apunta al elemento anterior al actual
            int j = i - 1;
            // Mueve hacia la derecha todos los elementos mayores que key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Inserta key en su posición correcta
            arr[j + 1] = key;
        }
    }

    // Merge Sort
    public static int[] mergeSort(int[] arr) {
        // Si el arreglo tiene 1 o 0 elementos, ya está ordenado
        if (arr.length <= 1) return arr;
        // Encuentra el punto medio del arreglo
        int mid = arr.length / 2;
        // Ordena recursivamente la mitad izquierda
        int[] left = mergeSort(java.util.Arrays.copyOfRange(arr, 0, mid));
        // Ordena recursivamente la mitad derecha
        int[] right = mergeSort(java.util.Arrays.copyOfRange(arr, mid, arr.length));
        // Une las dos mitades ordenadas
        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        // Crea un arreglo vacío para almacenar el resultado
        int[] result = new int[left.length + right.length];
        // i recorre la mitad izquierda, j la derecha
        int i = 0, j = 0, k = 0;
        // Compara elemento por elemento de ambas mitades
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                // El elemento izquierdo es menor, va primero
                result[k++] = left[i++];
            } else {
                // El elemento derecho es menor, va primero
                result[k++] = right[j++];
            }
        }
        // Agrega los elementos restantes de cada mitad
        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];
        return result;
    }

    // Comparación con n valores distintos
    public static void main(String[] args) {
        int[] ns = {1000, 10000, 100000, 1000000, 10000000};
        Random rand = new Random();

        System.out.printf("%12s | %20s | %16s%n", "n", "Insertion Sort (s)", "Merge Sort (s)");
        System.out.println("-".repeat(55));

        for (int n : ns) {
            // Genera el arreglo aleatorio (este tiempo NO se cuenta)
            int[] arr = rand.ints(n, 0, n * 10).toArray();

            // Mide Insertion Sort solo si n es pequeño, si no tarda horas
            String tiempoInsertion;
            if (n <= 100000) {
                int[] arr1 = arr.clone(); // Copia el arreglo para no modificar el original
                long t0 = System.nanoTime(); // Inicia el tiempo
                insertionSort(arr1); // Corre el algoritmo
                long t1 = System.nanoTime(); // Para el tiempo
                tiempoInsertion = String.format("%.6f", (t1 - t0) / 1e9); // Calcula el tiempo transcurrido
            } else {
                // Para n=1000000 y n=10000000 se omite porque sería demasiado lento
                tiempoInsertion = "muy lento (omitidojava)";
            }

            // Mide Merge Sort para todos los valores de n
            int[] arr2 = arr.clone();
            long t0 = System.nanoTime();
            mergeSort(arr2);
            long t1 = System.nanoTime();
            String tiempoMerge = String.format("%.6f", (t1 - t0) / 1e9);

            System.out.printf("%12d | %20s | %16s%n", n, tiempoInsertion, tiempoMerge);
        }
    }
}