package com.dps924.lynart.androidguide;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class TermActivity extends AppCompatActivity {

    //http://developer.android.com/reference/android/widget/AutoCompleteTextView.html
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, AUTOCOMPLETELIST);
        AutoCompleteTextView textView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        textView.setAdapter(adapter);

        //http://stackoverflow.com/questions/8644501/how-to-set-setonclicklistener-for-autocompletetextview
        textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {

                //http://developer.android.com/guide/topics/ui/notifiers/toasts.html
                Context context = getApplicationContext();
                String selectedWord = (String)parent.getItemAtPosition(position);
                CharSequence text;

                switch (selectedWord){
                    case "Export":
                        text = getString(R.string.w_export);
                        break;
                    case "Gradle":
                        text=getString(R.string.w_gradle);
                        break;
                    case "Java":
                        text=getString(R.string.w_java);
                        break;
                    case "adb":
                        text=getString(R.string.w_adb);
                        break;
                    case "Android":
                        text=getString(R.string.w_android);
                        break;
                    case "Emulator":
                        text=getString(R.string.w_emulator);
                        break;
                    default:
                        text="How the heck did this happen?";
                        break;
                }

                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }

    private static final String[] AUTOCOMPLETELIST = new String[]{
        "Export", "Gradle", "Java", "adb", "Android", "Emulator"
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_term, menu);
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
}

/*
    <string name="w_export">Linux command used to export variables to child processes</string>
    <string name="w_gradle">A build automation tool that builds upon the concepts of Apache Ant and Apache Maven and introduces a Groovy-based domain-specific language (DSL) instead of the more traditional XML form of declaring the project configuration.</string>
    <string name="w_java">A programming language</string>
    <string name="w_adb">Android Debug Bridge that lets you communicate with an emulator instance</string>
    <string name="w_android">An mobile operating system</string>
    <string name="w_emulator">Hardware or software that allows a computer to behave like another computer system</string>
* */