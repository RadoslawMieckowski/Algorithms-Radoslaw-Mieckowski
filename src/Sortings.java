import java.util.Arrays;

public class Sortings {
    public static void main(String[] args) {
        int[]table = new int[]{3, 4, 6, 7, -1, 0, 3, -5, 8, 2, -2};
//        System.out.println(Arrays.toString(bubbleSort(table)));
//        System.out.println(Arrays.toString(selectionSort(table)));
//        System.out.println(Arrays.toString(insertionSort(table)));
        int[] table1 = new int[] {3, 4, 6, 7};
        int[] table2 = new int[] {-1, 0, 3, 5, 8};
//        System.out.println(Arrays.toString(bubbleSort2(table)));
//        System.out.println(Arrays.toString(merge(table1, table2)));
//        System.out.println(Arrays.toString(mergeSort(table)));
        System.out.println(Arrays.toString(quickSort(table)));
    }

    public static int[] bubbleSort(int[] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i] < table[j]) {
                    int temp = table[j];
                    table[j] = table[i];
                    table[i] = temp;
                }
            }
        }
        return table;
    }
    public static int[] bubbleSort2(int[] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length - 1; j++) {
                if (table[j] > table[j + 1]) {// chcemy, żeby na końcu tablicy były największe wartości
                    int temp = table[j + 1];
                    table[j + 1] = table[j];
                    table[j] = temp;
                }
            }
        }
        return table;
    }

// pomysł polega na tym, żeby w każdej iteracji wybierać lokalne minimum
// i wsadzać je w kolejne pierwsze miejsca
    public static int[] selectionSort(int[] table) {
        int min;
        int indexOfMin;
        for (int start = 0; start < table.length; start++) {
          min = table[start];
          indexOfMin = start;// może się zmieniać kilka razy w ciągu jednej iteracji
          for (int i = start + 1; i < table.length; i++) {
              if (table[i] < min) {
                  min = table[i];
                  indexOfMin = i;
              }
          }
          int temp = table[start];
          table[start] = table[indexOfMin];
          table[indexOfMin] = temp;
      }
        return table;
    }

    public static int[] insertionSort(int[] table) {
        for (int start = 0; start < table.length - 1; start++) {
            int end = start + 1;
            int firstToSwapIndex = end;
            //w następnych iteracjach sprawdzamy, w który index mamy wpakować następną wartość
            int n = start;
            while (n >= 0) {
                if (table[end] < table[n]) {    //jak tablica uporządkowana,to to nie zajdzie,
                    n--;            //a firstToSwapIndex = end
                    firstToSwapIndex--;// to ten indeks
                } else {
                    break;
                }
            }// przesuwamy odpowiednią część tablicy. zakładamy uporządkowanie
            while (firstToSwapIndex != end) {   //jak uporządkowana, to patrz wyżej, O(n)
                int temp = table[firstToSwapIndex];
                table[firstToSwapIndex] = table[end];
                table[end] = temp;
                firstToSwapIndex++;
            }
        }
        return table;
    }

    public static int[] mergeSort(int[] table) {
        if (table.length == 1) {
            return table;
        }
        int middle = table.length / 2;
        int[] leftTable = Arrays.copyOfRange(table, 0, middle);
        int[] rightTable = Arrays.copyOfRange(table, middle, table.length);

        return merge(mergeSort(leftTable), mergeSort(rightTable));
    }

    public static int[] merge(int[] table1, int[] table2) {
        int left = 0;//pointer1
        int right = 0;//pointer2
        int index = 0;  //bardzo ważna zmienna
        int size = table1.length + table2.length;
        int[] sortedTable = new int[size];
        while (index < size) {  // zapełnianie tablicy
            if (table1[left] < table2[right]) {
                sortedTable[index] = table1[left];
                left++;
                index++;//bardzo ważne: porównaj left z ostatnim indeksem
                if (left == table1.length) {//jak wyczerpaliśmy jedną tablicę,
                    for (int j = right; j < table2.length; j++) { // to przepisz wszystko z drugiej
                        sortedTable[index] = table2[j];
                        index++;
                    }
                }
            } else {
                sortedTable[index] = table2[right];
                right++;
                index++;
                if (right == table2.length) {
                    for (int j = left; j < table1.length; j++) {
                        sortedTable[index] = table1[j];
                        index++;
                    }
                }
            }
        }
        return sortedTable;
    }
//tu ogólna zasada bez funkcji mergującej
    public static int[] quickSort(int[] table) {
        int pivot = table[table.length - 1];
        int size = table.length;
        int j = 1;
        for (int i = 0; i < size; i++) {
            if (j - i != 2) {
                while (table[i] > pivot) {
                    table[size - j] = table[i];
                    j++;
                    table[i] = table[size - j];
                    table[size - j] = pivot;
                    pivot = table[size - j];
                }
            } else {
                if (table[i] > table[j--]) {
                    int temp = table[i];
                    table[i] = table[j];
                    table[j] = temp;
                }
                return table;
            }
        }
        return table;
    }
}
