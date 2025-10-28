// app/java/com/example/newmarket/NameInputActivity.java
package com.example.newmarket;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NameInputActivity extends AppCompatActivity {
    private EditText nameInput;
    private Button goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_input);

        nameInput = findViewById(R.id.name_input);
        goButton = findViewById(R.id.go_button);

        goButton.setEnabled(false);
        nameInput.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) {
                goButton.setEnabled(s.toString().trim().length() > 0);
            }
        });

        goButton.setOnClickListener(v -> {
            String userName = nameInput.getText().toString().trim();
            if (!userName.isEmpty()) {
                Intent intent = new Intent(this, WelcomeSplashActivity.class);
                intent.putExtra("USER_NAME", userName);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
    }
}
