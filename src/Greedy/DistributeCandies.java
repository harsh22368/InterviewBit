package Greedy;


/*
        Problem Description



        N children are standing in a line. Each child is assigned a rating value.
        You are giving candies to these children subjected to the following requirements:
        Each child must have at least one candy.
        Children with a higher rating get more candies than their neighbors.
        What is the minimum number of candies you must give?



        Problem Constraints
        1 <= N <= 105
        -109 <= A[i] <= 109




        Input Format
        The first and only argument is an integer array A representing the rating of children.

        Output Format
        Return an integer representing the minimum candies to be given.

        Example

        Input 1: A = [1, 2]
        Input 2: A = [1, 5, 2, 1]

        Output 1: 3
        Output 2: 7


        Example
        Explanation 1:

         The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor.
         So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.
*/






import java.util.*;

public class DistributeCandies {

    public static void main(String[] args)
    {
        ArrayList<Integer> alist = new ArrayList<>();
        alist.add(1);
        alist.add(2);
        alist.add(3);
        alist.add(4);

        System.out.println(Logic(alist));
    }

    public static int Logic(ArrayList<Integer> A)
    {

        int n = A.size();

        int[] arr = new int[n];

        for(int i = 1; i<n ; i++)
        {
            if(A.get(i) > A.get(i-1))
            {
                arr[i] = arr[i-1] + 1;
            }
        }

        for(int i = n -2; i>=0; i--)
        {
            if(A.get(i) > A.get(i+1))
            {
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            }
        }

        int sum = n;
        for(int i : arr)
        {
            sum = sum + i;
        }

        return sum;
    }
}
