package com.example.demo.bean;

/**
 * Created by langshiquan on 17/6/13.
 */
public class NodeBean {
    // 唯一id
    Integer name;
    // 固定值
    Integer category = 0;
    // 被引用的次数,初始值是1
    Integer value = 1;
    // 作者名字
    String label;

    public NodeBean() {
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
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

    public NodeBean(Integer name, Integer category, Integer value, String label) {

        this.name = name;
        this.category = category;
        this.value = value;
        this.label = label;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{name:").append(name).append(";").append("value:").append(value).append(";");
        stringBuilder.append("label:").append(label).append("}");
        return stringBuilder.toString();
    }
}