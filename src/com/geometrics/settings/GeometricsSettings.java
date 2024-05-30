package com.geometrics.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.card.MaterialCardView;
import com.android.internal.logging.nano.MetricsProto;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.geometrics.settings.fragments.LockScreenSettings;
import com.geometrics.settings.fragments.MiscSettings;
import com.geometrics.settings.fragments.NotificationsPanelSettings;
import com.geometrics.settings.fragments.StatusBarSettings;
import com.geometrics.settings.fragments.ThemeSettings;

public class GeometricsSettings extends SettingsPreferenceFragment implements View.OnClickListener {

    private ImageView mStatusbarSettingsCard;
    private MaterialCardView mLockScreenSettingsCard;
    private ImageView mNotificationsPanelSettingsCard;
    private ImageView mThemeSettingsCard;
    private ImageView mMiscSettingsCard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.geometrics_settings, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mStatusbarSettingsCard = view.findViewById(R.id.statusbarsettings_card);
        mStatusbarSettingsCard.setOnClickListener(this);

        mLockScreenSettingsCard = view.findViewById(R.id.lockscreensettings_card);
        mLockScreenSettingsCard.setOnClickListener(this);

        mNotificationsPanelSettingsCard = view.findViewById(R.id.notificationspanelsettings_card);
        mNotificationsPanelSettingsCard.setOnClickListener(this);

        mThemeSettingsCard = view.findViewById(R.id.themesettings_card);
        mThemeSettingsCard.setOnClickListener(this);

        mMiscSettingsCard = view.findViewById(R.id.miscsettings_card);
        mMiscSettingsCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        if (id == R.id.statusbarsettings_card) {
            transaction.replace(this.getId(), new StatusBarSettings());
        } else if (id == R.id.lockscreensettings_card) {
            transaction.replace(this.getId(), new LockScreenSettings());
        } else if (id == R.id.notificationspanelsettings_card) {
            transaction.replace(this.getId(), new NotificationsPanelSettings());
        } else if (id == R.id.themesettings_card) {
            transaction.replace(this.getId(), new ThemeSettings());
        } else if (id == R.id.miscsettings_card) {
            transaction.replace(this.getId(), new MiscSettings());
        }

        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.GEOMETRICS;
    }
}
