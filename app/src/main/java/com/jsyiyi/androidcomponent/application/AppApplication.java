package com.jsyiyi.androidcomponent.application;

import android.util.Log;

import com.jsyiyi.basiclib.BaseApplication;
import com.luojilab.component.componentlib.log.ILogger;
import com.luojilab.component.componentlib.router.Router;
import com.luojilab.component.componentlib.router.ui.UIRouter;

import org.github.jimu.msg.EventManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import osp.leobert.android.maat.JOB;
import osp.leobert.android.maat.Maat;


/**
 * Created by mrzhang on 2017/6/15.
 */

public class AppApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("test111","app 的AppApplication");
        ILogger.logger.setDefaultTag("JIMU");
        UIRouter.enableDebug();

        EventManager.init(this);

        UIRouter.getInstance().registerUI("app");

        //如果read和share项目中的isRegisterCompoAuto为false，则需要通过反射加载组件
//        Router.registerComponent("gch.youxin.com.read.applike.ReadAppLike");
//        Router.registerComponent("gch.youxin.com.share.applike.ShareAppLike");
    }
}
