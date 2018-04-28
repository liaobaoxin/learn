package com.lbx.adt;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @date 2018/4/26 14:43
 */
public class AdtTest {
    @Test
    public void fun1() {
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(1,
                new BinaryTreeNode(2, new BinaryTreeNode(4, null, null), new BinaryTreeNode(5, null, null)),
                new BinaryTreeNode(3, new BinaryTreeNode(6, null, null), new BinaryTreeNode(7, null, null)));
        levelOrderTraversalInReverse(binaryTreeNode2);

    }

    void preOrder(BinaryTreeNode root) {
        if (root != null) {
            System.out.println(root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    void preOrderNonRecursive(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                System.out.println(root.getData());
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            root = root.getRight();
        }
        return;
    }

    /**
     * 层次遍历
     *
     * @param root
     */
    void levelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp;
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = queue.removeFirst();
            //处理当前结点
            System.out.println(temp.getData());
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
    }

    /**
     * 利用递归查找二叉树最大的值
     *
     * @param root
     * @return
     */
    int FindMax(BinaryTreeNode root) {
        int rootVal, left, right, max = 0;
        if (root != null) {
            rootVal = root.getData();
            left = FindMax(root.getLeft());
            right = FindMax(root.getRight());
            //在这3个值中找出最大值
            if (left > right) {
                max = left;
            } else {
                max = right;
            }
            if (rootVal > max) {
                max = rootVal;
            }
        }
        return max;
    }

    /**
     * 利用非递归的方法实现查找二叉树的最大元素
     *
     * @param root
     * @return
     */
    int FindMaxUsingLevelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp;
        int max = 0;
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = queue.removeFirst();
            //所有值中最大的值
            if (max < temp.getData()) {
                max = temp.getData();
            }
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
        return max;
    }


    /**
     * 利用非递归算法来搜索二叉树的某个元素
     *
     * @param root
     * @param data
     * @return
     */
    Boolean searchUsingLevelOrder(BinaryTreeNode root, int data) {
        if (root == null) {
            return false;
        }
        BinaryTreeNode temp;
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = queue.removeFirst();
            if (temp.getData() == data) {
                return true;
            }
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
        return false;
    }

    /**
     * 实现将一个元素插入二叉树中的算法
     */
    void InsertBinaryTree(BinaryTreeNode root, int data) {
        LinkedList<BinaryTreeNode> queue = new LinkedList();
        BinaryTreeNode temp;
        BinaryTreeNode newNode = new BinaryTreeNode();
        newNode.setLeft(null);
        newNode.setRight(null);
        newNode.setData(data);
        if (root == null) {
            root = newNode;
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = queue.removeFirst();
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            } else {
                temp.setLeft(newNode);
                queue.removeFirst();
                return;
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            } else {
                temp.setRight(newNode);
                queue.removeFirst();
                return;
            }
        }
    }

    /**
     * 计算树中结点的个数
     */
    Integer sizeOfBTUsingLevelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp;
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        int count = 0;
        if (root == null) {
            return 0;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = queue.removeFirst();
            count++;
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
        return count;
    }

    /**
     * 利用递归获取二叉树结点个数的算法
     */
    Integer sizeOfBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        return sizeOfBinaryTree(root.getLeft()) + 1 + sizeOfBinaryTree(root.getRight());
    }

    /**
     * 利用递归实现删除树的算法
     */
    void deleteBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        deleteBinaryTree(root.getLeft());
        deleteBinaryTree(root.getRight());
        root = null;
    }

    void levelOrderTraversalInReverse(BinaryTreeNode root) {
        //创建两个队列，一个存放遍历的元素，一个存放上一次的元素
        LinkedList<BinaryTreeNode> queueTraversal = new LinkedList<>();
        LinkedList<BinaryTreeNode> queueExist = new LinkedList<>();
        queueTraversal.add(root);
        queueExist.add(root);
        while (!queueTraversal.isEmpty()) {
            BinaryTreeNode binaryTreeNode = queueTraversal.removeFirst();
            if (binaryTreeNode.getRight() != null) {
                queueTraversal.add(binaryTreeNode.getRight());
                queueExist.addFirst(binaryTreeNode.getRight());
            }
            if (binaryTreeNode.getLeft() != null) {
                queueTraversal.add(binaryTreeNode.getLeft());
                queueExist.addFirst(binaryTreeNode.getLeft());
            }

        }
       /* for (int i = queueExist.size()-1; i >= 0; i--) {
            System.out.println(queueExist.get(i).getData());
        }*/
        for (BinaryTreeNode binaryTreeNode:queueExist) {
            System.out.println(binaryTreeNode.getData());
        }
    }
}
