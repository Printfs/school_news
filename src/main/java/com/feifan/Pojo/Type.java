package com.feifan.Pojo;


public class Type {
    private int typeId;
    private String kinds;

    public Type(int typeId, String kinds) {
        this.typeId = typeId;
        this.kinds = kinds;
    }

    public Type() {
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", kinds='" + kinds + '\'' +
                '}';
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getKinds() {
        return kinds;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }
}
