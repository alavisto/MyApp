package com.example.alen_sl.myapplication;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.widget.Toast;


public class SettingsActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        Preference version_name = findPreference("version_name");
        version_name.setTitle("version" + BuildConfig.VERSION_NAME);
    }


    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        switch(preference.getKey()){
            case "wifi":
                Toast.makeText(
                        this,
                        preference.getTitle() + " clicked "+ ((CheckBoxPreference) preference).isChecked(),
                        Toast.LENGTH_SHORT
                ).show();
                break;
            default:
                break;
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }
}

