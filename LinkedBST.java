/// Julia Wang
/// LinkedBST.java
import java.util.List;
import java.util.ArrayList;

/// This file should look VERY similar to your AnimalList.java file. Open AnimalList in another tab and look at it before you get started

public class LinkedBST
{
    private TreeNode root; 

    public LinkedBST()
    {
        root = null;
    }

    public boolean addNode(Comparable addMe)
    {
        TreeNode a = new TreeNode(addMe);

        if (root == null) //if there is nothing in the treenode then root becomes the addMe value
        {
            root = a; 
            //root.setvalue(addMe);
            //root = new TreeNode(addMe);
            return true;
        }
        else
        {
            TreeNode current = root; 

            while (true) 
            {
                if (addMe.compareTo(current.getValue()) == 0) //if addMe is equal to the current value then it can't be added (no duplicates)
                    return false;
            
                else if (addMe.compareTo(current.getValue()) < 0) //add to the left
                {
                    if (current.getLeft() == null) //if the left space is empty, then it adds addMe to the left
                    {
                        current.setLeft(a);  
                        return true;
                    }
                    else
                        current = current.getLeft(); //otherwise, it moves current down to the left node to compare addMe to that
                }
                else if (addMe.compareTo(current.getValue()) > 0) //add to the right
                {
                    if (current.getRight() == null) //if the right space is empty, then it adds addMe to the right
                    {
                        current.setRight(a);
                        return true;
                    }
                    else
                        current = current.getRight(); //otherwise, it moves current down to the right node to compare addMe to that
                }
            }
        }
    }

    //preOrder
    public List preOrder()
    {
        List<Comparable> newlist= new ArrayList<>();
        preOrderTraverse(root, newlist);
        return newlist;
    }
    
    private void preOrderTraverse(TreeNode current, List list)
    {
        if (current == null) //nothing in list or no node being pointed to
            return;
        list.add(current.getValue()); //prints everything to the left and then everything to the right of the parent
        preOrderTraverse(current.getLeft(), list);
        preOrderTraverse(current.getRight(), list);
    }

    //inOrder
    public List inOrder()
    {
        List<Comparable> newlist= new ArrayList<>();
        inOrderTraverse(root, newlist);
        return newlist; 
    }
    
    private void inOrderTraverse(TreeNode current, List list)
    {
        if (current == null) //nothing in list or no node being pointed to
            return; 
        
        inOrderTraverse(current.getLeft(), list); //goes all the way down to the left, prints everything in left branch, then prints everything on the right
		list.add(current.getValue());
		inOrderTraverse(current.getRight(), list);
    }

    //postOrder
    public List postOrder()
    {
        List<Comparable> newlist= new ArrayList<>();
        postOrderTraverse(root, newlist);
        return newlist;
    }
    
    private void postOrderTraverse(TreeNode current, List list)
    {
        if (current == null) //nothing in list or no node being pointed to
            return;
        postOrderTraverse(current.getLeft(), list); //goes all the way down the left, prints the two children of each parent first, then the parent
        postOrderTraverse(current.getRight(), list);
        list.add(current.getValue());
    }

    //deleteNode
    public boolean deleteNode(Comparable find)
    {
        if (root == null) //if there is nothing in the treenode then there is nothing to delete
            return false;
    
        TreeNode parent = null;
        TreeNode target = root;
        
        while (target != null && !target.getValue().equals(find)) //searches for the target value in the tree
        {
            parent = target; 
            if (find.compareTo(target.getValue()) < 0)
                target = target.getLeft();
            else
                target = target.getRight();
        }

        if (target == null) //node not found
            return false; 
        
        else if (target.getLeft() == null && target.getRight() == null) //delete node with no children
        {
            if (target == root) //delete root
                root = null; 
            else if (parent.getLeft() == target) //if target is to the left of its parent
                parent.setLeft(null);
            else
                parent.setRight(null); //if target is to the right of its parent
            return true;
        }

        else if (target.getLeft() == null || target.getRight() == null) //delete node with one child
        {
            if (target == root) //delete root if root has one child
            {
                if (root.getLeft() != null) //child is to the left
                    root = root.getLeft();
                else if (root.getRight() != null) //child is to the right
                    root = root.getRight();
            }
            else if (parent.getLeft() == target) //if target is to the left of its parent
            {
                if (target.getLeft() != null) //child of target is to the left
                    parent.setLeft(target.getLeft());
                else //child of target is to the right
                    parent.setLeft(target.getRight());
            }
            else //if target is to the right of its parent
            {
                if (target.getLeft() != null) //child of target is to the left
                    parent.setRight(target.getLeft());
                else //child of target is to the right
                    parent.setRight(target.getRight());
            }
            return true;
        }

        else if (target.getLeft() != null && target.getRight() != null) //delete node with two children
        {
            TreeNode big = target.getLeft(); //go to left subtree of target
            TreeNode prebig = target; 

            while (big.getRight() != null) //go once left of target, and then go as far right as possible to find largest value if left subtree of target
            {
                prebig = big;
                big = big.getRight(); 
            }

            target.setValue(big.getValue()); //delete target value by setting it to the biggest value it its left subtree

            if (prebig.getLeft() == big) //this means that the first node in the left subtree is the greatest (big is directly to the left of prebig and prebig = target) and there are no right branches (aka greater nodes) so you automatically getLeft
                prebig.setLeft(big.getLeft());
            else 
                prebig.setRight(big.getLeft()); //this means that there was a greater node in the right branches of the left subtree. You point everything before the 'big' value to everything after/to the left of the 'big' value
        }

        return true;
    }

    //search
    public boolean search(Comparable key)
    {
        return search(root, key);
    }

    private boolean search(TreeNode current, Comparable key)
    {
        if (current == null) //nothing in list or not found
            return false;
        if (key.compareTo(current.getValue()) == 0) //found
            return true;
        else if (key.compareTo(current.getValue()) < 0) //key is less than current node --> go left
            return search(current.getLeft(), key);
        else //go right
            return search(current.getRight(), key);
    }

    //countLeaf
    public int countLeaf()
    {
        return countLeaf(root);
    }
    
    private int countLeaf(TreeNode current)
    {
        if (current == null) //nothing in tree or one child
            return 0; 
        else if (current.getRight() == null && current.getLeft() == null) //leaf node (bc no children)
            return 1; 
        else 
            return countLeaf(current.getLeft()) + countLeaf(current.getRight()); //checks to the right and left of the parent
    }

    //pathLength
    public int pathLength(Comparable find)
    {
        return pathLength(root, find);
    }
    
    private int pathLength(TreeNode current, Comparable find)
    {
        int branch; 
        if (current == null) //if node is not found
            return -1;
        else if (find.compareTo(current.getValue()) == 0) //found
            return 0; 
        else if (find.compareTo(current.getValue()) < 0) //key is less than current node --> go left
            branch = pathLength(current.getLeft(), find); //cannot do return 1 + pathLength because if the node is not found it will just subtract -1 from 1 (or the previous sum of branches) which is wrong
        else //go right
            branch = pathLength(current.getRight(), find);
        
        if (branch == -1) //if node is not found, ALL previous recursive calls will return -1 (not cumulative)
            return -1; 
        else 
            return 1 + branch; //if node is found, ALL previous recursive calls will return 1 (cumulative/sums up)
    }

    //countNode
    public int countNode()
    {
        return countNode(root);
    }

    private int countNode(TreeNode current)
    {
        if (current == null) //child does not exist
            return 0; 
        else
            return 1 + countNode(current.getLeft()) + countNode(current.getRight()); //moves to the left and right and adds 1 for each as long as it is not null (child exists)
    }

}
