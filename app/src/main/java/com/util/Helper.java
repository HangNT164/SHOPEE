package com.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import com.google.gson.Gson;
import com.model.Account;

import java.util.List;
import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;

public class Helper {
    public static void saveObjectToSharedPreference(Context context, String preferenceFileName, String serializedObjectKey, Object object) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceFileName, MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        final Gson gson = new Gson();
        String serializedObject = gson.toJson(object);
        sharedPreferencesEditor.putString(serializedObjectKey, serializedObject);
        sharedPreferencesEditor.apply();
    }

    public static <GenericClass> GenericClass getSavedObjectFromPreference(Context context, String preferenceFileName, String preferenceKey, Class<GenericClass> classType) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceFileName, MODE_PRIVATE);
        if (sharedPreferences.contains(preferenceKey)) {
            final Gson gson = new Gson();
            return gson.fromJson(sharedPreferences.getString(preferenceKey, ""), classType);
        }
        return null;
    }

    public static void loadLocale(Context context, String preferenceFileName, String serializedObjectKey) {
        SharedPreferences prefs = context.getSharedPreferences(preferenceFileName, Activity.MODE_PRIVATE);
        String language = prefs.getString(serializedObjectKey, "");
        setLocale(context, preferenceFileName, serializedObjectKey, language);
    }

    public static void setLocale(Context context, String preferenceFileName, String serializedObjectKey, String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
        // save data to shared prences
        SharedPreferences.Editor editor = context.getSharedPreferences(preferenceFileName, MODE_PRIVATE).edit();
        editor.putString(serializedObjectKey, lang);
        editor.apply();
    }

    public static boolean isCheckUnique(List<Account> lists, String mobile) {
        for (Account a : lists) {
            if (a.getMobile().equalsIgnoreCase(mobile)) {
                return false;
            }
        }
        return true;
    }
}
