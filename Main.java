import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in); // it is for input values from keyboard


    /**
     * 1 task
     * this function find and return the minimum value of an array using streams
     * Time complexity: O(n) . where n is the input number
     * loop execute 'n' iterations reading and saving , that means this operation have an O(n)
     * find min value using stream performs a linear search and has also O(n) time complexity
     */
    public static int minVal(int n, int[] arr) {


        for (int i = 0; i < n; i++) { // filling the array with values from console
            arr[i] = sc.nextInt();
        }
        // Array.stream(arr) converts array to stream
        // min() find the minimum value from array
        // getAsInt () return found number as integer
        int min = Arrays.stream(arr).min().getAsInt();

        return min;// return found min value
    }


    /**
     * #2 task
     * this function return the average value from an array
     * Time complexity: O(n) . where n is the input number
     * time complexity depends on number of elements
     */
    public static double averageVal(int n, int[] arr) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i]; // sum up all elements from array
        }
        return sum / n; // return sum divided by size of array
    }


    /**
     * #3 task
     * This function defines is the input number is prime or not , using simply 'if - statement' and loop
     * Time complexity: O(√n) . where n is the input number , loop iterates from 2 till square root of 'n'
     * that means the time complexity will be O(√n)
     */
    public static boolean isPrime(int n) {
        if (n < 2) return false; // 0 and 1 are not a prime numbers
        for (int i = 2; i * i <= n; i++) { // iterates from 2 to sqrt (n)
            if (n % i == 0) return false; // if it is completely divisible without remainder, then it is not prime

        }
        return true; // it is prime and return true
    }


    /**
     * #4 task
     * Finding n! using recursion
     * Time complexity: O(n) , because to calculate the factorial of a number, n algorithm performs exactly
     * n multiplications, so that's why it is O(n) time complexity
     */

    public static int nFactorial(int n) {
        if (n <= 1) return 1;// factorial of 0 or 1 always equals to 1
        return n * nFactorial(n - 1); // recursion call ,multiply previous elements by subsequent ones

    }

    /**
     * #5 task
     * Function finds and return n-th elements in Fibonacci sequence using recursion
     * Time complexity: O(2^n) , because function makes two subsequent calls to the same function
     * except n<=1 , this leads to an exponential increase in the number of calls.
     */

    public static int nFibonacci(int n) {
        if (n <= 1) return n; // exceptions statements
        return nFibonacci(n - 1) + nFibonacci(n - 2);
    }

    /**
     * #6 task
     * Function  takes 2 values , and return first value in power of second
     * Time complexity: O(n), because each call
     * numInPower()  decreases the value of n by 1 until n becomes 0,
     * time complexity of the algorithm is linear with respect to the value n
     */
    public static int numInPower(int a, int n) {
        if (n == 0) return 1;
        return (a * numInPower(a, n - 1));

    }
//--------------------------------------------------------------------------------------

    /**
     * #7 task
     * I divided this task on two separate functions , first function is  helper
     * this function for reversing part of the array
     * second function to reverse array at all
     * Time Complexity 1 func : O(n) each pair of elements is exchanged once
     * Time Complexity 2 func : The time complexity of reverseArray() directly depends
     * on the time complexity of the helper() function called inside it.
     * thus it also O(n)
     */

    static void helper(int l, int r, ArrayList<Integer> arr) {
        if (l >= r) return;// Basic case of recursion when indices meet or overlap
        Collections.swap(arr, l, r);//swap the elements
        helper(l + 1, r - 1, arr);//Recursively call the method
        // shifting the boundaries of the subarray to the middle
    }

    // it is the main method for reversing all array
    public static void reverseArray(ArrayList<Integer> arr) {
        helper(0, arr.size() - 1, arr); //reverse all array
    }
