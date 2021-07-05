/*
Hemanth is working with numbers,
He is given a list of N numbers.

He need to choose a pair(P,Q) of numbers and them to binary numbers.
And count the number of bits to be converted in P to make P = Q.

Your task is to find the total sum of count of bits to be converted in 
all the pairs of the list of numbers.

Input Format:
-------------
Line-1: An integer, N number of values.
Line-2: N space separated integers, positive numbers.

Output Format:
--------------
Print an integer value.


Sample Input-1:
---------------
3
2 13 5

Sample Output-1:
----------------
8

Explanation:
------------
Given list of numbers: [2, 13, 5]
Binary numbers are as follows: 0010, 1101, 0101

The Total sum is:   countOfConversion(2, 13) + 
                    countOfConversion(13, 5) + 
                    countOfConversion(5, 2) = 4 + 1 + 3 = 8.


Sample Input-2:
---------------
4
6 14 17 11

Sample Output-2:
----------------
18

Explanation:
------------
Given list of numbers: [6, 14, 17, 11]
Binary numbers are as follows: 00110, 01110, 10001, 01011

The Total sum is:   countOfConversion(6, 14) + 
                    countOfConversion(6, 17) + 
                    countOfConversion(6, 11) + 
                    countOfConversion(14, 17) +
                    countOfConversion(14, 11) + 
                    countOfConversion(17, 11) = 1 + 4 + 3 + 5 + 2 + 3 = 18
                    
 */
import java.util.*;
class bits{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;++i) arr[i]=sc.nextInt();
        int ans=0;
        for(int i=0;i<32;++i){
            int zero=0,one=0;
            for(int j=0;j<n;++j){
                if(arr[j]%2==0) zero++;
                else one++;
                arr[j]=arr[j]/2;
            }
            ans=ans+(zero*one);
        }
        System.out.println(ans);
    }
}
