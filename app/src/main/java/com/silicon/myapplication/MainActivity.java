package com.silicon.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.silicon.myapplication.Test1.Car;
import com.silicon.myapplication.Test1.CarComponent;
import com.silicon.myapplication.Test1.DaggerCarComponent;
import com.silicon.myapplication.Test2.SubEmb;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;

    private Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*   if (!SpeechRecognizer.isRecognitionAvailable(this)) {
            updateResults("\nNo voice recognition support on your device !");
        } else {
            LanguageDetailsReceiver ldr = new LanguageDetailsReceiver(this);
            sendOrderedBroadcast(RecognizerIntent.getVoiceDetailsIntent(this), null, ldr, null,
                    Activity.RESULT_OK, null, null);


        }*/

        // startService(new Intent(this, OpenMicService.class));


        CarComponent component = DaggerCarComponent.create();

        car = component.getCarsss();
        car.drive();

        ///
        SubEmb subEmb =new SubEmb();
        subEmb.haha();
        subEmb.aVoid();
    }

    void updateResults(String s) {
        mTextView = findViewById(R.id.txt);
        mTextView.setText(s);
    }


}
