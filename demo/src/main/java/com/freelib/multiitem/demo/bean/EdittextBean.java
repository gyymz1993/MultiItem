package com.freelib.multiitem.demo.bean;

public class EdittextBean {

    private String name;
    private String defValue = "";
    private String hint;

    public EdittextBean(String name, String hint) {
        this.name = name;
        this.hint = hint;
    }

    public EdittextBean(String name, String defValue, String hint) {
        this.name = name;
        this.defValue = defValue;
        this.hint = hint;
    }

    public EdittextBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefValue() {
        return defValue;
    }

    public void setDefValue(String defValue) {
        this.defValue = defValue;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
