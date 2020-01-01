package com.ami.study.logic;

import org.junit.Test;

/**
 * @author appoleo
 */
public class StringLogic {

    /**
     * 替换字符串中指定字符串
     * 示例：replace("aabbccdd", "bb", "dd")，结果为aaddccdd
     * 注意：不能使用String类的replace，replaceAll方法或其他Java现成的替换API方法
     *
     * @param text    字符串
     * @param subtext 原来存在的字符串
     * @param replace 将要替换的新字符串
     * @return 替换后的新字符串
     */
    public static String replace(String text, String subtext, String replace) {
        if (text.length() < subtext.length()) {
            return text;
        }
        if (text.equals(subtext)) {
            return replace;
        }
        StringBuilder result = new StringBuilder();
        String[] split = text.split(subtext);
        for (int i = 0; i < split.length; i++) {
            result.append(split[i]);
            if (i < split.length - 1) {
                result.append(replace);
            }
        }
        // 校验末尾匹配情况
        char[] chSubtext = subtext.toCharArray();
        char[] chText = text.toCharArray();
        for (int i = chSubtext.length - 1, j = 1; i > 0; i--, j++) {
            if (chSubtext[i] != chText[chText.length - j]) {
                return result.toString();
            }
        }
        return result.append(replace).toString();
    }

    @Test
    public void testReplace() {
        System.out.println(replace("aabbccdd", "bb", "dd"));
    }

}
