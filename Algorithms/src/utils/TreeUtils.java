package utils;

import java.util.ArrayList;

/**
 * Created by zhangyanming on 2017/7/9.
 */
public final class TreeUtils { // TODO: why final

  // TODO: implement by myself
  /**
   * This method will be invoked first, you should design your own algorithm
   * to serialize a binary tree which denote by a root node to a string which
   * can be easily deserialized by your own "deserialize" method later.
   */
  public static String serialize(TreeNode root) { // TODO: why static
    if (root == null) {
      return "[]";
    }

    ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
    queue.add(root);

    for (int i = 0; i < queue.size(); i++) {
      TreeNode node = queue.get(i);
      if (node == null) {
        continue;
      }
      queue.add(node.left);
      queue.add(node.right);
    }

    while (queue.get(queue.size() - 1) == null) {
      queue.remove(queue.size() - 1);
    }

    StringBuilder sb = new StringBuilder();
    sb.append("[");
    sb.append(queue.get(0).val);
    for (int i = 1; i < queue.size(); i++) {
      if (queue.get(i) == null) {
        sb.append(",#");
      } else {
        sb.append(",");
        sb.append(queue.get(i).val);
      }
    }
    sb.append("]");
    return sb.toString();
  }

  /**
   * This method will be invoked second, the argument data is what exactly
   * you serialized at method "serialize", that means the data is not given by
   * system, it's given by your own serialize method. So the format of data is
   * designed by yourself, and deserialize it here as you serialize it in
   * "serialize" method.
   */
  public static TreeNode deserialize(String data) {
    if (data.equals("[]")) {
      return null;
    }
    String[] vals = data.substring(1, data.length() - 1).split(",");
    ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
    TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
    queue.add(root);
    int index = 0;
    boolean isLeftChild = true;
    for (int i = 1; i < vals.length; i++) {
      if (!vals[i].equals("#")) {
        TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
        if (isLeftChild) {
          queue.get(index).left = node;
        } else {
          queue.get(index).right = node;
        }
        queue.add(node);
      }
      if (!isLeftChild) {
        index++;
      }
      isLeftChild = !isLeftChild;
    }
    return root;
  }

}
