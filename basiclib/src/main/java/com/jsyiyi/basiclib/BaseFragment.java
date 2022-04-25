package com.jsyiyi.basiclib;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class BaseFragment extends Fragment {

    public Context mContext;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
	}


	/**
	 * 检测是否所有的权限都已经授权
	 * @param grantResults
	 * @return
	 * @since 2.5.0
	 *
	 */
	public boolean verifyPermissions(String[] grantResults) {
		for (String result : grantResults) {
			if (ContextCompat.checkSelfPermission(getActivity(), result) != PackageManager.PERMISSION_GRANTED) {
				return false;
			}
		}
		return true;
	}

	/**
	 *  启动应用的设置
	 *
	 * @since 2.5.0
	 *
	 */
	private void startAppSettings() {
		Log.i("test111","无权限，且用户点击了设置");

		Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
		intent.setData(Uri.parse("package:" + "eiyudensetsu.ginga.youxin.com.yinheyingxiong"));
		startActivity(intent);
	}
}
