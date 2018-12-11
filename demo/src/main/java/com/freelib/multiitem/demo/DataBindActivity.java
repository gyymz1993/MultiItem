package com.freelib.multiitem.demo;

import android.content.Context;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.freelib.multiitem.adapter.BaseItemAdapter;
import com.freelib.multiitem.adapter.holder.DataBindViewHolderManager;
import com.freelib.multiitem.demo.bean.EdittextBean;
import com.freelib.multiitem.demo.bean.TextBean;
import com.freelib.multiitem.demo.bean.TextSpinnerBean;
import com.freelib.multiitem.demo.bean.TextSwitchBean;
import com.freelib.multiitem.demo.input.ItemEdit;
import com.freelib.multiitem.demo.viewholder.InputTypeAdapter;
import com.freelib.multiitem.demo.viewholder.TextAndSpinnerManager;
import com.freelib.multiitem.demo.viewholder.TextAndSwitchManager;

import java.util.ArrayList;
import java.util.List;

public class DataBindActivity extends AppCompatActivity {
    protected RecyclerView recyclerView;


    public static Intent startActivity(Context context) {
        //ItemClickActivity_.intent(context).start();
        Intent intent = new Intent(context, DataBindActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recycler);
        recyclerView = findViewById(R.id.recyclerView);
        initViews();
    }

    protected void initViews() {
        setTitle(R.string.data_bind_title);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //初始化adapter
        BaseItemAdapter adapter = new BaseItemAdapter();
        //绑定写法一(简单)：直接传入BR.itemData(VariableId)
        adapter.register(TextBean.class, new DataBindViewHolderManager<>(R.layout.item_text_data_bind, BR.itemData));
        //绑定写法二(自由)：传入ItemBindView接口实例，可以定制绑定业务逻辑
        //  adapter.register(ImageTextBean.class, new DataBindViewHolderManager<>(R.layout.item_image_text_data_bind, this::onBindViewHolder));
        adapter.register(TextSpinnerBean.class, new TextAndSpinnerManager());
        adapter.register(EdittextBean.class, new InputTypeAdapter());
        adapter.register(TextSwitchBean.class, new TextAndSwitchManager());
        recyclerView.setAdapter(adapter);
        List<Object> list = new ArrayList<>();
//        list.add(new TextBean("法兰基本信息"));
//        //list.add(new ImageTextBean("img2", "BBB"));
//        list.add(new TextSpinnerBean("公司名称", new String[]{"jite", "jie", "upm2", "own3","自定义"},"自定义公司名称"));
//        list.add(new TextSpinnerBean("工厂名称", new String[]{"jite", "jie", "upm2", "own3","自定义"},"自定义工厂名称"));
//        list.add(new TextSpinnerBean("装置名称", new String[]{"jite", "jie", "upm2", "own3","自定义"},"自定义装置名称"));
//        list.add(new ItemEdit("height").setName("身高:"));
//        list.add(new TextBean("工具参数"));
//        for (int i = 0; i < 3; i++) {
//            list.add(new EdittextBean("工具参数", ""));
//        }
//        list.add(new TextBean("螺旋参数"));
//        for (int i = 0; i < 3; i++) {
//            list.add(new EdittextBean("螺旋参数", ""));
//        }
//        list.add(new TextBean("测试参数"));
//        for (int i = 0; i < 3; i++) {
//            list.add(new EdittextBean("测试参数", ""));
//        }
//
//        list.add(new TextSwitchBean("清洗是否达标",true));
//        list.add(new TextSwitchBean("润滑是否达标",false));
//


        list.add(new TextBean("法兰基本信息"));
        //list.add(new ImageTextBean("img2", "BBB"));
        list.add(new TextSpinnerBean("公司名称", new String[]{"jite", "jie", "upm2", "own3", "自定义"}, "自定义公司名称"));
        list.add(new TextSpinnerBean("工厂名称", new String[]{"jite", "jie", "upm2", "own3", "自定义"}, "自定义工厂名称"));
        list.add(new TextSpinnerBean("装置名称", new String[]{"jite", "jie", "upm2", "own3", "自定义"}, "自定义装置名称"));
        list.add(new TextSpinnerBean("设备名称", new String[]{"jite", "jie", "upm2", "own3", "自定义"}, "自定义设备名称"));
        list.add(new TextSpinnerBean("法兰名称", new String[]{"jite", "jie", "upm2", "own3", "自定义"}, "自定义法兰名称"));
        list.add(new TextSpinnerBean("螺旋数量", new String[]{"jite", "jie", "upm2", "own3", "自定义"}, "自定义螺旋数量"));
        list.add(new EdittextBean("螺旋材料", "请输入螺旋材料"));
        //list.add(new ItemEdit("height").setName("身高:"));
        list.add(new TextBean("工具参数"));
        list.add(new TextSpinnerBean("工具类型", new String[]{"jite", "jie", "upm2", "own3", "自定义"}, "自定义工具类型"));
        list.add(new TextSpinnerBean("工具型号", new String[]{"jite", "jie", "upm2", "own3", "自定义"}, "自定义工具型号"));
        list.add(new EdittextBean("工具数量", "请输入工具数量"));
        list.add(new TextSpinnerBean("工具覆盖", new String[]{"jite", "jie", "upm2", "own3", "自定义"}, "自定义工具型号"));
        list.add(new EdittextBean("油压面积/mm²", "请输入油压面积"));
        list.add(new EdittextBean("最大工作压力/Bar", "请输入工作压力"));
        list.add(new EdittextBean("最大载荷/Nm", "请输入载荷"));
        list.add(new EdittextBean("负载转换系数", "请输入转换系数"));
        list.add(new TextBean("螺栓信息"));
        list.add(new EdittextBean("屈服强度/Mpa", "请输入屈服强度"));
        list.add(new EdittextBean("屈服强度(T)/Mpa", "请输入屈服强度"));
        list.add(new EdittextBean("公称直径", "请输入公称直径"));
        list.add(new EdittextBean("螺距", "请输入螺距"));
        list.add(new EdittextBean("螺栓小径", "请输入螺栓小径"));
        list.add(new EdittextBean("截面积/mm²", "请输入截面积"));
        list.add(new EdittextBean("螺栓Y.P/Nm", "请输入螺栓Y.P"));
        list.add(new EdittextBean("螺栓Y.P9(T)/Nm", "请输入螺栓Y.P"));
        list.add(new TextBean("紧固信息"));
        list.add(new EdittextBean("T1@BPressure/Nm", "请输入T1@BPressure"));
        list.add(new EdittextBean("T2@Pressure/Nm", "请输入T2@Pressure"));
        list.add(new EdittextBean("T3@Pressure/Nm", "请输入T3@Pressure"));
        list.add(new EdittextBean("T4@Pressure/Nm", "请输入T4@Pressure"));
        list.add(new EdittextBean("T1@A/Nm", "请输入T1@A"));
        list.add(new EdittextBean("T1@B/Nm", "请输入T1@B"));
        list.add(new EdittextBean("A Pressuere/Bar", "请输入A Pressuere"));
        list.add(new EdittextBean("B Pressuere/Bar", "请输入B Pressuere"));
        list.add(new TextSwitchBean("清洗是否达标", true));
        list.add(new TextSwitchBean("润滑是否达标", false));
        adapter.setDataItems(list);


        List<Object> dataList = adapter.getDataList();

    }

    //将数据绑定的视图中，具体代码由DataBinding库自动生成
    private void onBindViewHolder(ViewDataBinding dataBinding, Object data) {
        //还可以写一些其他的绑定业务逻辑......
        dataBinding.setVariable(BR.itemData, data);
    }
}
