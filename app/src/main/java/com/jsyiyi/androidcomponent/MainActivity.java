package com.jsyiyi.androidcomponent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jsyiyi.basiclib.BaseActivity;
import com.jsyiyi.service.read.ReadService;
import com.luojilab.component.componentlib.router.Router;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    TextView tv_share;
    TextView tv_read;
    TextView tv_add_share;
    TextView tv_remove_share;
    Fragment fragment;
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_share = findViewById(R.id.tv_share);
        tv_read = findViewById(R.id.tv_read);
        tv_add_share = findViewById(R.id.tv_add_share);
        tv_remove_share = findViewById(R.id.tv_remove_share);

        tv_read.setOnClickListener(this);
        tv_share.setOnClickListener(this);
        tv_add_share.setOnClickListener(this);
        tv_remove_share.setOnClickListener(this);

        showFragment();//加载read组件中的fragment
    }
    private void showFragment(){
        Log.i("test111","showFragment");
        if (fragment != null){
            Log.i("test111","fragment != null");
            ft = getSupportFragmentManager().beginTransaction();
            ft.remove(fragment).commit();
            fragment = null;
        }
        Router router = Router.getInstance();
        if (router.getService(ReadService.class.getSimpleName())!= null){
            Log.i("test111","获取到ReadService");
            ReadService service = (ReadService) router.getService(ReadService.class.getSimpleName());
            fragment = service.getReadFragment();
            ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.tab_content,fragment).commitAllowingStateLoss();
        }else {
            Log.i("test111","未获取到ReadService");
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.tv_share:
                toShare();
                break;
            case R.id.tv_read:
                toRead();
                break;
            case R.id.tv_add_share:
                Log.i("test111","注册share");
                //注意此处的路径为java文件夹下该类的全路径
//                Router.registerComponent("gch.youxin.com.share.applike.ShareAppLike");
                break;
            case R.id.tv_remove_share:
                Log.i("test111","注销share");
                //注意此处的路径为java文件夹下该类的全路径
//                Router.unregisterComponent("gch.youxin.com.share.applike.ShareAppLike");
                break;
        }
    }
    private void toShare(){

    }
    private void toRead(){

    }
}