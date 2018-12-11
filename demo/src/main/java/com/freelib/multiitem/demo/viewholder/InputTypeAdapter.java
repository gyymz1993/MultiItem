package com.freelib.multiitem.demo.viewholder;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.freelib.multiitem.adapter.holder.BaseViewHolder;
import com.freelib.multiitem.adapter.holder.BaseViewHolderManager;
import com.freelib.multiitem.demo.R;
import com.freelib.multiitem.demo.bean.EdittextBean;

public class InputTypeAdapter extends BaseViewHolderManager<EdittextBean> {
    @Override
    public void onBindViewHolder(BaseViewHolder holder, EdittextBean edittextBean) {
        //初始化Input视图，由于Input视图不可以复用，所以直接在初始化视图时设置好相关内容即可
        TextView nameText = getView(holder.itemView, R.id.text);
        if (!TextUtils.isEmpty(edittextBean.getName())) {
            nameText.setText(edittextBean.getName());
        } else {
            nameText.setText("测试");
        }

        EditText editText = getView(holder.itemView, R.id.editText);
        if (!TextUtils.isEmpty(edittextBean.getHint())) {
            editText.setHint(edittextBean.getHint());
        } else {
            editText.setHint("请输入数量");
        }
        if (!TextUtils.isEmpty(edittextBean.getDefValue())) {
            editText.setText(edittextBean.getDefValue());
        } else {
            // editText.setText("2");
        }
        TextWatcher nameWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (getView(holder.itemView, R.id.editText).hasFocus()) {//判断当前EditText是否有焦点在
                    //  model.name = editable.toString()
                    edittextBean.setDefValue(editable.toString());
                }
            }
        };
        // TextSwitcher nameWatcher=new TextSwitcher(holder);
        //添加editText的监听事件
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    if (view instanceof EditText) {
                        ((EditText) view).addTextChangedListener(nameWatcher);
                    }
                } else {
                    if (view instanceof EditText) {
                        ((EditText) view).removeTextChangedListener(nameWatcher);
                    }
                }
            }
        });

    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_edit;
    }


}
