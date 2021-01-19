/*
KMIT hosting a Keshav Memorial Badminton League. 
They planned to conduct N number of games. Each game begin and ends in perticular time slot.

You are given an array of time slots of the N games, consisting of
begin and end times (b1,e1),(b2,e2),... (b < e ).
Your task is to determine minimum number of badminton courts required 
to conduct all the games smoothly.

NOTE: If a game begins at time 'a' ends at time 'b', 
another game can start at 'b'.

Input Format:
-------------
Line-1: An integer N, number of games.
Next N lines: Two space separated integers, begin and end time of each game.

Output Format:
--------------
Print an integer, minimum number of badminton courts required.


Sample Input-1:
---------------
3
0 30
5 10
15 20

Sample Output-1:
----------------
2

Sample Input-2:
---------------
3
0 10
15 25
25 35

Sample Output-2:
----------------
1

 */
import java.util.*;
public class start_and_end_intervals{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][2];
        for(int i=0;i<n;++i){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        int[] start=new int[n];
        int[] end=new int[n];
        for(int i=0;i<n;++i){
            start[i]=arr[i][0];
            end[i]=arr[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0,j=0,ans=0;
        while(i<n){
            if(start[i]>=end[j]) j++;
            else ans++;
            i++;
        }
        System.out.println(ans);
    }
}