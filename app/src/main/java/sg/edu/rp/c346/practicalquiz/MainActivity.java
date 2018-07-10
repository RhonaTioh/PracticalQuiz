package sg.edu.rp.c346.practicalquiz;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etAge = findViewById(R.id.editTextAge);

        etName.requestFocus();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (!etAge.getText().toString().isEmpty()) {
            String name = etName.getText().toString();
            int age = Integer.parseInt(etAge.getText().toString());

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor prefEdit = prefs.edit();

            prefEdit.putString("myName", name);
            prefEdit.putInt("myAge", age);
            prefEdit.commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theName = prefs.getString("myName","");
        int theAge = prefs.getInt("myAge",0);

        etName.setText(theName);
        etAge.setText(String.valueOf(theAge));

    }
}