//------------------------------------------------------------------------------------------

    /**
     * #8 task
     * This function defines is the string has all digit symbols or not
     * Time complexity : O(n), because Each method call includes a
     * s.charAt(0) and s.substring(1) operation, which has time complexity O(n)
     *
     * @param s for the checking
     * @return true , if string consist only from digits, otherwise false
     */

    public static boolean isAllDigits(String s) {
        if (s.isEmpty()) {
            return true;
        }
        // firstly checking is the first element of string is digit using Character.isDigit()
        //isAllDigits() recursively for the remaining substring.
        // If the first character is not a number, false will be returned.
        // If the current character is a digit, the recursion will continue.
        return Character.isDigit(s.charAt(0)) && isAllDigits(s.substring(1));
    }


    /**
     * #9 task
     * Finds Binomial coef using given formula C(n, k) = C(n-1, k-1) + C(n-1, k)
     * Time : O(k) , Where k is the second argument of the binomCoef function.
     * the main work is done inside a loop that iterates k times
     */
    public static int binomCoef(int n, int k) {
        if (k > n - k) {// to reduce the number of iterations in the next loop
            k = n - k; // C(n, k) = C(n, n-k)
        }
        long result = 1;
        for (int i = 1; i <= k; i++) {
            result *= n - (k - i);
            result /= i;
        }
        return (int) result;
    }


    /**
     * #10 task
     * And Finally! Last function find gcd of (a,b) using Euclidean Algorithm
     * consist base condition
     * and return by calling a function with new
     * parameters: b and the remainder of dividing a by b
     * Time :O(log(min(a, b)) logarithmic complexity because
     * the algorithm reduces the size of numbers at each step by division.
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }


    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("Select a task to execute (enter 0 to exit):");
            System.out.println("1 - Find the minimum value in an array");
            System.out.println("2 - Calculate the average value of an array");
            System.out.println("3 - Check if a number is prime");
            System.out.println("4 - Find the factorial of a number");
            System.out.println("5 - Find the nth Fibonacci number");
            System.out.println("6 - Raise a number to a power");
            System.out.println("7 - Reverse an array");
            System.out.println("8 - Check if a string consists only of digits");
            System.out.println("9 - Calculate the binomial coefficient");
            System.out.println("10 - Find the GCD of two numbers");

            System.out.print("Enter the number of task :");
            int key = sc.nextInt();
            if (key == 0) {
                break;
            }

            switch (key) {
                case 1:
                    System.out.println("Enter array size:");
                    int n1 = sc.nextInt();
                    int[] arr1 = new int[n1];
                    System.out.println("Minimum value: " + minVal(n1, arr1));
                    break;
                case 2:
                    System.out.println("Enter array size:");
                    int n2 = sc.nextInt();
                    int[] arr2 = new int[n2];
                    System.out.println("Average value: " + averageVal(n2, arr2));
                    break;
                case 3:
                    System.out.println("Enter a number to check for primality:");
                    int num = sc.nextInt();
                    System.out.println(num + " is " + (isPrime(num) ? "prime" : "composite"));
                    break;
                case 4:
                    System.out.println("Enter a number to find its factorial:");
                    int n4 = sc.nextInt();
                    System.out.println("Factorial: " + nFactorial(n4));
                    break;
                case 5:
                    System.out.println("Enter n to find the nth Fibonacci number:");
                    int n5 = sc.nextInt();
                    System.out.println("nth Fibonacci number: " + nFibonacci(n5));
                    break;
                case 6:
                    System.out.println("Enter base and exponent:");
                    int base = sc.nextInt();
                    int exp = sc.nextInt();
                    System.out.println("Result: " + numInPower(base, exp));
                    break;
                case 7:
                    System.out.println("Enter array size and elements to reverse:");
                    int n7 = sc.nextInt();
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = 0; i < n7; i++) {
                        list.add(sc.nextInt());
                    }
                    reverseArray(list);
                    System.out.println("Reversed array: " + list);
                    break;
                case 8:
                    System.out.println("Enter a string to check if it consists only of digits:");
                    sc.nextLine(); // Clear buffer
                    String str = sc.nextLine();
                    System.out.println("Is all digits: " + (isAllDigits(str) ? "yes" : "no"));
                    break;
                case 9:
                    System.out.println("Enter n and k to calculate the binomial coefficient (C(n, k)):");
                    int n9 = sc.nextInt();
                    int k9 = sc.nextInt();
                    System.out.println("Binomial coefficient: " + binomCoef(n9, k9));
                    break;
                case 10:
                    System.out.println("Enter two numbers to find their GCD:");
                    int a10 = sc.nextInt();
                    int b10 = sc.nextInt();
                    System.out.println("GCD: " + gcd(a10, b10));
                    break;

                default:
                    System.out.println("Invalid selection. Please enter a number from 1 to 10 or 0 to exit.");
            }
        }
    }
}