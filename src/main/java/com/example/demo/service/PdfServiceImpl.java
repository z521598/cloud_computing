package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bean.ResultBean;
import com.example.demo.utils.FileUtils;

/**
 * Created by langshiquan on 17/6/12.
 */
@Service
public class PdfServiceImpl implements PdfService {

    @Override
    public ResultBean parsePdf(String[] pdfPath) {
        // 获取文件路径
        ResultBean resultBean = new ResultBean();
        List<String> filePaths = FileUtils.getFilePath(pdfPath);
        for (int i = 0; i < filePaths.size(); i++) {

            // TODO 业务处理
        }
        return resultBean;
    }
}
