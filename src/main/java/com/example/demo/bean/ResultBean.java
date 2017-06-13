package com.example.demo.bean;

import java.util.List;

/**
 * Created by langshiquan on 17/6/12.
 */
public class ResultBean {
    List<NodeBean> nodeBeen;
    List<LinkBean> link;

    public List<NodeBean> getNodeBeen() {
        return nodeBeen;
    }

    public ResultBean() {
    }

    public void setNodeBeen(List<NodeBean> nodeBeen) {
        this.nodeBeen = nodeBeen;
    }

    public List<LinkBean> getLink() {
        return link;
    }

    public void setLink(List<LinkBean> link) {
        this.link = link;
    }

    public ResultBean(List<NodeBean> nodeBeen, List<LinkBean> link) {

        this.nodeBeen = nodeBeen;
        this.link = link;
    }

}
