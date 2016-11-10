package com.zy.app.mall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.zy.common.BaseActivity;

/**
 * Created by Robin on 2016/4/14.
 */
public class MainActivity extends BaseActivity {

    private boolean b = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button = new Button(this);
        button.setText("xxxx");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a(false);
            }
        });
        this.addContentView(button, new FrameLayout.LayoutParams(-1,-1));
    }

    protected final synchronized void a(boolean paramBoolean) {
        if (!this.b) {
            this.b = true;
            MainFrameActivity.a = true;
            startActivity(new Intent(this, MainFrameActivity.class));
            this.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);   //2130968647, 2130968648
            finish();
        }
        return;

    }
}
