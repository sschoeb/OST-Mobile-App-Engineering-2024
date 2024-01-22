package ch.paixon.exercise_network;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public TextView originTime;

    public TextView destinationTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        originTime = findViewById(R.id.originTime);
        destinationTime = findViewById(R.id.destinationTime);

        Button searchButton = findViewById(R.id.search);
        searchButton.setOnClickListener((View view) -> {
            onSearchClick();
        });
    }

    public void onSearchClick() {
        // TODO 1: Verwende Retrofit.Builder um eine Retrofit Instanz zu erstellen
        // TODO 2: Erstelle einen RetroFit Service sowie passende DTO-Klassen welcher das Connection-API representiert
        // TODO 3: Suche die nächsten Verbindungen von "Zürich" nach "Bern" und zeige die Zeiten der nächsten Verbindung im UI an
    }
}
