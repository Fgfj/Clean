package com.xacheliangroup.netline.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.xacheliangroup.netline.R;

/**
 * author:yz
 * data: 2019/2/27,14:43
 */
public class DialogUtils {
    /**
     * 根据view生成dialog
     * @param activity
     * @param context
     * @param view
     * @param gravity
     * @param width
     * @return
     */
    public static Dialog getDiyDialog(Activity activity, Context context, View view, int gravity, float width){
        Dialog dialog=new Dialog(context, R.style.DialogStyle);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        window.setGravity(gravity);
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        WindowManager manager = activity.getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = (int) (displayMetrics.widthPixels*width);
        window.setAttributes(layoutParams);
        return dialog;
    }
}
