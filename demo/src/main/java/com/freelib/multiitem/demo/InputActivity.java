package com.freelib.multiitem.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.freelib.multiitem.adapter.InputItemAdapter;
import com.freelib.multiitem.demo.input.ItemEdit;
import com.freelib.multiitem.demo.input.ItemInfoDataBind;
import com.freelib.multiitem.demo.input.ItemNameAndSex;

import org.androidannotations.annotations.Click;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * todo 增加验证Rule，怎样增加更灵活
 */
public class InputActivity extends AppCompatActivity {
    protected RecyclerView recyclerView;

    private InputItemAdapter adapter;
    public static Intent startActivity(Context context) {
        //ItemClickActivity_.intent(context).start();
        Intent intent=new Intent(context,InputActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        recyclerView=  findViewById(R.id.recyclerView);
        initViews();
    }

    protected void initViews() {
        setTitle(R.string.input_title);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //初始化adapter
        adapter = new InputItemAdapter();
        recyclerView.setAdapter(adapter);
        List<Object> list = new ArrayList<>();
        //姓名和性别录入Item，一个录入item对应多个提交的值{"name":"","sex":""}
        list.add(new ItemNameAndSex());
        //正常的EditText录入Item
        list.add(new ItemEdit("height").setName("身高:"));
        list.add(new ItemEdit("weight").setName("体重:"));
        list.add(new ItemEdit("age").setName("年龄:"));
        list.add(new ItemEdit("default").setName("国家:").setDefValue("中国"));
        //利用DataBinding的录入Item
        list.add(new ItemInfoDataBind("info").setName("介绍:"));
        //添加user id对应的隐藏域的Item（用户不可见）
        adapter.addHiddenItem("id", "隐藏域中携带id");
        adapter.setDataItems(list);
    }

    @Click(R.id.submit_btn)
    public void submit() {
        //通过adapter.isValueChange()判断表单内容是否改变
        //通过adapter.isValueValid()判断表单内容是否有效
        //通过adapter.getInputJson()直接获取表单录入Json，还有获取录入Map的方法
        String tipTxt = "表单内容" + (adapter.isValueChange() ? "　已经　" : "　没有　") +
                "被用户改变！\n表单　　" + (adapter.isValueValid() ? "　已经　" : "　没有　") +
                "通过验证！\n自动组装的表单内容为：\n";

        //表单内容json格式化后的字符串
        String valueTxt = null;
        try {
            valueTxt = adapter.getInputJson().toString(4);
        } catch (JSONException e) {
            //do nothing
        }
        new AlertDialog.Builder(this).setTitle("提交").setMessage(tipTxt + valueTxt)
                .setPositiveButton(R.string.confirm, null).show();
    }

}
