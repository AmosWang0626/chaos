package cn.amos.chaos.test.main;

import com.vdurmont.emoji.EmojiParser;

/**
 * DESCRIPTION: emoji
 *
 * @author amos.wang
 * @date 2019/9/10
 */
public class EmojiMain {

    public static void main(String[] args) {
        String str = "An :grinning:awesome :smiley:string &#128516;with a few :wink:emojis!";
        String result = EmojiParser.parseToUnicode(str);
        System.out.println(result);
        result = EmojiParser.parseToAliases(str);
        System.out.println(result);
    }

}
