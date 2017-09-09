package com.example.jinlin.spendingtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

/**This class is the ExpenseDetailActivity. It displays the details of an expense and can display
 * the picture of the receipt in full screen or normal size according to user's click. It gets a json
 * object which contains information of an expense from the MainPageActivity .
 */

public class ExpenseDetailActivity extends AppCompatActivity {

    private TextView mitemView;
    private TextView mlocationView;
    private TextView mdateView;
    private ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_detail);

        getSupportActionBar().setTitle(R.string.expense);

        mitemView = (TextView) findViewById(R.id.itemView);
        mlocationView = (TextView) findViewById(R.id.locationView);
        mdateView = (TextView) findViewById(R.id.dateView);
        mImageView = (ImageView) findViewById(R.id.receiptView);

        Intent intent = getIntent();
        String json = intent.getStringExtra("expense");
        Gson gson = new Gson();
        final Expense expense = gson.fromJson(json, Expense.class);
        mImageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(),FullScreenImage.class);
                String imagePath = expense.getImagePath();
                intent.putExtra("ImagePath", imagePath);
                startActivity(intent);
            }
        });

        mitemView.setText(expense.getItem());
        mlocationView.setText(expense.getLocation());
        mdateView.setText(expense.getDate());
        Picasso.with(mImageView.getContext()).load(expense.getImagePath()).into(mImageView);
    }
}
