/*Question: Fibonacci Number
The Fibonacci numbers, commonly denoted F(n) form a sequence,
called the Fibonacci sequence, such that each number is the sum
of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

Example 2:
Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

Example 3:
Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
*/

import java.util.*;

class MainClass{
    public static int fibMemo(int n,int[] memo){
        if(n==0 || n==1)
            return n;
        if(memo[n] != -1)
            return memo[n];
        return memo[n] = fibMemo(n-1,memo) + fibMemo(n-2,memo);
    }

    public static int fib(int n){
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return fibMemo(n,memo);
    }

    public static void main(String arg[]){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scan.nextInt();
        System.out.println("Fib(n)= " + fib(n));
    }
}