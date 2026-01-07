/*Question: N-th Tribonacci Number
The Tribonacci sequence Tn is defined as follows:
T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
Given n, return the value of Tn.

Example 1:
Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4

Example 2:
Input: n = 25
Output: 1389537
*/

import java.util.*;

class MainClass{
    public static int triboMemo(int n,int[] memo){
        if(n==0)
            return 0;
        if(n==1 || n==2)
            return 1;
        if(memo[n] != -1)
            return memo[n];
        return memo[n] = triboMemo(n-1,memo)+triboMemo(n-2,memo)+triboMemo(n-3,memo);
    }

    public static int tribonacci(int n){
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return triboMemo(n,memo);
    }

    public static void main(String arg[]){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scan.nextInt();
        System.out.println(n + "th tribonacci number: " + tribonacci(n));
    }
}