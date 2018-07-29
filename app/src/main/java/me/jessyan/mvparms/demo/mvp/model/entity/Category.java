package me.jessyan.mvparms.demo.mvp.model.entity;

/**
 * Created by guomin on 2018/7/28.
 */

public class Category {
    private String id;
    private String name;
    private String parentId;
    private String busType;

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                ", busType='" + busType + '\'' +
                '}';
    }
}
