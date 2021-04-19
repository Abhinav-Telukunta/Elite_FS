/*Given a nokia phone,with the following dialpad.
		1 2 3
		4 5 6
		7 8 9
		* 0 #
And You are given an L band to dial the number,  
Using the L band you can dial the number as follows, 
You can start with any digit,
	if you are at digit 1, next digit you can choose {6,8}
	if you are at digit 2, next digit you can choose {7,9}
	if you are at digit 3, next digit you can choose {4,8}
	and so on..

Now your task is to find how many distinct numbers of length N you can dial.

Note: Numbers should contain only digits, {* , #} -> not allowed.
Answer should be modulo 1000000007.

Input Format:
-----------------
An integer N, length of numbers
 
Output Format:
------------------
Print an integer, number of distinct numbers you can dial.


Sample Input-1:
---------------
1

Sample Output-1:
----------------
10

Explanation:
-------------
To dial a number of length 1, you can dial all digits.


Sample Input-2:
---------------
2

Sample Output-2:
----------------
20

Explanation:
------------
To dial a number of length 2, the possible numbers are
{04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94}

Sample Input-3:
---------------
5

Sample Output-3:
----------------
240
*/
import java.util.*;
class dial{
    static int mod=(int)1e9+7;
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ans=compute_number(n);
        System.out.println(ans);
    }
    public static int compute_number(int n){
        long one,two,three,four,five,six,seven,eight,nine,zero;
        one=two=three=four=five=six=seven=eight=nine=zero=1;
        for(int i=0;i<n-1;++i){
            long new_one=(six+eight)%mod;
            long new_two=(seven+nine)%mod;
            long new_three=(four+eight)%mod;
            long new_four=(nine+three+zero)%mod;
            long new_five=0;
            long new_six=(seven+one+zero)%mod;
            long new_seven=(two+six)%mod;
            long new_eight=(one+three)%mod;
            long new_nine=(four+two)%mod;
            long new_zero=(four+six)%mod;
            one=new_one;
            two=new_two;
            three=new_three;
            four=new_four;
            five=new_five;
            six=new_six;
            seven=new_seven;
            eight=new_eight;
            nine=new_nine;
            zero=new_zero;
        }
        return (int)((one+two+three+four+five+six+seven+eight+nine+zero)%mod);


    }
}
