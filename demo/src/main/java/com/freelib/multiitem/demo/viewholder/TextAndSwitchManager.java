package com.freelib.multiitem.demo.viewholder;

import android.support.annotation.NonNull;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.freelib.multiitem.adapter.holder.BaseViewHolder;
import com.freelib.multiitem.adapter.holder.BaseViewHolderManager;
import com.freelib.multiitem.demo.R;
import com.freelib.multiitem.demo.bean.TextSwitchBean;
import com.kyleduo.switchbutton.SwitchButton;

/**
 * @author free46000  2017/03/17
 * @version v1.0
 */
public class TextAndSwitchManager extends BaseViewHolderManager<TextSwitchBean> {


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, @NonNull TextSwitchBean data) {
        TextView textView = getView(holder, R.id.id_tv);
        textView.setText(data.getText());
        SwitchButton mSbCleaning = getView(holder, R.id.sb_cleaning);
        mSbCleaning.setChecked(data.isSelect() ? true : false);
        // mSbCleaning.setEnabled(false);
        mSbCleaning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mSbCleaning.setChecked(isChecked);
                data.setSelect(isChecked);
            }
        });
    }

    //imageView.setImageResource(data.getImg());

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_text_switch;
    }


}
