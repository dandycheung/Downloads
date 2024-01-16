package com.mundane.downloads.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RegexUtil
 *
 * @author fangyuan
 * @date 2023-05-18
 */
public class RegexUtil {
    private static final Pattern TITLE_PATTERN = Pattern.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]");
    
    public static String replaceTitle(String title) {
        Matcher matcher = TITLE_PATTERN.matcher(title);
        // 将匹配到的非法字符以空替换
        title = matcher.replaceAll("");
        return title;
    }
    
    public static String getValidTitle(String title) {
        if (StringUtils.isEmpty(title)) {
            title = String.valueOf(new Date().getTime());
            return title;
        }
        Matcher matcher = TITLE_PATTERN.matcher(title);
        // 将匹配到的非法字符以空替换
        title = matcher.replaceAll("");
        if (title.length() > 10) {
            title = title.substring(0, 11);
        }
        return title;
    }
    
    public static String getUrl(String text) {
        String regex = "(https?://\\S+)";
        
        // 创建 Pattern 对象
        Pattern pattern = Pattern.compile(regex);
        
        // 创建 Matcher 对象
        Matcher matcher = pattern.matcher(text);
        
        // 提取网址
        if (matcher.find()) {
            String url = matcher.group();
            return url;
        }
        return null;
    }
}
