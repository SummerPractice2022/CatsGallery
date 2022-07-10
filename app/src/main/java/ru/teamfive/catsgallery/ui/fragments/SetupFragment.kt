package ru.teamfive.catsgallery.ui.fragments

import android.os.Bundle
import android.widget.Toast
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import com.teamfive.catsgallery.R
import ru.teamfive.catsgallery.ui.activities.MainActivity

class SetupFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)

        findPreference<ListPreference>("theme")?.setOnPreferenceChangeListener { _, newValue ->
            if (newValue is String) MainActivity.setTheme(newValue)
            true
        }

        findPreference<EditTextPreference>("api-key")?.setOnPreferenceChangeListener { _, _ ->
            val context = requireContext()
            Toast.makeText(context, context.getString(R.string.restart_app), Toast.LENGTH_LONG)
                .show()

            return@setOnPreferenceChangeListener true
        }
    }
}