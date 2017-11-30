package com.yuyh.jsonviewer.library.utils;

import java.util.regex.Pattern;

/**
 * Created by yuyuhang on 2017/11/30.
 */
public class Utils {

    private static Pattern urlPattern = Pattern.compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$");

    /**
     * 判断字符串是否是url
     *
     * @param str
     * @return
     */
    public static boolean isUrl(String str) {
        return urlPattern.matcher(str).matches();
    }

    /**
     * json 格式化缩进(格式化前不能有缩进，最好是格式化从服务端下发的)
     *
     * @param jsonStr
     * @return
     */
    public static String jsonFormat(String jsonStr) {
        if (jsonStr == null) return "";
        int level = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < jsonStr.length(); i++) {
            char c = jsonStr.charAt(i);
            if (level > 0 && '\n' == builder.charAt(builder.length() - 1)) {
                builder.append(getHierarchyStr(level));
            }
            switch (c) {
                case '{':
                case '[':
                    builder.append(c).append("\n");
                    level++;
                    break;
                case ',':
                    builder.append(c).append("\n");
                    break;
                case '}':
                case ']':
                    builder.append("\n");
                    level--;
                    builder.append(getHierarchyStr(level));
                    builder.append(c);
                    break;
                default:
                    builder.append(c);
                    break;
            }
        }

        return builder.toString();
    }

    /**
     * 对应层级前面所需的空格数
     *
     * @param hierarchy 缩进层级
     * @return
     */
    public static String getHierarchyStr(int hierarchy) {
        StringBuilder levelStr = new StringBuilder();
        for (int levelI = 0; levelI < hierarchy; levelI++) {
            levelStr.append("      ");
        }
        return levelStr.toString();
    }

}
