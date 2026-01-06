/*Question: Pascal's Triangle
Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]
*/

import java.util.*;

class MainClass{
    public static ArrayList<ArrayList<Integer>> pascalTriangle(int n){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> arr = new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i)
                    arr.add(1);
                else
                    arr.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            res.add(arr);
        }
        return res;
    }

    public static void main(String arg[]){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scan.nextInt();
        ArrayList<ArrayList<Integer>> arr = pascalTriangle(n);
        for(int i=0;i<arr.size();i++)
            System.out.println(arr.get(i));
    }
}