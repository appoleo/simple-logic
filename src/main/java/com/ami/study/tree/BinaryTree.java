package com.ami.study.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Stack;

/**
 * 二叉树
 *
 * @author wangchendong
 * @date 2021/03/09
 */
public class BinaryTree {

    public static void main(String[] args) {
        Node head = initBinaryTree();
        System.out.print("前序-递：");
        prefixPrint(head);
        System.out.println();
        System.out.print("中序-递：");
        midPrint(head);
        System.out.println();
        System.out.print("后序-递：");
        suffixPrint(head);
        System.out.println();
        System.out.print("前序-栈：");
        prefixPrintWithStack(head);
        System.out.println();
        System.out.print("中序-栈：");
        midPrintWithStack(head);
        System.out.println();
        System.out.print("后序-栈：");
        suffixPrintWithStack(head);
    }

    /**
     * 前序打印 - 递归
     *
     * @param head 头节点
     */
    private static void prefixPrint(Node head) {
        if (head == null) return;
        System.out.print(head.value + " ");
        prefixPrint(head.left);
        prefixPrint(head.right);
    }

    /**
     * 中序打印 - 递归
     *
     * @param head 头节点
     */
    private static void midPrint(Node head) {
        if (head == null) return;
        midPrint(head.left);
        System.out.print(head.value + " ");
        midPrint(head.right);
    }

    /**
     * 后序打印 - 递归
     *
     * @param head 头节点
     */
    private static void suffixPrint(Node head) {
        if (head == null) return;
        suffixPrint(head.left);
        suffixPrint(head.right);
        System.out.print(head.value + " ");
    }

    /**
     * 前序打印 - 栈
     *
     * @param head 头节点
     */
    private static void prefixPrintWithStack(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                Node pop = stack.pop();
                System.out.print(pop.value + " ");
                if (pop.right != null) stack.push(pop.right);
                if (pop.left != null) stack.push(pop.left);
            }
        }
    }

    /**
     * 中序打印 - 栈
     *
     * @param head 头节点
     */
    private static void midPrintWithStack(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            Node h = head;
            while (!stack.isEmpty() || h != null) {
                if (h != null) {
                    stack.push(h);
                    h = h.left;
                } else {
                    Node pop = stack.pop();
                    System.out.print(pop.value + " ");
                    h = pop.right;
                }
            }
        }
    }

    /**
     * 后序打印 - 栈
     *
     * @param head 头节点
     */
    private static void suffixPrintWithStack(Node head) {
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                Node pop = stack1.pop();
                stack2.push(pop);
                if (pop.left != null) stack1.push(pop.left);
                if (pop.right != null) stack1.push(pop.right);
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + " ");
            }
        }
    }

    private static Node initBinaryTree() {
        Node node4 = new Node(4, null, null);
        Node node5 = new Node(5, null, null);
        Node node6 = new Node(6, null, null);
        Node node7 = new Node(7, null, null);
        Node node2 = new Node(2, node4, node5);
        Node node3 = new Node(3, node6, node7);
        return new Node(1, node2, node3);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Node {

        private Integer value;

        private Node left;

        private Node right;
    }
}
