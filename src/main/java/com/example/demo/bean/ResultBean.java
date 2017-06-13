package com.example.demo.bean;

import java.util.List;

/**
 * Created by langshiquan on 17/6/12.
 */
public class ResultBean {
    List<NodeBean> node;
    List<LinkBean> link;

    public List<NodeBean> getNodeBeen() {
        return node;
    }

    public ResultBean() {
    }

    public void setNode(List<NodeBean> node) {
        this.node = node;
    }

    public List<LinkBean> getLink() {
        return link;
    }

    public void setLink(List<LinkBean> link) {
        this.link = link;
    }

    public ResultBean(List<NodeBean> node, List<LinkBean> link) {

        this.node = node;
        this.link = link;
    }

}
