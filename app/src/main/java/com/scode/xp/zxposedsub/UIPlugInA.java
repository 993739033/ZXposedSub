package com.scode.xp.zxposedsub;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_LayoutInflated;

/**
 * Created by ZWX on 2019/2/14.
 */
//更改了最日语两个模块中的按钮位置  习惯用左手
public class UIPlugInA implements IXposedHookInitPackageResources {
    String tag = "View";

    @Override
    public void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam initPackageResourcesParam) throws Throwable {
        if (initPackageResourcesParam.packageName.equals("com.voltmemo.xz_cidao")) {
            XposedBridge.log("APP Info:" + initPackageResourcesParam.packageName);
            initPackageResourcesParam.res.hookLayout(initPackageResourcesParam.packageName,
                    "layout", "activity_complex_challenge", new XC_LayoutInflated() {
                        @Override
                        public void handleLayoutInflated(LayoutInflatedParam layoutInflatedParam) throws Throwable {
//                    XposedBridge.log(layoutInflatedParam.view.toString());
//                    XposedBridge.log(((ViewGroup) layoutInflatedParam.view).getChildAt(0).toString());
////                    ((ViewGroup) layoutInflatedParam.view).getChildAt(0).setBackgroundResource(R.drawable.meizi);//更改登入界面的背景图
//                    View iv = ((ViewGroup) ((ViewGroup) layoutInflatedParam.view).getChildAt(0)).getChildAt(0);
//                    XposedBridge.log("view ID:"+iv.getId());
//                    if (iv instanceof ImageView) {
////                        iv.setBackgroundResource(R.drawable.meizi);
//                        XposedBridge.log("设置iv 背景图片成功");
//                    }
////                    layoutInflatedParam.view.findViewById(R.id.img_icon).setBackgroundResource(R.drawable.meizi);
//                    XposedBridge.log("qifeng login 背景更换成功");
                            XposedBridge.log(layoutInflatedParam.view.toString());
                            ShowAllViews(((ViewGroup) layoutInflatedParam.view).getChildAt(0));
                            ViewGroup group = ((ViewGroup) ((ViewGroup) layoutInflatedParam.view).getChildAt(0));
                            View view = group.getChildAt(group.getChildCount() - 2);//获取FloatButton
                            XposedBridge.log("viewClass>>>>>" + view.getClass().toString());
                            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
                            params.getRules()[RelativeLayout.ALIGN_PARENT_RIGHT] = 0;//将原有属性设置为0  设置的LEFT才可使用
                            params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                            params.leftMargin = 112;//56dp
                            view.setLayoutParams(params);
                            layoutInflatedParam.view.requestLayout();
                            XposedBridge.log("闯关设置成功1");
                        }
                    });

            initPackageResourcesParam.res.hookLayout(initPackageResourcesParam.packageName,
                    "layout", "activity_recite_u2", new XC_LayoutInflated() {
                        @Override
                        public void handleLayoutInflated(LayoutInflatedParam layoutInflatedParam) throws Throwable {
//                    XposedBridge.log(layoutInflatedParam.view.toString());
//                    XposedBridge.log(((ViewGroup) layoutInflatedParam.view).getChildAt(0).toString());
////                    ((ViewGroup) layoutInflatedParam.view).getChildAt(0).setBackgroundResource(R.drawable.meizi);//更改登入界面的背景图
//                    View iv = ((ViewGroup) ((ViewGroup) layoutInflatedParam.view).getChildAt(0)).getChildAt(0);
//                    XposedBridge.log("view ID:"+iv.getId());
//                    if (iv instanceof ImageView) {
////                        iv.setBackgroundResource(R.drawable.meizi);
//                        XposedBridge.log("设置iv 背景图片成功");
//                    }
////                    layoutInflatedParam.view.findViewById(R.id.img_icon).setBackgroundResource(R.drawable.meizi);
//                    XposedBridge.log("qifeng login 背景更换成功");
                            XposedBridge.log(layoutInflatedParam.view.toString());
                            ShowAllViews(((ViewGroup) layoutInflatedParam.view).getChildAt(0));
                            ViewGroup group = ((ViewGroup) ((ViewGroup) layoutInflatedParam.view).getChildAt(0));
                            View view = group.getChildAt(group.getChildCount() - 2);//获取FloatButton
                            XposedBridge.log("viewClass>>>>>" + view.getClass().toString());
                            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
                            params.getRules()[RelativeLayout.ALIGN_PARENT_RIGHT] = 0;//将原有属性设置为0  设置的LEFT才可使用
                            params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                            params.leftMargin = 112;//56dp
                            view.setLayoutParams(params);
                            layoutInflatedParam.view.requestLayout();
                            XposedBridge.log("初记设置成功2");
                        }
                    });

        }
    }


    //打印所有view
    public void ShowAllViews(View view) {
        if (view == null) {
            return;
        }
//        XposedBridge.log(tag+">>>>>>"+view.getClass().toString()+">>>>"+(view instanceof ViewGroup)+">>>>>"+view.getId()+"\n");
//        if (view instanceof ViewGroup) {
//            int total = ((ViewGroup) view).getChildCount();
//            for (int index=0;index<total;index++) {
//                ShowAllViews(((ViewGroup) view).getChildAt(index));
//            }
//        }
        if (view instanceof ViewGroup) {
            int total = ((ViewGroup) view).getChildCount();
            XposedBridge.log(tag + "count>>>" + total + "\n");
            for (int index = 0; index < total; index++) {
                View view1 = ((ViewGroup) view).getChildAt(index);
                XposedBridge.log(tag + ">>>>>>" + view1.getClass().toString() + ">>>>" + (view1 instanceof ViewGroup) + ">>>>>" + view1.getId() + "\n");
            }
        }

    }


}
