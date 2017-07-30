package algorithms;

import utils.*;

import java.util.*;

/**
 * Created by zhangyanming on 2017/7/12.
 */
public class DFS {
  public static List<List<Integer>> iterativeDFS(TreeNode root) {
    if (root == null) {
      return null;
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    Set<TreeNode> visited = new HashSet<>();
    stack.push(root);
    visited.add(root);
    path.add(root.val);
    while (!stack.isEmpty()) {
      TreeNode tmp = stack.peek();
      if (tmp.left == null && tmp.right == null) { // leaf node
        res.add(new ArrayList<>(path));
        stack.pop();
        path.remove(path.size() - 1);
      } else if (tmp.left != null && !visited.contains(tmp.left)) { // non-leaf node, left son has not been visited
        stack.push(tmp.left);
        visited.add(tmp.left);
        path.add(tmp.left.val);
      } else if (tmp.right != null && !visited.contains(tmp.right)) { // non-leaf node, right son has not been visited
        stack.push(tmp.right);
        visited.add(tmp.right);
        path.add(tmp.right.val);
      } else { // non-leaf node, both sons have been visited, traverse up, can be removed
        stack.pop();
        path.remove(path.size() - 1);
      }
    }
    return res;
  }

  // TODO: postorder method

  public static void main(String[] args) {
    TreeNode root = TreeUtils.deserialize("[10,5,15,1,7,#,20]");
    iterativeDFS(root).forEach(i -> System.out.println(i.toString()));
  }
}
