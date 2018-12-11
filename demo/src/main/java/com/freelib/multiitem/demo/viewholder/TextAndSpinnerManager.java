package com.freelib.multiitem.demo.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.freelib.multiitem.adapter.holder.BaseViewHolder;
import com.freelib.multiitem.adapter.holder.BaseViewHolderManager;
import com.freelib.multiitem.demo.R;
import com.freelib.multiitem.demo.bean.TextSpinnerBean;
import com.jaredrummler.materialspinner.MaterialSpinner;

/**
 * @author free46000  2017/03/17
 * @version v1.0
 */
public class TextAndSpinnerManager extends BaseViewHolderManager<TextSpinnerBean> {



    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, @NonNull TextSpinnerBean data) {
        TextView textView = getView(holder, R.id.id_tv);
        textView.setText(data.getText());
        MaterialSpinner spinner = getView(holder, R.id.id_msp);
        String[] ITEMS = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "自定义"};
        if (data.getmList() != null && data.getmList().size() != 0) {
            ITEMS = new String[data.getmList().size()];
            data.getmList().toArray(ITEMS);
        }
        if (data.getmData() != null && data.getmData().length != 0) {
            ITEMS = data.getmData();
        }
        spinner.setItems(ITEMS);

        RelativeLayout mRlDiagonal1 = getView(holder, R.id.rl_diagonal_1);
        EditText editText = getView(holder.itemView, R.id.et_diagonal_1);

        if (!TextUtils.isEmpty(data.getSelectVaule())){
            mRlDiagonal1.setVisibility(data.getSelectVaule().equals("自定义") ? View.VISIBLE : View.GONE);
        }
        if (!TextUtils.isEmpty(data.getCustomized())){
            editText.setHint(data.getCustomized());
        }

        if (data.getSelectPosition()!=-1){
            spinner.setSelectedIndex(data.getSelectPosition());
        }else {
            spinner.setSelectedIndex(0);
        }

        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                mRlDiagonal1.setVisibility(item.equals("自定义") ? View.VISIBLE : View.GONE);
                spinner.setSelectedIndex(position);
                data.setSelectPosition(position);
                data.setSelectVaule(item.toString());
            }
        });
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_text_spinner;
    }


}
