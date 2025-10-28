// app/java/com/example/newmarket/WelcomeSplashActivity.java
package com.example.newmarket;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeSplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_splash);

        String userName = getIntent().getStringExtra("USER_NAME");
        TextView tv = findViewById(R.id.welcome_name_text);
        tv.setText("Welcome\n" + userName + "!");

        tv.setAlpha(0f);
        tv.setScaleX(0.5f);
        tv.setScaleY(0.5f);
        tv.animate().alpha(1f).scaleX(1f).scaleY(1f).setDuration(800).start();

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("USER_NAME", userName);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }, 1500);
    }
}
