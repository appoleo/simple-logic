package com.ami.study.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author wangchendong
 * @date 2021/03/03
 */
public class BaseLogic {

    public static void main(String[] args) {
        Node head = initNode();
        // print(head);
        System.out.println();
        System.out.println("is ring: " + isRing(head));
        Node enteringNode = nodeEnteringRing(head);
        System.out.println("node entering ring: " + (enteringNode == null ? null : enteringNode.getValue()));
    }

    /**
     * 判断链表是否有环
     *
     * @return 有 true  没有 false
     */
    private static boolean isRing(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    /**
     * 获取入环节点
     *
     * @return 如果有环，返回入环节点，否则返回null
     */
    private static Node nodeEnteringRing(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * 两个链表是否相交
     */
    private static boolean isIntersect(Node node1, Node node2) {
        if (node1 == null || node2 == null) return false;
        // 先判断是否有环
        boolean ring1 = isRing(node1);
        boolean ring2 = isRing(node2);
        if (ring1 != ring2) return false;
        // 根据是否有环分别做判断
        if (ring1) {
            // 如果有环，入环节点相同，则true，如果环相同，则true
            Node integerNode1 = nodeEnteringRing(node1);
            Node integerNode2 = nodeEnteringRing(node2);
            if (integerNode1 == integerNode2) return true;
            Node next = integerNode1;
            assert next != null;
            while (next.next != integerNode2) {
                next = next.next;
                if (next == integerNode1) {
                    return false;
                }
            }
            return true;
        } else {
            // 如果没有环，判断最后一个节点是否相等
            Node last1 = node1, last2 = node2;
            while (last1.next != null) last1 = last1.next;
            while (last2.next != null) last2 = last2.next;
            return last1 == last2;
        }
    }

    /**
     * 获取相交链表的交点
     *
     * @return 交点
     */
    public static Node intersect(Node node1, Node node2) {
        if (node1 == node2) return node1;
        if (node1 == null || node2 == null) return null;
        Node end = null;
        // 是否有环
        boolean ring = isRing(node1);
        if (ring) {
            Node nodeEnteringRing1 = nodeEnteringRing(node1);
            Node nodeEnteringRing2 = nodeEnteringRing(node2);
            // 环内相交
            if (nodeEnteringRing1 != nodeEnteringRing2) return nodeEnteringRing1;
            // 环外相交
            end = Objects.requireNonNull(nodeEnteringRing1).next;
        }
        Node poi1 = node1;
        Node poi2 = node2;
        while (poi1.next != end && poi2.next != end) {
            poi1 = poi1.next;
            poi2 = poi2.next;
            if (poi1 == poi2) return poi1;
        }
        if (poi1 == end) {
            poi1 = node2;
            while (poi2.next != end) {
                poi2 = poi2.next;
                poi1 = poi1.next;
            }
            poi2 = poi1;
            poi1 = node1;
        } else {
            poi2 = node1;
            while (poi1.next != end) {
                poi2 = poi2.next;
                poi1 = poi1.next;
            }
            poi1 = poi2;
            poi2 = node2;
        }
        while (poi1 != poi2) {
            poi1 = poi1.next;
            poi2 = poi2.next;
        }
        return poi1;
    }


    private static Node initNode() {
        Node node10 = new Node(6, null);
        Node node9 = new Node(7, node10);
        Node node8 = new Node(10, node9);
        Node node7 = new Node(5, node8);
        Node node6 = new Node(3, node7);
        Node node5 = new Node(2, node6);
        Node node4 = new Node(6, node5);
        Node node3 = new Node(9, node4);
        Node node2 = new Node(1, node3);
        node10.next = node7;
        return new Node(4, node2);
    }

    /**
     * 将给出的链表中的节点每\ k k 个一组翻转，返回翻转后的链表
     * 如果链表中的节点数不是\ k k 的倍数，将最后剩下的节点保持原样
     * 你不能更改节点中的值，只能更改节点本身。
     * 要求空间复杂度 \ O(1) O(1)
     * 例如：
     * 给定的链表是1\to2\to3\to4\to51→2→3→4→5
     * 对于 \ k = 2 k=2, 你应该返回 2\to 1\to 4\to 3\to 52→1→4→3→5
     * 对于 \ k = 3 k=3, 你应该返回 3\to2 \to1 \to 4\to 53→2→1→4→5
     *
     * @param head ListNode类
     * @param k    int整型
     * @return Node类
     */
    public static Node reverseKGroup(Node head, int k) {
        if (head == null || head.next == null || k <= 1) return head;
        int count = 0;
        Node newHead = head;
        Node end = head;
        Node prev = null;
        Node nodeK = null;
        while (head != null) {
            count++;
            if (count % k == 1) {
                if (!enough(head, k)) {
                    end.next = head;
                    break;
                }
                prev = null;
            }
            if (count == k) newHead = head;
            if (count % k == 0) {
                if (nodeK != null) {
                    end.next = head;
                    end = nodeK;
                }
                nodeK = head.next;
            }
            Node tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return newHead;
    }

    private static boolean enough(Node head, int k) {
        Node poi = head;
        while (poi != null) {
            k--;
            if (k <= 0) return true;
            poi = poi.next;
        }
        return false;
    }

    private static void print(Node head) {
        if (head == null) return;
        Node pos = head;
        while (pos != null) {
            System.out.print(pos.value + " ");
            pos = pos.next;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Node {

        private Integer value;

        private Node next;
    }
}
