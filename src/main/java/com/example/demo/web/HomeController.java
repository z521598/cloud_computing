package com.example.demo.web;

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
    public List<String> getAllFile() {

        return null;
    }

}
