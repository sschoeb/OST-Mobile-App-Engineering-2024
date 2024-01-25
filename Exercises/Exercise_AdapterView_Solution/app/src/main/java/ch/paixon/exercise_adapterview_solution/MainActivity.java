package ch.paixon.exercise_adapterview_solution;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        PersonAdapter adapter = new PersonAdapter(this, PersonRepository.getPersons());
        listView.setAdapter(adapter);
    }
}
