package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String parsePdf(String pdf) {

        return pdf;
    }

    @RequestMapping("/")
    public String home(String pdf) {
        return "hello.html";
    }

}
