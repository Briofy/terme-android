package net.lynqfy.offical.tablayout.utils;


import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

import net.lynqfy.offical.LyTextView;


public class UnreadMsgUtils {
    public static void show(LyTextView lyTextView, int num) {
        if (lyTextView == null) {
            return;
        }
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) lyTextView.getLayoutParams();
        DisplayMetrics dm = lyTextView.getResources().getDisplayMetrics();
        lyTextView.setVisibility(View.VISIBLE);
        if (num <= 0) {
            lyTextView.setStrokeWidth(0);
            lyTextView.setText("");

            lp.width = (int) (5 * dm.density);
            lp.height = (int) (5 * dm.density);
            lyTextView.setLayoutParams(lp);
        } else {
            lp.height = (int) (18 * dm.density);
            if (num > 0 && num < 10) {//圆
                lp.width = (int) (18 * dm.density);
                lyTextView.setText(num + "");
            } else if (num > 9 && num < 100) {
                lp.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
                lyTextView.setPadding((int) (6 * dm.density), 0, (int) (6 * dm.density), 0);
                lyTextView.setText(num + "");
            } else {
                lp.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
                lyTextView.setPadding((int) (6 * dm.density), 0, (int) (6 * dm.density), 0);
                lyTextView.setText("99+");
            }
            lyTextView.setLayoutParams(lp);
        }
    }

    public static void setSize(LyTextView rtv, int size) {
        if (rtv == null) {
            return;
        }
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) rtv.getLayoutParams();
        lp.width = size;
        lp.height = size;
        rtv.setLayoutParams(lp);
    }
}
