package com.example.demo.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bean.LinkBean;
import com.example.demo.bean.NodeBean;
import com.example.demo.bean.PdfBean;
import com.example.demo.bean.ResultBean;
import com.example.demo.utils.FileUtils;
import com.example.demo.utils.PdfUtils;
import com.example.demo.utils.StringUtils;

/**
 * Created by langshiquan on 17/6/12.
 */
@Service
public class PdfServiceImpl implements PdfService {

    public static final String pdfHome = "/Users/langshiquan/Desktop/cloud/pdfs/";

    @Override
    public ResultBean parsePdf(String[] pdfPath) {
        // 获取文件路径
        ResultBean resultBean = new ResultBean();
        List<NodeBean> nodes = new LinkedList<>();
        List<LinkBean> links = new LinkedList<>();
        List<String> filePaths = FileUtils.getFilePath(pdfPath);
        // 兼容最后一个分号
        for (int i = 0; i < filePaths.size() - 1; i++) {
            String pdfTxt = PdfUtils.parsePdfToTxt(filePaths.get(i));
            PdfBean pdfBean = StringUtils.parsePdfString(pdfTxt);

            // TODO qiaozhi
            pdfBean.getAuthor();
            pdfBean.getRef();

        }
        resultBean.setLinks(links);
        resultBean.setNodes(nodes);
        return resultBean;
    }

    @Override
    public List<String> getPdfList(String path) {
        return FileUtils.getFileNameList(path);
    }
}
