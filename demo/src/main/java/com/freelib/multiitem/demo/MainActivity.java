package com.freelib.multiitem.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.freelib.multiitem.adapter.BaseItemAdapter;
import com.freelib.multiitem.adapter.holder.BaseViewHolder;
import com.freelib.multiitem.demo.bean.MainBean;
import com.freelib.multiitem.demo.viewholder.TextViewManager;
import com.freelib.multiitem.listener.OnItemClickListener;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

public class MainActivity extends AppCompatActivity {
    protected RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recycler);
        recyclerView= findViewById(R.id.recyclerView);
        initViews();
    }

    protected void initViews() {
        setTitle(R.string.main_title);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BaseItemAdapter adapter = new BaseItemAdapter();
        //为TextBean数据源注册TextViewManager管理类
        adapter.register(MainBean.class, new TextViewManager());
        recyclerView.setAdapter(adapter);
        adapter.addDataItem(new MainBean(getString(R.string.item_click_title), new MainBean.OnMainItemClickListener() {
            @Override
            public void onClick() {
               Intent intent= ItemClickActivity.startActivity(getApplication());
               startActivity(intent);
            }
        }));
        adapter.addDataItem(new MainBean(getString(R.string.multi_item_title), new MainBean.OnMainItemClickListener() {
            @Override
            public void onClick() {
               // () -> MultiItemActivity.startActivity(this))
            }
        }));
        adapter.addDataItem(new MainBean(getString(R.string.chat_title),
                () -> ChatActivity.startActivity(this)));
        adapter.addDataItem(new MainBean(getString(R.string.head_foot_title),
                () -> HeadFootActivity.startActivity(this)));
        adapter.addDataItem(new MainBean(getString(R.string.head_foot_grid_title),
                () -> FullSpanGridActivity.startActivity(this)));
        adapter.addDataItem(new MainBean(getString(R.string.load_more_title),
                () -> LoadMoreActivity.startActivity(this)));
        adapter.addDataItem(new MainBean(getString(R.string.panel_title),
                () -> PanelActivity.startActivity(this)));
        adapter.addDataItem(new MainBean(getString(R.string.data_bind_title),
                new MainBean.OnMainItemClickListener() {
                    @Override
                    public void onClick() {
                      //  () -> DataBindActivity.startActivity(this))
                        Intent intent=DataBindActivity.startActivity(getApplication());
                        startActivity(intent);
                    }
                }));
        adapter.addDataItem(new MainBean(getString(R.string.input_title), new MainBean.OnMainItemClickListener() {
            @Override
            public void onClick() {
                Intent intent=InputActivity.startActivity(getApplication());
                startActivity(intent);
            }
        }));
        adapter.addDataItem(new MainBean(getString(R.string.user_info_title),
                () -> UserInfoActivity.startActivity(this)));
        adapter.addDataItem(new MainBean(getString(R.string.empty_error_title),
                () -> EmptyAndErrorActivity.startActivity(this)));
        adapter.addDataItem(new MainBean(getString(R.string.animation_title),
                () -> AnimationActivity.startActivity(this)));

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseViewHolder viewHolder) {
                //通过viewHolder获取需要的数据
                if (viewHolder.getItemData() instanceof MainBean) {
                    ((MainBean) viewHolder.getItemData()).onItemClick();
                }
            }
        });

    }
}
