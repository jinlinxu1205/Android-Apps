package com.example.jinlin.password;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**This class is the main class. It displays the layout, gets user's input and displays the generated
 * password.
 * */

public class MainActivity extends AppCompatActivity {
    String stringPassword;

    EditText textLength;
    int length;

    EditText textNumbers;
    int numbers;

    EditText textSymbols;
    int symbols;

    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textLength = (EditText) findViewById(R.id.length);
        textNumbers = (EditText) findViewById(R.id.numbers);
        textSymbols = (EditText) findViewById(R.id.symbols);

        password = (TextView) findViewById(R.id.password);
//declare button to have class scope
        final Button refresh = (Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initialize();
                stringPassword = Generator.generator(length, numbers, symbols);
                password.setText(stringPassword);
            }
        });

        final Button copy = (Button) findViewById(R.id.copy);
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("copy", stringPassword);
                clipboard.setPrimaryClip(clip);
            }
        });
    }

    /**This method initializes the length of the password, number of numbers and symbols in the
     * password based on user's input.
     */
    public void initialize(){
        //try catch
        //validate all user input
        length = Integer.parseInt(textLength.getText().toString());
        numbers = Integer.parseInt(textNumbers.getText().toString());
        symbols = Integer.parseInt(textSymbols.getText().toString());
        stringPassword = Generator.generator(length, numbers, symbols);
        password.setText(stringPassword);
    }

}
