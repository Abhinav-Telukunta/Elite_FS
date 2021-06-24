/*Basaveswar Rao working with binary trees.
He is given a root of the binary tree.
He wanted to find a subtree of the binary tree, which has maximum number 
of elements as nodes in it and the subtree should be a binary search tree.

Your task is to help Basaveswar to find such subtree by implement the following:

    class Solution:
	    - public int maximumBST(BinaryTreeNode root):
	    return an integer value, number of elements in the Binary Search subtree.
	
NOTE: 
Please do consider the node with data as '-1' as null in the given trees.
and the subtree must include all of its descendants.

Input Format:
-------------
Space separated integers, elements of the tree.

Output Format:
--------------
Print an integer value.


Sample Input-1:
---------------
3 1 4 -1 2 -1 6 -1 -1 -1 -1 -1 -1 5

Sample Output-1:
----------------
6


Sample Input-2:
---------------
3 3 4 -1 2 -1 6 -1 -1 -1 -1 -1 -1 5

Sample Output-2:
----------------
3

NOTE: Look at hint for explanation.
*/
import java.util.*;

/*
// Binary Tree Node structure for referecne.
class BinaryTreeNode{
	public int data; 
	public BinaryTreeNode left, right; 
	public BinaryTreeNode(int data){
		this.data = data; 
		left = null; 
		right = null; 
	}
}
*/

class Solution { 
    int ans=0,temp=0;
    public int maximumBST(BinaryTreeNode root) {
        // Implement your code here.
        get_maximum(root);
        return ans;
    }
    public void get_maximum(BinaryTreeNode root){
        if(root!=null && root.data!=-1){
            if(isBST(root)){
                count_nodes(root);
                ans=Math.max(ans,temp);
                temp=0;
            }
            get_maximum(root.left);
            get_maximum(root.right);
        }
    }
    public boolean isBST(BinaryTreeNode root){
        if(root==null || root.data==-1) return true;
        if(root.left!=null && calcMax(root.left)>=root.data) return false;
        if(root.right!=null && calcMin(root.right)<=root.data) return false;
        if(!isBST(root.left) || !isBST(root.right)) return false;
        return true;
    }
    public int calcMax(BinaryTreeNode root){
        if(root!=null && root.data!=-1){
            return Math.max(root.data,Math.max(calcMax(root.left),calcMax(root.right)));
        }
        return Integer.MIN_VALUE;
        
    }
    public int calcMin(BinaryTreeNode root){
        if(root!=null && root.data!=-1){
            return Math.min(root.data,Math.min(calcMin(root.left),calcMin(root.right)));
        }
        return Integer.MAX_VALUE;
        
    }
    public void count_nodes(BinaryTreeNode root){
        if(root!=null && root.data!=-1){
            temp++;
            count_nodes(root.left);
            count_nodes(root.right);
        }
    }
    
}
