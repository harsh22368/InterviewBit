package Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Seats {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");

        String s = sc.nextLine();

        // call the Logic method

        System.out.println(Logic(s));
    }

    public static int Logic(String s)
    {
        int n = s.length();
        int MOD = 10000003;

        ArrayList<Integer> alist = new ArrayList<>();

        for(int i = 0; i<n; i++)
        {
            char ch = s.charAt(i);

            if(ch == 'x')
            {
                alist.add(i);
            }
        }

        int m = alist.size();
        if (m <= 1) return 0;

        int mid = m/2;
        int median = alist.get(mid);

        long count = 0;

        int left = median - 1;
        for(int i = mid-1; i>=0; i--)
        {
            count = (count + Math.abs(alist.get(i) - left)) % MOD;
            left--;
        }

        int right = median + 1;
        for(int i = mid + 1; i<m; i++)
        {
            count = (count + Math.abs(alist.get(i) - right)) % MOD;
            right++;
        }

        return (int)count;

    }
}
