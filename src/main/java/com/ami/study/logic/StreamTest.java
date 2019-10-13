package com.ami.study.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author appoleo
 */
public class StreamTest {

    /*public static void main(String[] args) {
        String sentence = "I am a boy";
        String[] sentenceArr = sentence.split(" ");
        IntStream.rangeClosed(1, sentenceArr.length)
                .mapToObj(i -> sentenceArr[sentenceArr.length - i])
                .forEach(item -> {
            System.out.print(item);
            System.out.print(" ");
        });
    }*/

    /*public static void main(String[] args) {
        String sentence = "I am a boy";
        String[] sentenceArr = sentence.split(" ");
        List<String> sentenceList = Arrays.asList(sentenceArr);
        Collections.reverse(sentenceList);
        for (String word : sentenceList) {
            System.out.print(word);
            System.out.print(" ");
        }
    }*/

    /*public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("asd");
        list.add("asd");
        list.add("bbb");
        list.add("ccc");
        List<String> newList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(newList);
    }*/

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("asd");
        list.add("asd");
        list.add("bbb");
        list.add("ccc");
        list.add("ccc");
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(j);
                }
            }
        }
        System.out.println(list);
    }


}
