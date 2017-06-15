package com.example.demo.bean;

import java.util.List;

/**
 * Created by langshiquan on 17/6/12.
 */
public class ResultBean {
    List<NodeBean> nodes;
    List<LinkBean> links;

    public List<NodeBean> getNodes() {
        return nodes;
    }

    public ResultBean() {
    }

    public void setNodes(List<NodeBean> nodes) {
        this.nodes = nodes;
    }

    public List<LinkBean> getLinks() {
        return links;
    }

    public void setLinks(List<LinkBean> links) {
        this.links = links;
    }

    public ResultBean(List<NodeBean> nodes, List<LinkBean> links) {

        this.nodes = nodes;
        this.links = links;
    }

    @Override
    public String toString() {
        StringBuilder nodesList = new StringBuilder("nodes:").append("\n");
        for (NodeBean nodeBean : nodes) {
            nodesList.append(nodeBean.toString()).append("\n");
        }

        StringBuilder linksList = new StringBuilder("links:").append("\n");
        for (LinkBean linkBean : links) {
            linksList.append(linkBean.toString()).append("\n");
        }
        return nodesList.toString() + "\n*******************\n" + linksList.toString();
    }
}
