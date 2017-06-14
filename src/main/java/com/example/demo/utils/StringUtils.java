package com.example.demo.utils;

import com.example.demo.bean.PdfBean;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by wjcneo on 2017/6/13.
 */
public class StringUtils {
    public static PdfBean parsePdfString(String pdfString) {
        PdfBean pb = new PdfBean();
        String author_str;
        StringBuffer quote_strbfr = new StringBuffer();
        String quote_str;
        String[] author_arr;
        String[] quote_arr;
        List<String> author_list = new ArrayList<String>();
        List<String> quote_list = new ArrayList<String>();

        String reg_line = "\n"; // 分割文章正则
        String reg_quote = "^\\[[0-9]{1,3}\\]\\s(.*)"; // 获取引用正则

        String[] ps_array = pdfString.split(reg_line);
        /* 获取作者 */
        author_str = ps_array[1]; // 第二行（即ps_array[1]）为作者
        author_arr = author_str.split("\\，");
        for (int i = 0; i < author_arr.length; i++) {
            author_list.add(author_arr[i].trim());
        }
        /* 获取引用 */
        for (int i = 0; i < ps_array.length; i++) {
            boolean isMatch = Pattern.matches(reg_quote, ps_array[i]);
            if (isMatch) {
                System.out.println("???");
                System.out.println(ps_array[i]);
                String[] temp_arr = ps_array[i].split("\\.");
                String temp_str = temp_arr[0].substring(4); //第一个.前面是引用作者，除去开头[数字]加一个空格，共4个字符
                quote_strbfr.append(temp_str);
                quote_strbfr.append(",");
            }
        }
        quote_str = quote_strbfr.toString();
        System.out.println("quote_str=" + quote_str);
        quote_arr = quote_str.split("\\,");
        for (int i = 0; i < quote_arr.length; i++) {
            quote_list.add(quote_arr[i].trim());
        }
        /*  传入PdfBean实例 */
        pb.setAuthor(author_list);
        pb.setRef(quote_list);
        /* 返回PdfBean实例 */
        return pb;
    }

    public static void main(String[] args) {
        String pdfdemo = PdfUtils.parsePdfToTxt("/Users/langshiquan/Desktop/cloud/pdfs/test.pdf");
        System.out.println(pdfdemo);
        PdfBean pdfBean = parsePdfString(pdfdemo);
        System.out.println(pdfBean);
    }
}
