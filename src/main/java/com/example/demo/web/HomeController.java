package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PdfService;

/**
 * Created by langshiquan on 17/6/12.
 */
@RestController
public class HomeController {
    @Autowired
    private PdfService pdfService;

    @RequestMapping("/parsePdf")
    public String parsePdf(String pdf) {
        return "123";
    }
}
