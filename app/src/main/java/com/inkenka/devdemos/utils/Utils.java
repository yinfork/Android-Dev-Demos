package com.inkenka.devdemos.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by yinjianhua on 2017/9/27.
 */

public class Utils {
    public static int covertDp2Px(Context context, float dp) {
        Resources r = context.getResources();
        float convertedDp = dp;

        if (r != null) {
            convertedDp = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
        }

        return (int)convertedDp;
    }
}
