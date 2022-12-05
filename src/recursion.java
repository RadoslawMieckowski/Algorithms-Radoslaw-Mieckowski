import java.util.*;

public class recursion {
    static int counter = 0;
    static long calculationsFast = 0;
    static long calculationsSlow = 0;
    static Map<Long, Long> cache = new HashMap<>();

    public static void main(String[] args) {
//        inception();
//        System.out.println(factorial(5));
      /*sprawdzanie f.swap
      final List<Integer> l = new ArrayList(List.of(0, 1, 2, 3));
        l.set(1, l.set(2, l.get(1)));
        System.out.println(l);*/
//        Collections.sort(); to merge sort
        System.out.println(fibonacciSlow(35));
        System.out.println("number of calculationsSlow: " + calculationsSlow);
        System.out.println(fibonacciFast(35));
        System.out.println("number of calculationsFast: " + calculationsFast);
    }

    public static String inception() {
        System.out.println(counter);
        if (counter > 3) {
            return "done";
        }
        counter++;
        return inception();
    }

    public static long factorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }

    public static long fibonacciFast(long number) {
        if (cache.containsKey(number)) {
            return cache.get(number);
        } else {
            if (number == 1) {
                return 1;
            } else if (number == 0) {
                return 0;
            } else {
                calculationsFast++;
                cache.put(number, fibonacciFast(number - 1) + fibonacciFast(number - 2));
                return cache.get(number);
            }
        }
    }

    public static long fibonacciSlow(long number) {
        if (number == 1) {
            return 1;
        } else if (number == 0) {
            return 0;
        } else {
            calculationsSlow++;
            return fibonacciSlow(number - 1) + fibonacciSlow(number - 2);
        }
    }
}
