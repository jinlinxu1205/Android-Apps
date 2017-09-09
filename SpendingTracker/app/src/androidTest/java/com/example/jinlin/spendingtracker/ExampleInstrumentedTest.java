package com.example.jinlin.spendingtracker;

import android.support.test.runner.AndroidJUnit4;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    //make countdownlatch for each test
    //assert on the countdownlatch
    final private CountDownLatch signal1 = new CountDownLatch(1);
    final private CountDownLatch signal2 = new CountDownLatch(1);
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mUserReference = mDatabase.getReference("users");
    private int numChildren;

    @Before
    public void writeUser() {
        String imagePath = "/Users/Jinlin/Documents/SpendingTracker/app/src/main/res/drawable";
        Expense expense = new Expense("book", 4, "book store", "april", imagePath);
        ArrayList<Expense> expenseList = new ArrayList<>();
        expenseList.add(expense);
        mUserReference.child("PalyZ8hNasMYhxv3qIGORX1jxyt2/expenseList").setValue(expenseList);
    }
//each test should run as independent test
    @Test
    public void writeTest() throws Exception{
        numChildren = 0;
        mUserReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                numChildren ++;
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        signal1.await(1, TimeUnit.SECONDS);
        assertEquals(0,numChildren);
    }

    @Test
    public void readTest() throws Exception{
        mUserReference.addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                assertEquals("april", dataSnapshot.child("PalyZ8hNasMYhxv3qIGORX1jxyt2/expenseList/0/date").getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        signal2.await(1, TimeUnit.SECONDS);
    }
}
