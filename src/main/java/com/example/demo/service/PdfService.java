package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.VectorBean;

/**
 * Created by langshiquan on 17/6/12.
 */
public interface PdfService {

    List<VectorBean> parsePdf(String pdf);
}
