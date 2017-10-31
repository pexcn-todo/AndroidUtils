package me.pexcn.android.utils.common;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

import me.pexcn.android.utils.Utils;

/**
 * Created by pexcn on 2017-10-31.
 */
public class ResourcesUtils {
    private ResourcesUtils() {
    }

    public static Resources getLocalizedResources(Locale locale) {
        Context context = Utils.getContext();
        Configuration conf = new Configuration(context.getResources().getConfiguration());
        conf.setLocale(locale);
        return context.createConfigurationContext(conf).getResources();
    }
}
