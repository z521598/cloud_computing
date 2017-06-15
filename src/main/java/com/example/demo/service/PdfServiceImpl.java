package com.example.demo.service;

import com.example.demo.bean.LinkBean;
import com.example.demo.bean.NodeBean;
import com.example.demo.bean.PdfBean;
import com.example.demo.bean.ResultBean;
import com.example.demo.utils.FileUtils;
import com.example.demo.utils.PdfUtils;
import com.example.demo.utils.StringUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by langshiquan on 17/6/12.
 */
@Service
public class PdfServiceImpl implements PdfService {
    static int No = 1;

    @Value("${file.pdf.home}")
    private String pdfHome;

    @Override
    public ResultBean parsePdf(String[] pdfPath) {
        // 获取文件路径
        ResultBean resultBean = new ResultBean();
        List<NodeBean> nodes = new LinkedList<>();
        List<LinkBean> links = new LinkedList<>();
        // 兼容最后一个分号
        for (int i = 0; i < pdfPath.length; i++) {
            String pdfTxt = PdfUtils.parsePdfToTxt(pdfHome + pdfPath[i]);
            PdfBean pdfBean = StringUtils.parsePdfString(pdfTxt);
            System.out.println(pdfBean);
            List<String> getAuthors = pdfBean.getAuthor();
            List<String> getRefs = pdfBean.getRef();
            doPDF(nodes, links, getAuthors, getRefs);

        }
        resultBean.setLinks(links);
        resultBean.setNodes(nodes);
        System.out.println(resultBean);
        return resultBean;
    }

    @Override
    public List<String> getPdfList(String path) {
        return FileUtils.getFileNameList(path);
    }

    /*qiaozhi 处理两个LIST*/
    public void doPDF(List<NodeBean> nodes, List<LinkBean> links, List<String> authors, List<String> refs) {
        System.out.println("开始执行doPDF");
        //List<LinkBean> linkbeans = new ArrayList();
        for (String author : authors) {
            if (!isContained(nodes, author)) {
                NodeBean nodebean = new NodeBean();
                nodebean.setLabel(author);
                nodebean.setName(No);
                nodes.add(nodebean);
                System.out.println(author + "添加成功,信息如下:" + nodebean.getName());
                No++;
            }
            for (String ref : refs) {
                if (!isContained(nodes, ref)) {
                    NodeBean nodebean = new NodeBean();
                    nodebean.setLabel(ref);
                    nodebean.setName(No);
                    nodes.add(nodebean);
                    No++;
                    System.out.println(ref + "添加成功,信息如下:" + nodebean.getName());
                }

                LinkBean temp = new LinkBean();
                changeValue(nodes, ref);
                temp.setSource(lableTOname(nodes, author));
                temp.setTarget(lableTOname(nodes, ref));
                links.add(temp);
            }
        }
    }

    /*qiaozhi 判断此人是否之前存在*/
    public boolean isContained(List<NodeBean> l, String name) {
        boolean flag = false;
        for (NodeBean nb : l) {
            if (nb.getLabel().equals(name)) {
                flag = true;
            }
        }
        return flag;
    }

    /*qiaozhi 读入人的名字得到人的编号*/
    public int lableTOname(List<NodeBean> nodes, String lable) {
        for (NodeBean nb : nodes) {
            if (nb.getLabel().equals(lable)) {
                return nb.getName();
            }
        }
        return -1;
    }

    /*qiaozhi 改变引用次数*/
    public void changeValue(List<NodeBean> nodes, String lable) {
        for (NodeBean nb : nodes) {
            if (nb.getLabel().equals(lable)) {
                Integer value = nb.getValue();
                value = value + 1;
                nb.setValue(value);
            }
        }
    }
}
