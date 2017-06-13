package com.example.demo.bean;

import java.util.List;

/**
 * Created by langshiquan on 17/6/13.
 */
public class PdfBean {
    List<String> author;
    List<String> ref;

    public PdfBean() {
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public List<String> getRef() {
        return ref;
    }

    public void setRef(List<String> ref) {
        this.ref = ref;
    }

    public PdfBean(List<String> author, List<String> ref) {
        this.author = author;
        this.ref = ref;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("author:").append(author.size()).append(" {");
        for (int i = 0; i < author.size(); i++) {
            stringBuilder.append(author.get(i)).append(",");
        }
        stringBuilder.append("}");
        stringBuilder.append("ref:").append(ref.size()).append(" {");
        for (int i = 0; i < ref.size(); i++) {
            stringBuilder.append(ref.get(i)).append(",");
        }
        stringBuilder.append("}");


        return stringBuilder.toString();
    }
}
