package com.caoxing.listdialog.listdialog;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    ContentItemListener contentItemListener;
    ListDialog listDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        final List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("我是第" + i + "item");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentAdapter contentAdapter = new ContentAdapter(MainActivity.this, list,contentItemListener);
                listDialog = new ListDialog(MainActivity.this,R.style.MyDialog, "标题",contentAdapter);
//              listDialog.show();
                listDialog.setCancelable(true);
                Window window = listDialog.getWindow();
                window.setGravity(Gravity.BOTTOM);
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams lp = window.getAttributes();
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                lp.dimAmount = 0.8f;
                lp.alpha = 1.0f;
                window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                window.setAttributes(lp);

                listDialog.show();
//                listDialog.setTitle("标题");
//                listDialog.show();


            }
        });
         contentItemListener = new ContentItemListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(),"点击了"+position,Toast.LENGTH_SHORT).show();
                Log.i("onItemClick",position+"");
                 listDialog.dismiss();
            }
        };
    }
}
