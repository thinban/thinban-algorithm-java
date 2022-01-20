package com.thinban.tree;

import cn.hutool.core.lang.Console;
import com.thinban.base.TreeNode;

import java.util.List;


/**
 * 翻转树
 *
 * @author chenshengbin
 * @date 2022/1/20 18:30
 */
public class Revert {
    void revert(TreeNode root) {
        //前序和后序都可以
        if (root.left == null || root.right == null) return;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        revert(root.left);
        revert(root.right);

    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t3 = new TreeNode(3, null, null);
        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t8 = new TreeNode(8, null, null);

        TreeNode t4 = new TreeNode(4, t1, t3);
        TreeNode t7 = new TreeNode(7, t5, t8);

        TreeNode root = new TreeNode(6, t4, t7);
        new Revert().revert(root);

        Console.log(new Iter().levelOrder(root));
    }
}
