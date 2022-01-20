package com.thinban.tree;

import cn.hutool.core.lang.Console;
import com.thinban.base.TreeNode;

import java.util.*;

/**
 * @author chenshengbin
 * @date 2022/1/20 17:16
 */
public class Iter {

    /**
     * 中左右  求深度 可作回溯
     *
     * @param root
     * @param result
     */
    void preOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    /**
     * 左中右
     *
     * @param root
     * @param result
     */
    void inOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }

    /**
     * 左右中  求高度
     *
     * @param root
     * @param result
     */
    void postOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }

    /* ========================迭代遍历=======================*/

    /**
     * 入栈：中右左
     *
     * @param root
     * @return
     */
    List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.empty()) {
            TreeNode pop = st.pop();//中
            result.add(pop.val);
            if (pop.right != null) {//右
                st.push(pop.right);
            }
            if (pop.left != null) {//左
                st.push(pop.left);
            }
        }
        return result;
    }

    /**
     * 反转（中右左）=左右中
     *
     * @param root
     * @return
     */
    List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.empty()) {
            TreeNode pop = st.pop();//中
            result.add(pop.val);
            if (pop.left != null) {//左
                st.push(pop.left);
            }
            if (pop.right != null) {//右
                st.push(pop.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * 左中右
     *
     * @param root
     * @return
     */
    List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> st = new Stack<>();
        TreeNode t = root;
        while (t != null || !st.empty()) {
            if (t != null) {//左
                st.push(t);
                t = t.left;
            } else {
                t = st.pop();//中
                result.add(t.val);
                t = t.right;//右
            }
        }
        return result;
    }

    /* ========================层序遍历=======================*/

    //TODO 还有一种迭代写法

    /**
     * BFS-队列实现层序遍历
     *
     * @param node
     * @return
     */
    List<List<Integer>> levelOrder(TreeNode node) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(node);
        List<List<Integer>> lists = new ArrayList<>();
        while (!que.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = que.size();
            while (len > 0) {
                TreeNode poll = que.poll();
                list.add(poll.val);
                if (poll.left != null) que.offer(poll.left);
                if (poll.right != null) que.offer(poll.right);
                len--;
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t3 = new TreeNode(3, null, null);
        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t8 = new TreeNode(8, null, null);

        TreeNode t4 = new TreeNode(4, t1, t3);
        TreeNode t7 = new TreeNode(7, t5, t8);

        TreeNode root = new TreeNode(6, t4, t7);
        final Iter iter = new Iter();
        Console.log("层序遍历:{}", iter.levelOrder(root));
        Console.log("前序遍历:{}", iter.preOrder(root));
        Console.log("中序遍历:{}", iter.inOrder(root));
        Console.log("后序遍历:{}", iter.postOrder(root));

        List<Integer> list = null;
        iter.preOrder(root, list = new ArrayList<>());
        Console.log("前序递归遍历:{}", list);

        iter.inOrder(root, list = new ArrayList<>());
        Console.log("中序递归遍历:{}", list);

        iter.postOrder(root, list = new ArrayList<>());
        Console.log("后序递归遍历:{}", list);
    }

}
