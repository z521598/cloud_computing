package com.example.demo.service;

import com.example.demo.bean.LinkBean;
import com.example.demo.bean.NodeBean;
import com.example.demo.bean.PdfBean;
import com.example.demo.bean.ResultBean;
import com.example.demo.utils.FileUtils;
import com.example.demo.utils.PdfUtils;
import com.example.demo.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by langshiquan on 17/6/12.
 */
@Service
public class PdfServiceImpl implements PdfService {
	static int No = 1;
    public static final String pdfHome = "/Users/langshiquan/Desktop/cloud/pdfs/";
	List<NodeBean> nodes = new LinkedList<>();
	List<LinkBean> links = new LinkedList<>();
    @Override
    public ResultBean parsePdf(String[] pdfPath) {
        // 获取文件路径
        ResultBean resultBean = new ResultBean();
		/*下面两个LIST放到全局了*/
        //List<NodeBean> nodes = new LinkedList<>();
        //List<LinkBean> links = new LinkedList<>();
        List<String> filePaths = FileUtils.getFilePath(pdfPath);
        // 兼容最后一个分号
        for (int i = 0; i < filePaths.size() - 1; i++) {
            String pdfTxt = PdfUtils.parsePdfToTxt(filePaths.get(i));
            PdfBean pdfBean = StringUtils.parsePdfString(pdfTxt);
            // TODO qiaozhi
			List<String> getAuthors = pdfBean.getAuthor();
    		List<String> getRefs = pdfBean.getRef();
			doPDF(getAuthors,getRefs);
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
	/*qiaozhi 处理两个LIST*/
	public void doPDF(List<String> authors,List<String> refs){
System.out.println("开始执行doPDF");
    	//List<LinkBean> linkbeans = new ArrayList();
		for(String author : authors){
			if(!isContained(nodes,author)){
				NodeBean nodebean = new NodeBean();
				//nodebean.setCategory(1);
				nodebean.setLabel(author);
				nodebean.setName(No);
				nodebean.setValue(0);
				nodes.add(nodebean);
System.out.println(author+"添加成功,信息如下:"+nodebean.getName());
				No++;
			}
			for(String ref : refs){
				if(!isContained(nodes,ref)){
					NodeBean nodebean = new NodeBean();
					//nodebean.setCategory(1);
					nodebean.setLabel(ref);
					nodebean.setName(No);
					nodebean.setValue(0);
					nodes.add(nodebean);
					No++;
System.out.println(ref+"添加成功,信息如下:"+nodebean.getName());
				}
				
				LinkBean temp = new LinkBean();
				temp.setSource(lableTOname(author));
				temp.setTarget(lableTOname(ref));
				links.add(temp);
			}
			for(String ref2 : refs){
				changeValue(ref2);
			}
		}
    }
	/*qiaozhi 判断此人是否之前存在*/
	public boolean isContained(List<NodeBean> l,String name){
    	boolean flag = false;
    	for(NodeBean nb : l){
    		if(nb.getLabel() == name){
    			flag = true;
    		}
    	}
    	return flag;
    }
	/*qiaozhi 读入人的名字得到人的编号*/
    public int lableTOname(String lable){
    	for(NodeBean nb : nodes){
    		if(nb.getLabel() == lable){
    			return nb.getName();
    		}
    	}
    	return -1;
    }
	/*qiaozhi 改变引用次数*/
    public void changeValue(String lable){
    	for(NodeBean nb : nodes){
    		if(nb.getLabel() == lable){
    			Integer value = nb.getValue();
    			value = value + 1;
    			nb.setValue(value);
    		}
    	}
    }
}
