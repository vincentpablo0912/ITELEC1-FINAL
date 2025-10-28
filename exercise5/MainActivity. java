package org.geeksforgeeks.demo;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    
    private final int[] images = {R.drawable.grape, R.drawable.orange};
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageSwitcher imgsw = findViewById(R.id.imageSwitcher);

        imgsw.setFactory(() -> {
            ImageView imgView = new ImageView(getApplicationContext());
            imgView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgView.setPadding(8, 8, 8, 8);
            imgView.setContentDescription("Fruit image");
            return imgView;
        });

        imgsw.setImageResource(images[position]);

        imgsw.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
        imgsw.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));

        Button previousbtn = findViewById(R.id.prev);
        Button nextbtn = findViewById(R.id.next);

        previousbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position>0)
                    position--;
                else if(position<0)
                    position = 0;
                imgsw.setImageResource(images[position]);
            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position<images.length)
                    position++;
                if(position>=images.length)
                    position = images.length-1;
                imgsw.setImageResource(images[position]);
            }
        });
    }
}
