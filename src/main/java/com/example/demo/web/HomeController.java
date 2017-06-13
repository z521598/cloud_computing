package com.example.demo.web;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.bean.ResultBean;
import com.example.demo.service.PdfService;

/**
 * Created by langshiquan on 17/6/12.
 */
@Controller
public class HomeController {

    @Autowired
    private PdfService pdfService;

    @RequestMapping("/parsePdf")
    @ResponseBody
    public ResultBean parsePdf(String pdf) {
        // 将字符串解析为数组
        return pdfService.parsePdf(pdf.split(";"));
    }

    @RequestMapping("/")
    public String home(String pdf) {
        return "home.html";
    }

    @RequestMapping("/getAllFile")
    @ResponseBody
    public List<String> getAllFile() {
        List<String> list = new LinkedList<>();
        list.add("123你好");
        list.add("1234阿斯顿撒");
        list.add("12阿斯顿35");
        list.add("1236撒旦");
        list.add("1237打算");
        return list;
    }

}
