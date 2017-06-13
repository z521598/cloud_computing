package com.example.demo.bean;

import java.util.List;

/**
 * Created by langshiquan on 17/6/12.
 */
public class ResultBean {
    List<NodeBean> nodes;
    List<LinkBean> link;

    public List<NodeBean> getNodes() {
        return nodes;
    }

    public ResultBean() {
    }

    public void setNodes(List<NodeBean> nodes) {
        this.nodes = nodes;
    }

    public List<LinkBean> getLinks() {
        return link;
    }

    public void setLinks(List<LinkBean> link) {
        this.link = link;
    }

    public ResultBean(List<NodeBean> nodes, List<LinkBean> link) {

        this.nodes = nodes;
        this.link = link;
    }

}
