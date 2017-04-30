package com.denghb.zuiyou.crawler.server.utils;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by denghb on 2017/4/6.
 */
public class HtmlUtils {


    public static String getAttrForElements(Elements elements, String attr) {
        for (Element element : elements) {
            return element.attr(attr);
        }
        return null;
    }

    public static String getNumber(String html){
        Pattern pattern = Pattern.compile("\\d*");
        Matcher matcher = pattern.matcher(html);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }

    public static void main(String ... args){
//        System.out.print(getNumber("12 个月"));

        String text = "性别：男 年龄：31 注册时间：2016/5/3 文化程度：专科 毕业院校：中山大学 学习形式：自考";

        String [] strings = text.split(" ");
        for (String str : strings) {
            String [] strs = str.split("：");
            System.out.println(strs[1]);
        }

        Pattern pattern = Pattern.compile("<p class=\"ex col-1\"> 成功借款次数： <span class=\"num\">(\\d*)次</span></p>");
        Matcher matcher = pattern.matcher("<p class=\"ex col-1\"> 成功借款次数： <span class=\"num\">53次</span></p>");
        if (matcher.find()) {
            System.out.println(matcher.group(1)); ;
        }
    }
}
