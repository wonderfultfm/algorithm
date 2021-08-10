package com.tfm.algorithm.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.binarytree
 * @ClassName: BinaryTree
 * @Author: tangfengmin
 * @Description: 二叉树
 * @Date: 2021-7-1 18:05
 * @Version: 1.0
 */
public class BinaryTree {

    public static TreeNode creatBinaryTree(TreeNode treeNode, Integer x) {
        if (treeNode.getValue() == 0) {
            treeNode.setValue(x);
        } else if (treeNode.getValue() > x) {
            if (treeNode.getLeft() != null) {
                creatBinaryTree(treeNode.getLeft(), x);
            } else {
                treeNode.setLeft(new TreeNode(x, null, null));
            }
        } else if (treeNode.getValue() < x) {
            if (treeNode.getRight() != null) {
                creatBinaryTree(treeNode.getRight(), x);
            } else {
                treeNode.setRight(new TreeNode(x, null, null));
            }
        }
        return treeNode;
    }

    /**
     * 前序遍历
     *
     * @param treeNode
     */
    public static void preOrder(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.getValue() + "\t");
            preOrder(treeNode.getLeft());
            preOrder(treeNode.getRight());
        }
    }

    /**
     * 非递归法前序遍历
     *
     * @param treeNode
     */
    public static void preOrderNoRecursive(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (true) {
            while (treeNode != null) {
                System.out.println(treeNode.getValue() + "\t");
                stack.push(treeNode);
                treeNode = treeNode.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            treeNode = stack.pop();
            treeNode = treeNode.getRight();
        }
    }

    /**
     * 中序遍历
     *
     * @param treeNode
     */
    public static void inOrderNoRecursive(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (true) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            treeNode = stack.pop();
            System.out.println(treeNode.getValue() + "\t");
            treeNode = treeNode.getRight();
        }
    }

    /**
     * 后序遍历
     *
     * @param treeNode
     */
    public static void postOrderNoRecursive(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = treeNode;
        TreeNode lastVisit = treeNode;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.peek();
            if (node.getRight() == null || node.getRight().getValue() == lastVisit.getValue()) {
                System.out.println(node.getValue() + "\t");
                stack.pop();
                lastVisit = node;
                node = null;
            } else {
                node = node.getRight();
            }
        }
    }

    /**
     * 层序遍历
     *
     * @param treeNode
     */
    public static void floorOrder(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = treeNode;
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                System.out.println(node.getValue() + "\t");
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param treeNode
     */
    public static void inOrder(TreeNode treeNode) {
        if (treeNode != null) {
            inOrder(treeNode.getLeft());
            System.out.println(treeNode.getValue() + "\t");
            inOrder(treeNode.getRight());
        }
    }

    /**
     * 后序遍历
     *
     * @param treeNode
     */
    public static void postOrder(TreeNode treeNode) {
        if (treeNode != null) {
            postOrder(treeNode.getLeft());
            postOrder(treeNode.getRight());
            System.out.println(treeNode.getValue() + "\t");
        }
    }

    public static void main(String[] args) {
        Integer params[] = {5, 2, 7, 9, 1, 4, 3, 8, 6};
        TreeNode treeNode = new TreeNode();
        for (int i = 0; i < params.length; i++) {
            creatBinaryTree(treeNode, params[i]);
        }
        // System.out.println(treeNode.toString());
        // 前序遍历二叉树
        preOrder(treeNode);
    }
}
