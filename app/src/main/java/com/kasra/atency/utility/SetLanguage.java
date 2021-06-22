package com.kasra.atency.utility;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;

import java.util.Locale;

public class SetLanguage {

    private SetLanguage(){

    }

    public static void updateLanguage(Context context, String language) {
        Locale locale;
        if (language.contains("-")) {
            locale = new Locale(language.split("-")[0], language.split("-")[1]);
        } else {
            locale = new Locale(language.toLowerCase());
        }
        Locale.setDefault(locale);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            updateResourcesLocale(context, locale);
        } else {
            updateResourcesLocaleLegacy(context, locale);
        }
    }

    @TargetApi(Build.VERSION_CODES.N)
    private static void updateResourcesLocale(Context context, Locale locale) {
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLayoutDirection(locale);
        configuration.setLocale(locale);
        context.createConfigurationContext(configuration);
        Resources res = context.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        res.updateConfiguration(configuration, dm);
    }

    private static void updateResourcesLocaleLegacy(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        configuration.setLayoutDirection(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

}
