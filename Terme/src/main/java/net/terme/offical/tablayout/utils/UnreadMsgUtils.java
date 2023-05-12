package net.terme.offical.tablayout.utils;


import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

import net.terme.offical.TermeTextView;


public class UnreadMsgUtils {
    public static void show(TermeTextView termeTextView, int num) {
        if (termeTextView == null) {
            return;
        }
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) termeTextView.getLayoutParams();
        DisplayMetrics dm = termeTextView.getResources().getDisplayMetrics();
        termeTextView.setVisibility(View.VISIBLE);
        if (num <= 0) {
            termeTextView.setStrokeWidth(0);
            termeTextView.setText("");

            lp.width = (int) (5 * dm.density);
            lp.height = (int) (5 * dm.density);
            termeTextView.setLayoutParams(lp);
        } else {
            lp.height = (int) (18 * dm.density);
            if (num > 0 && num < 10) {//圆
                lp.width = (int) (18 * dm.density);
                termeTextView.setText(num + "");
            } else if (num > 9 && num < 100) {
                lp.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
                termeTextView.setPadding((int) (6 * dm.density), 0, (int) (6 * dm.density), 0);
                termeTextView.setText(num + "");
            } else {
                lp.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
                termeTextView.setPadding((int) (6 * dm.density), 0, (int) (6 * dm.density), 0);
                termeTextView.setText("99+");
            }
            termeTextView.setLayoutParams(lp);
        }
    }

    public static void setSize(TermeTextView rtv, int size) {
        if (rtv == null) {
            return;
        }
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) rtv.getLayoutParams();
        lp.width = size;
        lp.height = size;
        rtv.setLayoutParams(lp);
    }
}
