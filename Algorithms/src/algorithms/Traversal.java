package algorithms;

/**
 * Created by zhangyanming on 2017/7/9.
 */

import utils.*;

import java.util.*;

public class Traversal {

  // recursion O(n) space, O(n) time
  // inorder
  public static List<Integer> recursionInorder(TreeNode root) {
    if (root == null) {
      return null;
    }
    List<Integer> vals = new ArrayList<>();
    recursionInorderHelper(root, vals);
    return vals;
  }

  private static void recursionInorderHelper(TreeNode root, List<Integer> vals) {
    if (root == null) {
      return;
    }
    recursionInorderHelper(root.left, vals);
    vals.add(root.val);
    recursionInorderHelper(root.right, vals);
  }
  // TODO: preorder, postorder

  // iterative - stack based O(n) space, O(n) time
  // inorder
  public static List<Integer> stackInorder(TreeNode root) {
    if (root == null) {
      return null;
    }
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> vals = new ArrayList<>();
    TreeNode curt = root;
    while (curt != null || !stack.isEmpty()) {
      while (curt != null) {
        stack.push(curt);
        curt = curt.left;
      }
      curt = stack.pop();
      vals.add(curt.val);
      curt = curt.right;
    }
    return vals;
  }

  // preorder
  public static List<Integer> stackPreorder(TreeNode root) {
    if (root == null) {
      return null;
    }
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> vals = new ArrayList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode tmp = stack.pop();
      vals.add(tmp.val);
      if (tmp.right != null) {
        stack.push(tmp.right);
      }
      if (tmp.left != null) {
        stack.push(tmp.left);
      }
    }
    return vals;
  }

  // postorder
  // method 1
  public static List<Integer> stackPostorder(TreeNode root) {
    if (root == null) {
      return null;
    }
    List<Integer> vals = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curt = root;
    TreeNode pre = null;
    while (!stack.isEmpty() || curt != null) {
      while (curt != null) {
        stack.push(curt);
        curt = curt.left;
      }
      curt = stack.peek();
      if (curt.right != null && pre != curt.right) { // when to visit curt.right? when curt.right != null && the node that previously visited is not curt.right(not traverse up)
        curt = curt.right;
      } else { // otherwise pop an element
        vals.add(curt.val);
        pre = curt;
        stack.pop();
        curt = null;
      }
    }
    return vals;
  }

  // TODO: method 2

  // TODO: preorder

  // Moris traversal O(1) space, O(n) time
  // Tree Traversal without recursion and without stack! O(1) space
  // http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
  // http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/

  // 一、中序遍历

  // 步骤：

  // 1. 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。

  // 2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。

  //    a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。

  //    b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。

  // 3. 重复以上1、2直到当前节点为空。

  public static List<Integer> morisInorder(TreeNode root) {
    TreeNode curt = root;
    TreeNode pre = null;
    List<Integer> vals = new ArrayList<>();
    while (curt != null) {
      if (curt.left == null) {
        vals.add(curt.val);
        curt = curt.right;
      } else {
        pre = curt.left;
        while (pre.right != null && pre.right != curt) {
          pre = pre.right;
        }
        if (pre.right == null) {
          pre.right = curt;
          curt = curt.left;
        } else { // pre.right == curt
          pre.right = null;
          vals.add(curt.val);
          curt = curt.right;
        }
      }
    }
    return vals;
  }

  // TODO: preorder, postorder

  public void recoverTree(TreeNode root) {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    TreeNode pre = null;
    TreeNode curt = root;
    while (curt != null) {
      if (curt.left == null) {
        if (prev != null && curt.val <= prev.val) {
          if (first == null) {
            first = prev;
            second = curt;
          } else {
            second = curt;
          }
        }
        prev = curt;
        curt = curt.right;

      } else {
        pre = curt.left;
        while (pre.right != null && pre.right != curt) {
          pre = pre.right;
        }
        if (pre.right == null) {
          pre.right = curt;
          curt = curt.left;
        } else {
          pre.right = null;
          if (prev != null && curt.val <= prev.val) {
            if (first == null) {
              first = prev;
              second = curt;
            } else {
              second = curt;
            }
          }
          prev = curt;
          curt = curt.right;
        }
      }
    }
    if (first != null && second != null) {
      int temp = first.val;
      first.val = second.val;
      second.val = temp;
    }
  }

  public static void main(String[] args) {
//    TreeNode root = TreeUtils.deserialize("[10,5,15,1,7,#,20]");
//    List<Integer> l = null;
//    l = recursionInorder(root);
//    System.out.println(l.toString());
//    l = stackInorder(root);
//    System.out.println(l.toString());
//    l = morisInorder(root);
//    ListUtils.print(l);
//    l = stackPostorder(root);
//    ListUtils.print(l);
//    l = stackPreorder(root);
//    ListUtils.print(l);
    List<String> l2 = Arrays.asList("AC","BF","AA");
    Collections.sort(l2);
    System.out.print(l2.toString());
    List<String> l = new ArrayList<>();
    l = new ArrayList<>(l2);
    System.out.print(l.toString());
  }


}
