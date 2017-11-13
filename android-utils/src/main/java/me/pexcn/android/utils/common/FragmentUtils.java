package me.pexcn.android.utils.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by pexcn on 2017-11-10.
 */
@SuppressWarnings({"WeakerAccess", "unused", "SameParameterValue"})
public class FragmentUtils {
    private FragmentUtils() {
    }

    public static String getFragmentTag(Class<? extends Fragment> cls) {
        return cls.getName();
    }

    public static Fragment create(Context context, Class<? extends Fragment> cls) {
        return create(context, cls, null);
    }

    public static Fragment create(Context context, Class<? extends Fragment> cls, @Nullable Bundle args) {
        return Fragment.instantiate(context, cls.getName(), args);
    }

    public static Fragment create(Context context, FragmentManager manager, Class<? extends Fragment> cls) {
        return create(context, manager, cls, null);
    }

    public static Fragment create(Context context, FragmentManager manager,
                                  Class<? extends Fragment> cls, @Nullable Bundle args) {
        String tag = getFragmentTag(cls);
        Fragment fragment = manager.findFragmentByTag(tag);

        if (fragment == null) {
            fragment = create(context, cls, args);
        } else {
            if (fragment.getArguments() == null) {
                if (args != null) {
                    fragment.setArguments(args);
                }
            } else {
                fragment.getArguments().clear();
                if (args != null) {
                    fragment.getArguments().putAll(args);
                }
            }
        }

        return fragment;
    }

    public static void commit(Context context, FragmentManager manager,
                              @IdRes int containerId, Class<? extends Fragment> cls) {
        commit(context, manager, containerId, cls, null, false);
    }

    public static void commit(Context context, FragmentManager manager,
                              @IdRes int containerId, Class<? extends Fragment> cls,
                              @Nullable Bundle args, boolean addToBackStack) {
        String tag = getFragmentTag(cls);
        Fragment fragment = create(context, manager, cls, args);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(containerId, fragment, tag);

        if (addToBackStack) {
            transaction.addToBackStack(fragment.getClass().getName());
        }

        transaction.commit();
    }
}
