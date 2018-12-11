package com.freelib.multiitem.demo.bean;

import com.freelib.multiitem.item.BaseItemData;

import java.util.List;

/**
 * 注意：在正常业务中不需要继承BaseItemData，此处也可以实现ItemData接口，只是为了Drag功能
 * <p>
 * Created by free46000 on 2017/3/19.
 */
public class TextSpinnerBean extends BaseItemData {
    private String text;
    private List<String> mList;
    private String [] mData;
    private String customized;
    private String selectVaule;
    private int selectPosition=-1;


    public int getSelectPosition() {
        return selectPosition;
    }

    public void setSelectPosition(int selectPosition) {
        this.selectPosition = selectPosition;
    }

    public String getSelectVaule() {
        return selectVaule;
    }

    public void setSelectVaule(String selectVaule) {
        this.selectVaule = selectVaule;
    }

    public String[] getmData() {
        return mData;
    }

    public void setmData(String[] mData) {
        this.mData = mData;
    }

    public List<String> getmList() {
        return mList;
    }

    public void setmList(List<String> mList) {
        this.mList = mList;
    }

    public TextSpinnerBean(String text) {
        this.text = text;
    }

    public TextSpinnerBean(String text, List<String> mList) {
        this.text = text;
        this.mList = mList;
    }

    public TextSpinnerBean(String text, String[] mData) {
        this.text = text;
        this.mData = mData;
    }

    public TextSpinnerBean(String text, String[] mData, String customized) {
        this.text = text;
        this.mData = mData;
        this.customized = customized;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getCustomized() {
        return customized;
    }

    public void setCustomized(String customized) {
        this.customized = customized;
    }

    @Override
    public String toString() {
        return text;
    }
}
