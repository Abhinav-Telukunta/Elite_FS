/*The king 'Luther Martin' has a kingdom in the form of square land of size N*N,
So, there are N*N square cells in the land.
You can divide the cell into two halfs either diagonal or anti-diagonal.
	- The diagonal division of the cell indicates by L
	- The anti-diagonal division of the cell indicates by R.
	- '_' indicates no division of the cell.
	
The king is given the following information:
An intgeer N, and N strings, consist of three characters L, R, and '_' ,
where each string length is N. The division may create new zones.

Your task is to divide each cell according to the given information, and
return the number of new zones formed after all the divisions made.

NOTE: Refer hint for pictorial representation of R and L divisions.

Input Format:
-------------
Line-1: An integer N, size of the land.
Line-2: N comma separated strings, each string of length N.
		The string consist only these characers [R,L,_] 

Output Format:
--------------
Print an integers, number of new zones formed.


Sample Input-1:
---------------
4
RLRL,LRLR,RLRL,LRLR

Sample Output-1:
----------------
13

Sample Input-2:
---------------
4
RRLL,R__L,L__R,LLRR

Sample Output-2:
----------------
9


Sample Input-3:
---------------
4
L_RR,_L_R,R_L_,RR_L

Sample Output-3:
----------------
2
*/
import java.util.*;
class slash{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] s=sc.next().split(",");
        DSU dsu=new DSU(n*4*n);
        for(int r=0;r<n;++r){
            for(int c=0;c<n;++c){
                int root=4*(r*n+c);
                char val=s[r].charAt(c);
                if(val=='R'){
                    dsu.union(root+0,root+1);
                    dsu.union(root+2,root+3);
                }
                if(val=='L'){
                    dsu.union(root+0,root+3);
                    dsu.union(root+1,root+2);
                }
                if(val=='_'){
                    dsu.union(root+0,root+3);
                    dsu.union(root+1,root+2);
                    dsu.union(root+0,root+1);
                    
                }
                if(r+1<n) dsu.union(root+3,(root+4*n)+1);
                if(c+1<n) dsu.union(root+2,(root+4)+0);
            }
        }
        int ans=0;
        for(int x=0;x<4*n*n;++x){
            if(dsu.find(x)==x) ans++;
        }
        System.out.println(ans);
        
    }
}
class DSU{
    int[] parent;
    public DSU(int n){
        parent=new int[n];
        for(int i=0;i<n;++i) parent[i]=i;
    }
    public int find(int x){
        if(parent[x]!=x) parent[x]=find(parent[x]);
        return parent[x];
    }
    public void union(int x,int y){
        parent[find(x)]=find(y);
    }
}