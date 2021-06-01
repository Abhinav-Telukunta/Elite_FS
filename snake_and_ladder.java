/*Shakuni playing 'Paramapadasopanam' game with Dharamaraja.
Shakuni wants to win everytime. He has a boon that whenever he used to roll the dice,
the dice roll to show his desired number. 

Rules
--------
The game is played with a cubic dice of 6 faces numbered 1 to 6.
And Paramapadasopanam of size N*N.
- 	Starting from square X = 1, reach the square N*N with some rolls of the dice. 
-   Once Shakuni roll the dice, he will land on one of the followin squares only
	X+1, X+2, X+3, X+4, X+5, X+6.
- 	If current value at position X is not equal to -1, then there is a ladder or snake.
- 	If the position of X is at the base of a ladder, the player must climb the ladder. Ladders go up only.
- 	If the position of X is at the mouth of a snake, the player must go down the snake and come out through the tail. 
	Snakes go down only.

You have to findout, what would be the least number of rolls required for shakuni to win.

Note:
Shakuni can only take a snake or ladder at most once per move: 
if the tail of a snake or ladder is the start of another snake or ladder, 
you do not continue moving.


Input Format:
-------------
Line-1: An integer n , size of Paramapadasopanam.
Next N lines: N space separated integers, either -1 or an integer between 1 to n*n. 

Output Format:
--------------
Print an integer, least number of rolls required for shakuni to win.


Sample Input-1:
---------------
6
-1 -1 -1 -1 -1 -1
-1 -1 -1 -1 -1 -1
-1 -1 -1 -1 -1 -1
-1 35 -1 -1 13 -1
-1 -1 -1 -1 -1 -1
-1 15 -1 -1 -1 -1

Sample Output-1:
----------------
4

Explanation: 
------------
At the beginning, you start at square 1.
Roll the dice to land at square 2, and must take the ladder to square 15.
Roll the dice to land at square 17, and must take the snake to square 13.
Roll the dice to land at square 14, and must take the ladder to square 35.
Roll the dice to land at square 36, Shakuni Won.
Total number of rolls are 4.

*/
import java.util.*;
class snake{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] mat=new int[n][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j) mat[i][j]=sc.nextInt();
        }
        int[] board=new int[n*n+1];
        int idx=1,f=0;
        for(int i=n-1;i>=0;--i){
            if(f==0){
                for(int j=0;j<n;++j) board[idx++]=mat[i][j];
                f=1;
            }
            else{
                for(int j=n-1;j>=0;--j) board[idx++]=mat[i][j];
                f=0;
            }
        }
        //System.out.println(Arrays.toString(board));
        Queue<int[]>queue=new LinkedList<>();
        Set<Integer>visited=new HashSet<>();
        visited.add(1);
        queue.add(new int[]{1,0});
        int ans=-1;
        parent:while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;++i){
                int[] arr=queue.poll();
                int square=arr[0],curr_count=arr[1];
                if(square==n*n) {
                    ans=curr_count;
                    break parent;
                }
                for(int next=square+1;next<=Math.min(n*n,square+6);++next){
                    int dest=board[next]==-1?next:board[next];
                    if(!visited.contains(dest)){
                        visited.add(dest);
                        queue.add(new int[]{dest,curr_count+1});
                    }
                }
            }
        }
        System.out.println(ans);
    }
}