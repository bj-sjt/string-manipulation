package com.itao.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static final char UNDERLINE = '_';

    /**
     * 驼峰格式字符串转换为下划线格式字符串
     */
    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 下划线格式字符串转换为驼峰格式字符串
     */
    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 判断一个字符串是否是 null 或 "" 或 "  "
     */
    public static boolean isNotBlank(String text) {
        return text != null && "".equals(text.trim());
    }

    /**
     * 判断一个字符串是否是 null 或 "" 或 "  "
     */
    public static boolean isBlank(String text) {
        return text == null || "".equals(text.trim());
    }

    /**
     * 驼峰转下划线
     */
    public static String hump2Underline(String source) {

        if (isBlank(source)) {
            return "";
        }
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(source);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 下划线转驼峰
     */
    public static String underline2Hump(String source) {

        if (isBlank(source)) {
            return "";
        }
        Pattern pattern = Pattern.compile("_[a-z]");
        Matcher matcher = pattern.matcher(source);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(0).toUpperCase().replace("_", ""));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 驼峰转横线-
     */
    public static String hump2KebabCase(String source) {

        if (isBlank(source)) {
            return "";
        }
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(source);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "-" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * -横线转驼峰
     */
    public static String kebabCase2Hump(String source) {

        if (isBlank(source)) {
            return "";
        }
        Pattern pattern = Pattern.compile("-[a-z]");
        Matcher matcher = pattern.matcher(source);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(0).toUpperCase().replace("-", ""));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 首字母转大写
     */
    public static String capital(String source) {
        if (isBlank(source)) {
            return "";
        }

        String capital = source.substring(0, 1);
        String other = source.substring(1);
        return capital.toUpperCase() + other;
    }

    /**
     * 首字母转小写
     */
    public static String deCapital(String source) {
        if (isBlank(source)) {
            return "";
        }
        String capital = source.substring(0, 1);
        String other = source.substring(1);
        return capital.toLowerCase() + other;
    }


    public static void main(String[] args) {
        System.out.println(hump2KebabCase("Str"));
    }
}
