package com.questionaire.common.util;

public class TextUtil {
    public static final String EMPTY = "";

    private TextUtil() {
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isAvailable(CharSequence cs) {
        if (isEmpty(cs)) {
            return false;
        } else {
            String txt = cs.toString().replace("null", "").replace("NULL", "");
            return !isEmpty(txt.trim());
        }
    }

    public static String camel2Underline(String camelCaseName) {
        if (isEmpty(camelCaseName)) {
            return "";
        } else {
            StringBuilder result = new StringBuilder();
            result.append(camelCaseName.substring(0, 1).toLowerCase());

            for(int i = 1; i < camelCaseName.length(); ++i) {
                char ch = camelCaseName.charAt(i);
                if (Character.isUpperCase(ch)) {
                    result.append("_");
                    result.append(Character.toLowerCase(ch));
                } else {
                    result.append(ch);
                }
            }

            return result.toString();
        }
    }
}
