package com.paulojuniore.somecomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onToggleButtonClicked(View view) {
        boolean on = ((ToggleButton) view).isChecked();
        if(on) {
            Toast toast = Toast.makeText(this, "Your tea will be cold!", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this, "Your tea will be hot!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
