package Problems;

import java.util.*;

public class Bulb {
    public static void main(String[] args)
    {

        int[] arr = {1, 1, 0, 0, 1, 0, 1}; // output is 3
        ArrayList<Integer> alist = new ArrayList<>();

        for(int i : arr)
        {
            alist.add(i);
        }

        System.out.println(Optimal(alist));


    }

    public static int BruteForce(ArrayList<Integer> alist)
    {
        int n = alist.size();
        int count = 0;
        int i = 0;

        while(i < n)
        {
            if(alist.get(i) == 0)
            {
                count++;
                int j = i;

                if(alist.get(i) == 0)
                {
                    alist.set(i, 1);
                }
                else
                {
                    alist.set(i, 0);
                }
            }
            i++;

        }

        return count;
    }

    public static int Optimal(ArrayList<Integer> A)
    {
        int count = 0;

        for(int i = 0; i<A.size(); i++)
        {
            if(A.get(i) == 0 && count % 2 == 0)
            {
                count++;
            }
            else if(A.get(i) == 1 && count % 2 != 0)
            {
                count++;
            }
        }

        return count;
    }
}
