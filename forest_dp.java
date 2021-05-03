import java.util.*;
public class forest_dp{
    static int ans=Integer.MAX_VALUE;
    static Set<String>visited=new HashSet<>();
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] mat=new int[n][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j) mat[i][j]=sc.nextInt();
        }
        int[] start=new int[2];
        start[0]=sc.nextInt();
        start[1]=sc.nextInt();
        int[] end=new int[2];
        end[0]=sc.nextInt();
        end[1]=sc.nextInt();
        dfs(mat,start,end,n,0);
        if(ans==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
    public static void dfs(int[][] mat,int[] start,int[] end,int n,int steps){
        if(Arrays.equals(start,end)){
            ans=Math.min(ans,steps);
            return;
        }
        visited.add(start[0]+" "+start[1]);
        int row=start[0],col=start[1];
        int[] left=compute_left(mat,row,col,n);
        int[] right=compute_right(mat,row,col,n);
        int[] up=compute_up(mat,row,col,n);
        int[] down=compute_down(mat,row,col,n);
        if(!Arrays.equals(start,left) && !visited.contains(left[0]+" "+left[1])) {
            dfs(mat,left,end,n,steps+compute_steps(start,left));
        }
        if(!Arrays.equals(start,right) && !visited.contains(right[0]+" "+right[1])) {
            dfs(mat,right,end,n,steps+compute_steps(start,right));
        }
        if(!Arrays.equals(start,up) && !visited.contains(up[0]+" "+up[1])) {
            dfs(mat,up,end,n,steps+compute_steps(start,up));
        }
        if(!Arrays.equals(start,down) && !visited.contains(down[0]+" "+down[1])) {
            dfs(mat,down,end,n,steps+compute_steps(start,down));
        }
        visited.remove(start[0]+" "+start[1]);
        
    }
    public static int[] compute_left(int[][] mat,int row,int col,int n){
        for(int j=col-1;j>=0;--j){
            if(mat[row][j]==1) return new int[]{row,j+1};
        }
        return new int[]{row,0};
    }
    public static int[] compute_right(int[][] mat,int row,int col,int n){
        for(int j=col+1;j<n;++j){
            if(mat[row][j]==1) return new int[]{row,j-1};
        }
        return new int[]{row,n-1};
    }
    public static int[] compute_up(int[][] mat,int row,int col,int n){
        for(int i=row-1;i>=0;--i){
            if(mat[i][col]==1) return new int[]{i+1,col};
        }
        return new int[]{0,col};
    }
    public static int[] compute_down(int[][] mat,int row,int col,int n){
        for(int i=row+1;i<n;++i){
            if(mat[i][col]==1) return new int[]{i-1,col};
        }
        return new int[]{n-1,col};
    }
    public static int compute_steps(int[] a,int[] b){
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
    }
    
}