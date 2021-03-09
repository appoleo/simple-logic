package com.ami.study.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangchendong
 * @date 2021/03/09
 */
public class BinaryTree {


    private static Node initBinaryTree() {



        return new Node();
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
