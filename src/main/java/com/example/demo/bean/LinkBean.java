package com.example.demo.bean;

import java.util.Random;

/**
 * Created by langshiquan on 17/6/13.
 */
public class LinkBean {
    // 被引用者
    Integer source;
    // 引用者
    Integer target;
    // 随机值
    Integer value = new Random().nextInt(10);
    // 引用者
    String label = "引用";

    public LinkBean () {

    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LinkBean(Integer source, Integer target, Integer value, String label) {
        this.source = source;
        this.target = target;
        this.value = value;
        this.label = label;
    }
}
