package com.example.jinlin.spendingtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

/**This class is the FullScreenImageActivity class. It gets an intent with imagePath from ExpenseDetail
 * class and shows the picture of the receipt in full screen.
 */
public class FullScreenImage extends AppCompatActivity {

    private ImageView fullScreenImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);

        getSupportActionBar().setTitle(R.string.receipt);

        fullScreenImage = (ImageView)findViewById(R.id.fullScreenImage);
        Intent intent = getIntent();
        String imagePath = intent.getStringExtra("ImagePath");
        Picasso.with(fullScreenImage.getContext()).load(imagePath).into(fullScreenImage);
    }
}
