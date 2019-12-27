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

    @Test
    public void testReplaceAll() {
        String text = "欢迎<name><sex>入住英卓未来公寓,我是您的小管家,您可以叫我<智能音箱>,当您需要对房间内的智能设备进行控制时，您可以对我说，<智能音箱>，打开电影模式，您就会进入电影模式，您也可以对我说，<智能音箱>，打开卫生间灯，或者对我说，<智能音箱>，打开投影幕布，想要了解更多好玩的功能，您可以查看房间内的语音提示牌。";
        System.out.println(text.replaceAll("<智能音箱>", "小度小度"));
    }

}
