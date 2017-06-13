package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.ResultBean;

/**
 * Created by langshiquan on 17/6/12.
 */
public interface PdfService {
    ResultBean parsePdf(String[] pdfPath);
}
