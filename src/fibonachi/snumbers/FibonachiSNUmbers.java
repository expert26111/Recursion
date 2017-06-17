package fibonachi.snumbers;

import java.util.Scanner;

/**
 *
 * @author yoyo
 */
public class FibonachiSNUmbers {
      public static long[] numbers; 
    //realizaciq za namirane entoto 4islo na fibonachi
    public static void main(String[] args) {
        System.out.println("Lets get the 8th Fibonaci number  " + fib(8));
        System.out.println("Lets get the 3th Factorial number  " + factorial(3));
        System.out.println("Lets get the 3th Factorial number  " + factorialIterative(3));
        
        Scanner input = new Scanner(System.in);
        System.out.print("n = ");
        int n = input.nextInt();
 
        numbers = new long[n + 2];
        numbers[1] = 1;
        numbers[2] = 1;
 
        long result = fibRefurbished(n);
        System.out.printf("F%d = %d%n", n, result);
        input.close();
    }

    //extremely ineffective using of recursion
    //if no base case StackOverflowException
    //breaking the decision to small decision and after combining them 
    //we should get the answer
    //we have to aim to reach the base case
    //the recursive decisions can consumate a lot of resources
    //the tree of calling expandas exponantially
    //fib(100) = 1.6^100 but iterative is linear fib(100) = 100
    //Можем да оптимизираме рекурсивния метод за 
    //изчисление на числата на Фибоначи, като записваме вече 
    //пресметнатите числа в масив и извърш­ваме рекурсивно извикване
    //само ако числото, което пресмятаме, не е било все до пресметнато до момента. 
    // Благодарение на тази малка оптими­зация, рекурсивното 
    //реше­ние ще работи с линейна сложност. Ето приме­рна реализация:
    public static long fib(int n) {
        if (n <= 2) {
            return 1;//base case
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static long factorial(int n) {
        // The bottom of the recursion
        if (n == 0) {
            return 1;
        } // Recursive call: the method calls itself
        else {
            return n * factorial(n - 1);
        }
    }

    public static long factorialIterative(int n) {
        long result = 1;

        for (int i = 1; i <= n; i++) {
            result = result * i;
        }

        return result;
    }
    
       public static long fibRefurbished(int n) {
        if (0 == numbers[n]) {
            numbers[n] = fibRefurbished(n - 1) + fibRefurbished(n - 2);
        }
 
        return numbers[n];
    }

}
