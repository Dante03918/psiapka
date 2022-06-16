package com.dante.psiapka.utils;

import android.content.Context;

public class Transformer {

    public static int dpToPx(int dp, Context context){

        float density = context.getResources().getDisplayMetrics().density;

        return Math.round(density * dp);

    }
}
