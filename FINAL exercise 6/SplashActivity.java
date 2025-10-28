// app/java/com/example/newmarket/SplashActivity.java
package com.example.newmarket;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private TextView welcomeText, toText;
    private ImageView logoView;
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        welcomeText = findViewById(R.id.welcome_text);
        toText = findViewById(R.id.to_text);
        logoView = findViewById(R.id.logo_view);

        // Welcome
        handler.postDelayed(() -> {
            welcomeText.setVisibility(View.VISIBLE);
            welcomeText.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in));
        }, 0);

        // to
        handler.postDelayed(() -> {
            toText.setVisibility(View.VISIBLE);
            toText.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in));
        }, 800);

        // Logo with ROTATE + SCALE
        handler.postDelayed(() -> {
            logoView.setVisibility(View.VISIBLE);
            logoView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_rotate_in));
        }, 1600);

        // Go to Name Input
        handler.postDelayed(() -> {
            startActivity(new Intent(this, NameInputActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }, 3000);
    }
}
