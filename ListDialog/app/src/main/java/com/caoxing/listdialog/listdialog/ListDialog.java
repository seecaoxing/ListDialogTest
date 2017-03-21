package com.caoxing.listdialog.listdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by caoxing on 2017/3/16.
 */

public class ListDialog extends AlertDialog{

    private List<String> list;

    private String mTitle;
    private Context context;
    private TextView textview;
    private RecyclerView recyclerView;
    private ContentAdapter contentAdapter;
    private  ContentItemListener contentItemListener;

    public ListDialog(Context context, List<String> list) {
        super(context, R.style.MyDialog);
        this.list = list;
        this.context = context;
    }

    public ListDialog(Context context, int themeResId,String title, List<String> list) {
        super(context, themeResId);
        this.list = list;
        this.context = context;
        this.mTitle = title;

    }
    public ListDialog(Context context, int themeResId, String title, List<String> list, ContentItemListener contentItemListener) {
        super(context, themeResId);
        this.list = list;
        this.context = context;
        this.mTitle = title;
        this.contentItemListener = contentItemListener;

    }

    public ListDialog(Context context, int themeResId, String title, List<String> list, ContentItemListener contentItemListener,ContentAdapter contentAdapter) {
        super(context, themeResId);
        this.list = list;
        this.context = context;
        this.mTitle = title;
        this.contentItemListener = contentItemListener;
        this.contentAdapter  = contentAdapter;

    }
    public ListDialog(Context context, int themeResId, List<String> list) {
        super(context, themeResId);
        this.list = list;
        this.context = context;
    }
    public ListDialog(Context context, int themeResId,  String title,ContentAdapter contentAdapter) {
        super(context, themeResId);
        this.context = context;
        this.contentAdapter = contentAdapter;
    }

    public ListDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_list);
        //按空白处不能取消动画
//        setCanceledOnTouchOutside(false);

        //初始化界面控件
        initView();
        //初始化界面数据
        initData();
        //初始化界面控件的事件
        initEvent();
    }

    public void initView() {
        textview = (TextView) findViewById(R.id.dialog_title);
        recyclerView = (RecyclerView) findViewById(R.id.dialog_content);
    }

    public void setTitle(String title) {
        this.mTitle = title;
        textview.setText(title);
    }


    public void setList(List<String> list) {
        this.list = list;
    }
    public void setAdapter(ContentAdapter contentAdapter){
        this.contentAdapter = contentAdapter;

    }

    public void initData() {
        textview.setText(mTitle);

    }

    public void initEvent() {
        LinearLayoutManager lm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(lm);
     //    contentAdapter = new ContentAdapter(context, list,contentItemListener);
        recyclerView.setAdapter(contentAdapter);
    }
}
