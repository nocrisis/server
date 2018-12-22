package com.questionaire.common.util;

import com.vdurmont.emoji.EmojiParser;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;


/**
 * @author Created by xianfuWang
 * @version 2018/7/13.
 */
public class EmojiUtils {

    private static final Logger logger = LoggerFactory.getLogger(EmojiUtils.class);

    public static String emojiHtmlEncode(String nickName) {
        return EmojiParser.parseToHtmlDecimal(nickName);
    }

    /**
     * 对传入字符串 encode
     *
     * @param nickName
     * @return
     */
    public static String getNameEncode(String nickName) {
        logger.info("Encoding weixin nickName. Nick name : " + nickName);
        String encoding = nickName;
        try {
            encoding = Base64.encodeBase64URLSafeString(nickName.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            logger.error("emoji表情出错：{}", e);
        }
        return encoding;
    }

    /**
     * 对encode字符串进行decode
     *
     * @param encode
     * @return
     */
    public static String getNameDecode(String encode) {

        logger.info("Start to decoding weixin nickName.");
        byte[] decodeByte = Base64.decodeBase64(encode);
        try {
            String decode = new String(decodeByte, "utf-8");
            if (decode.equals("")) {
                return encode;
            }
            return decode;
        } catch (UnsupportedEncodingException e) {
            logger.error("Using org.apache.commons.codec.binary.Base64 decode nick name failed. Encoding nickname = " + encode);
            return encode;
        }
    }

    /**
     * 先decode字符串，然后按照所给的endIndex从头截取到endIndex.
     *
     * @param encode
     * @param endIndex
     * @return
     */
    public static String getNameDecodeSubString(String encode, int endIndex) {
        String decode = getNameDecode(encode);
        if (decode.length() > endIndex) {
            decode = decode.substring(0, endIndex);
        }
        return decode;
    }

    /**
     * 先decode字符串，然后按照所给的startIndex和endIndex截取字符串.
     *
     * @param encode
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static String getNameDecodeSubString(String encode, int startIndex, int endIndex) {
        String decode = getNameDecode(encode);
        if (decode.length() > endIndex) {
            decode = decode.substring(startIndex, endIndex);
        }
        return decode;
    }

    /**
     * 检测是否有emoji字符
     *
     * @param source 需要判断的字符串
     * @return 一旦含有就抛出
     */
    public static boolean containsEmoji(String source) {
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (!notisEmojiCharacter(codePoint)) {
                //判断确认有表情字符
                return true;
            }
        }
        return false;
    }


    /**
     * 非emoji表情字符判断
     *
     * @param codePoint
     * @return
     */
    private static boolean notisEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) ||
                (codePoint == 0x9) ||
                (codePoint == 0xA) ||
                (codePoint == 0xD) ||
                ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
                ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }

    /**
     * 过滤emoji 或者 其他非文字类型的字符
     *
     * @param source 需要过滤的字符串
     * @return
     */
    public static String filterEmoji(String source) {
        if (!containsEmoji(source)) {
            logger.info("不包含");
            return source;//如果不包含，直接返回
        }

        StringBuilder buf = null;//该buf保存非emoji的字符
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (notisEmojiCharacter(codePoint)) {
                if (buf == null) {
                    buf = new StringBuilder(source.length());
                }
                buf.append(codePoint);
            }
        }

        if (buf == null) {
            return "";//如果没有找到非emoji的字符，则返回无内容的字符串
        } else {
            if (buf.length() == len) {
                buf = null;
                return source;
            } else {
                return buf.toString();
            }
        }
    }

}
