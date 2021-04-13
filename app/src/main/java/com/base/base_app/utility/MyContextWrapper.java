package com.base.base_app.utility;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import java.util.Locale;

public class MyContextWrapper extends android.content.ContextWrapper {

    public MyContextWrapper(Context base) {
        super(base);
    }

    public static MyContextWrapper wrap(Context context, Locale newLocale) {

        try {
            Resources res = context.getResources();
            Configuration configuration = res.getConfiguration();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Locale.setDefault(newLocale);
                configuration.setLocale(newLocale);
                configuration.setLayoutDirection(newLocale);
                context = context.createConfigurationContext(configuration);

            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                configuration.setLocale(newLocale);
                context = context.createConfigurationContext(configuration);

            } else {
                configuration.locale = newLocale;
                res.updateConfiguration(configuration, res.getDisplayMetrics());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MyContextWrapper(context);
    }
}
