package com.zhoujian.butterknife.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhoujian.butterknife.R;

import java.util.List;

import butterknife.BindArray;
import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import butterknife.Unbinder;

public class MainActivity extends Activity
{

    private Unbinder mBind;

    @BindView(R.id.button1)
    Button mButton1;
    @BindView(R.id.button2)
    Button mButton2;
    @BindView(R.id.text1)
    TextView mText1;
    @BindView(R.id.text2)
    TextView mText2;
    @BindView(R.id.img)
    ImageView mImg;


    @BindString(R.string.app_name)
    String name;

    @BindColor(R.color.textColor)
    int red;

    @BindBitmap(R.mipmap.my)
    Bitmap mBitmap;


    @BindViews({R.id.text1,R.id.text2})
    List<TextView> mTextViews;


    @BindArray(R.array.student)
    String [] students;


    @OnClick(R.id.button1)
    public void method1()
    {
        startActivity(new Intent(MainActivity.this,ThiredActivity.class));

    }

    @OnLongClick(R.id.button2)
    public boolean method2()
    {
        Toast.makeText(this, "按钮2被长按了", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBind = ButterKnife.bind(MainActivity.this);


        mText1.setText(name);
        mText2.setTextColor(red);
        mImg.setImageBitmap(mBitmap);

        mTextViews.get(0).setText("测试一");
        mTextViews.get(1).setText("测试二");

        for (int i = 0; i < students.length; i++)
        {
            mTextViews.get(1).setText(students[i]);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBind.unbind();
    }
}
