package com.example.jinlin.spendingtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

/**This class is the deal activity class. It displays the deal information in the Firebase and provides
 * users with an EditText section to edit the deal information. It will update the deal information once
 * user clicks "done" button and show the new deal to all users.
 */

public class DealActivity extends AppCompatActivity {

    private DatabaseReference mDealReference = MainPageActivity.mDatabase.getReference("deal");
    TextView viewDeal;
    EditText editDeal;
    Button dealDone;
    String newDeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal);

        getSupportActionBar().setTitle(R.string.deal);

        viewDeal = (TextView)findViewById(R.id.viewDeal);
        mDealReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                viewDeal.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        editDeal = (EditText)findViewById(R.id.editDeal);
        dealDone = (Button)findViewById(R.id.dealDone);
        dealDone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                newDeal = editDeal.getText().toString();
                mDealReference.setValue(newDeal);
            }
        });
    }
}
