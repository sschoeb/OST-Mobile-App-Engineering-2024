package ch.paixon.exercise_intent_solution;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.buttonNavigate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              navigate();
            }
        });
    }

    private void navigate() {
        EditText editText = (EditText)findViewById(R.id.editTextValue);
        Editable text = editText.getText();
        String valueToPass = text.toString();

        Intent intent = new Intent(this, TargetActivity.class);
        intent.putExtra("myextra", valueToPass);
        startActivity(intent);
    }
}
