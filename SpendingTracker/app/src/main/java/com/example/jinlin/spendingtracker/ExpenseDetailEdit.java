package com.example.jinlin.spendingtracker;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**This class is the ExpenseDetailEdit activity class. It gets the expense information from EditText
 * and updates the information in the Firebase console.
 */

public class ExpenseDetailEdit extends AppCompatActivity {

    EditText itemEdit;
    EditText amountEdit;
    EditText locationEdit;
    EditText dateEdit;
    Button itemDone;
    Button addReceipt;
    ImageView receiptEdit;
    Uri targetUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_detail_edit);

        getSupportActionBar().setTitle(R.string.add_expense);

        itemEdit = (EditText)findViewById(R.id.itemEdit);
        amountEdit = (EditText)findViewById(R.id.amountEdit);
        locationEdit = (EditText)findViewById(R.id.locationEdit);
        dateEdit = (EditText)findViewById(R.id.dateEdit);
        addReceipt = (Button)findViewById(R.id.addReceipt);
        addReceipt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });
        itemDone = (Button)findViewById(R.id.itemDone);
        itemDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeExpense();
                ExpenseDetailEdit.this.finish();
            }
        });

    }

    /**This method displays a view of Gallery and let user choose the picture of the receipt from
     * pictures taken.
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            targetUri = data.getData();
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                receiptEdit = (ImageView)findViewById(R.id.receiptEdit);
                receiptEdit.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    /**This method initializes the expense object once user enters all information needed to create
     * an expense. It updates the information in the Firebase console.
     */
    public void initializeExpense(){
        try {
            String item = itemEdit.getText().toString();
            double amount = Double.parseDouble(amountEdit.getText().toString());
            String location = locationEdit.getText().toString();
            String date = dateEdit.getText().toString();
            String imagePath = targetUri.toString();
            Expense expense = new Expense(item,amount,location,date,imagePath);

            if (MainPageActivity.expensesList == null) {
                MainPageActivity.expensesList = new ArrayList<Expense>(Arrays.asList(expense));
            }
            else {
                MainPageActivity.expensesList.add(expense);
            }

            MainPageActivity.mUserReference.child("/expenseList").setValue(MainPageActivity.expensesList);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
