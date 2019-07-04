package com.silicon.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import java.util.ArrayList;
import java.util.List;

public class LanguageDetailsReceiver extends BroadcastReceiver {
    List<String> mLanguages;
    MainActivity mSSL;

    public LanguageDetailsReceiver(MainActivity ssl) {
        mSSL = ssl;
        mLanguages= new ArrayList<>();
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Bundle extras = getResultExtras(true);
        mLanguages = extras.getStringArrayList
                (RecognizerIntent.EXTRA_SUPPORTED_LANGUAGES);
        if (mLanguages == null) {
            mSSL.updateResults("No voice data found.");
        } else {
            String s = "\nList of language voice data:\n";
            for (int i = 0; i < mLanguages.size(); i++) {
                s += (mLanguages.get(i) + ", ");
            }
            s += "\n";
            mSSL.updateResults(s);
        }
    }
}