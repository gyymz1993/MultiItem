package com.freelib.multiitem.demo.bean;

import com.freelib.multiitem.item.BaseItemData;

import java.util.List;

/**
 * 注意：在正常业务中不需要继承BaseItemData，此处也可以实现ItemData接口，只是为了Drag功能
 * <p>
 * Created by free46000 on 2017/3/19.
 */
public class TextSwitchBean extends BaseItemData {
    private String text;
    private boolean isSelect;

    public TextSwitchBean(String text, boolean isSelect) {
        this.text = text;
        this.isSelect = isSelect;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
