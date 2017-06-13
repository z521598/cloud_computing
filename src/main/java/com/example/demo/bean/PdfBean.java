package com.example.demo.bean;

import java.util.List;

/**
 * Created by langshiquan on 17/6/13.
 */
public class PdfBean {
    List<String> author;
    List<String> ref;

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
}
