package com.example.wang.huntergod;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class ChooseActivity extends AppCompatActivity {

    private TextSwitcher mTextSwitcher;
    private ImageSwitcher mImageSwitcher;
    Button bt1;
    private int mPosition = 0;

    private static final String[] TEXTS = { "灰灰白白貓", "皮卡貓", "稀有品種" };
    private int[] imgRes=new int[]{R.drawable.cat1,R.drawable.cat2,R.drawable.cat3,R.drawable.cat4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        //關閉狀態列
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        mImageSwitcher= (ImageSwitcher) findViewById(R.id.imageSwitcher);
        mTextSwitcher= (TextSwitcher) findViewById(R.id.textSwitcher);
        bt1= (Button) findViewById(R.id.button);

        mTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(ChooseActivity.this);
                textView.setTextSize(30);
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });

        mTextSwitcher.setInAnimation(this, android.R.anim.fade_in);
        mTextSwitcher.setOutAnimation(this, android.R.anim.fade_out);

        mImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(ChooseActivity.this);
                return imageView;
            }
        });
        mImageSwitcher.setInAnimation(this, android.R.anim.slide_in_left);
        mImageSwitcher.setOutAnimation(this, android.R.anim.slide_out_right);

        onSwitch(null);
        preSwitch(null);


        bt1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPosition==0) {
                    Intent intent = new Intent();
                    intent.setClass(ChooseActivity.this, Choose2Activity.class);
                    startActivity(intent);
                    ChooseActivity.this.finish();
                }else if(mPosition==1){
                    Intent intent = new Intent();
                    intent.setClass(ChooseActivity.this, Choose3Activity.class);
                    startActivity(intent);
                    ChooseActivity.this.finish();
                }else if (mPosition==2){
                    Intent intent = new Intent();
                    intent.setClass(ChooseActivity.this, Choose4Activity.class);
                    startActivity(intent);
                    ChooseActivity.this.finish();
                }

            }
        });



    }
    public void onSwitch(View view) {
        mTextSwitcher.setText(TEXTS[mPosition]);
        mImageSwitcher.setBackgroundResource(imgRes[mPosition]);
        mPosition = (mPosition + 1) % TEXTS.length;
    }
    public void preSwitch(View view) {
        mTextSwitcher.setText(TEXTS[mPosition]);
        mImageSwitcher.setBackgroundResource(imgRes[mPosition]);
        mPosition = (mPosition +2) % TEXTS.length;
    }

}

