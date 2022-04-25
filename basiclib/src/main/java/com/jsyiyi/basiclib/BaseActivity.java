package com.jsyiyi.basiclib;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.luojilab.component.componentlib.service.AutowiredService;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //依赖注入：如果想使用自动装载功能，需要在Activity的onCreate中调用方法
        AutowiredService.Factory.getSingletonImpl().autowire(this);
    }
}
