package com.example.jamesn.vibrationtesting;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;


public class MainActivity extends ActionBarActivity {
    private EditText pattern;
    private TextView patternTextView;
    private String arrayString;
    private long[] vibrationArray;
    private TextView arrayTextView;
    private String temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pattern = (EditText) findViewById(R.id.pattern);
        patternTextView= (TextView) findViewById(R.id.patternTextBox);
        arrayTextView= (TextView) findViewById(R.id.arrayTextBox);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void Legendary(View view) {
        Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrationArray.length>0){
            v.vibrate(vibrationArray,0);
        }
    }

    public void commit(View view) {
        arrayString = String.valueOf(pattern.getText());
        temp = "";
        long[] s = new long[]{0};

        for (char ch : arrayString.toCharArray()) {

            if (ch == ',') {

                long[] toAppend={Long.valueOf(temp.replaceAll("\\s",""))};
                long[] tmp = new long[s.length+1];
                System.arraycopy(s, 0, tmp, 0, s.length);
                System.arraycopy(toAppend, 0, tmp, s.length, toAppend.length);
                s=tmp;
                temp="";
                vibrationArray=s;
            }
            if (ch == ' ') {
                temp = temp;
            }
            if (ch!=',' && Character.isDigit(ch)) {
                temp = temp + ch;
            }
        }
        arrayTextView.setText(Arrays.toString(s));

        ///patternTextView.setText(arrayString);
    }
}
