package ch.paixon.exercise_activity_solution;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find button on layout
        Button button = findViewById(R.id.buttonShowText);

        // Example for a click-listener in Java 8
        button.setOnClickListener((View view) -> Toast.makeText(this,"Das ist ein Java 8 Toast", Toast.LENGTH_LONG).show());

        // Register a click listener to be notified when the user clicks the button in Java below 8
        /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // On every click call the method to show the toast
                showToast();
            }
        });*/
    }

    private void showToast() {
        // Create a new Toast and show it "Long"
        Toast.makeText(this, "Das ist ein Toast", Toast.LENGTH_LONG).show();
    }
}
