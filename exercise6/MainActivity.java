// app/java/com/example/newmarket/MainActivity.java
package com.example.newmarket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private LinearLayout vegContainer, fruitContainer;
    private TextView marketTitle;

    private final int[] vegImages = {R.drawable.carrot, R.drawable.broccoli, R.drawable.cabbage};
    private final String[] vegNames = {"Carrot", "Broccoli", "Cabbage"};
    private final int[] fruitImages = {R.drawable.grapes, R.drawable.orange, R.drawable.apple};
    private final String[] fruitNames = {"Grapes", "Orange", "Apple"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String userName = getIntent().getStringExtra("USER_NAME");
        if (userName == null || userName.isEmpty()) userName = "Your";
        marketTitle = findViewById(R.id.market_title);
        marketTitle.setText(userName + "'s Market");

        vegContainer = findViewById(R.id.veg_container);
        fruitContainer = findViewById(R.id.fruit_container);

        populateScroller(vegContainer, vegImages, vegNames);
        populateScroller(fruitContainer, fruitImages, fruitNames);
    }

    private void populateScroller(LinearLayout container, int[] images, String[] names) {
        container.removeAllViews();
        LayoutInflater inflater = getLayoutInflater();
        for (int i = 0; i < images.length; i++) {
            View item = inflater.inflate(R.layout.item_image, container, false);
            ImageView img = item.findViewById(R.id.item_image);
            TextView name = item.findViewById(R.id.item_name);
            img.setImageResource(images[i]);
            name.setText(names[i]);
            container.addView(item);
        }
    }
}