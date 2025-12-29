package Greedy;
/*
Problem Description



Given two integer arrays A and B of size N. There are N gas stations along a circular route,
where the amount of gas at station i is A[i].
You have a car with an unlimited gas tank and it costs B[i] of gas to travel from station i to its next station (i+1).
You begin the journey with an empty tank at one of the gas stations.
Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.
You can only travel in one direction. i to i+1, i+2, ... n-1, 0, 1, 2..
Completing the circuit means starting at i and ending up at i again.


Problem Constraints
1 <= |A| <= 5 * 105
|A| == |B|
0 <= Ai <= 5 * 103
0 <= Bi <= 5 * 103


Input Format
The first argument given is the integer array A. The second argument given is the integer array B.


Output Format
Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.


Example Input
A = [1, 2]
B = [2, 1]


Example Output
1


Example Explanation
If you start from index 0, you can fill in A[0] = 1 amount of gas.
Now your tank has 1 unit of gas. But you need B[0] = 2 gas to travel to station 1.

If you start from index 1, you can fill in A[1] = 2 amount of gas.
Now your tank has 2 units of gas. You need B[1] = 1 gas to get to station 0.
So, you travel to station 0 and still have 1 unit of gas left over.
You fill in A[0] = 1 unit of additional gas, making your current gas = 2.
It costs you B[0] = 2 to get to station 1, which you do and complete the circuit.
 */


import java.util.*;

public class GasStation {

    public static void main(String[] args)
    {

        Scanner sc0 = new Scanner(System.in);
        System.out.println("Enter the size");

        int n = sc0.nextInt();

        ArrayList<Integer> alist = new ArrayList<>();
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter the array A");

        for(int i = 0; i<n; i++)
        {
            alist.add(sc.nextInt());
        }


        ArrayList<Integer> blist = new ArrayList<>();
        System.out.println("Enter the array B");
        Scanner sc1 = new Scanner(System.in);

        for(int i = 0; i<n; i++)
        {
            blist.add(sc1.nextInt());
        }

        System.out.println(CanCompleteCircuit(alist, blist));
    }

    public static int CanCompleteCircuit(List<Integer> A, List<Integer> B)
    {
        int n = A.size();

        int totalgas = 0;
        int sum = 0;
        int count = 0;

        for(int i = 0; i<n; i++)
        {
            int diff = A.get(i) - B.get(i);
            totalgas = totalgas + diff;
            sum = sum + diff;


            if(totalgas < 0)
            {
                count = i + 1;
                totalgas = 0;
            }
        }

        if(sum < 0)
        {
            return -1;
        }

        return count;
    }


}
