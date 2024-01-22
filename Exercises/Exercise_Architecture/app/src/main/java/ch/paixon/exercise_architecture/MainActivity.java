package ch.paixon.exercise_architecture;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import ch.paixon.exercise_architecture.dto.ConnectionContainerDto;
import ch.paixon.exercise_architecture.dto.ConnectionDto;
import ch.paixon.exercise_architecture.viewmodels.ConnectionViewModel;

public class MainActivity extends AppCompatActivity {

    public TextView originTime;

    public TextView destinationTime;

    private ConnectionViewModel connectionsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        originTime = findViewById(R.id.originTime);
        destinationTime = findViewById(R.id.destinationTime);

        this.connectionsViewModel = ViewModelProviders.of(this).get(ConnectionViewModel.class);

        this.connectionsViewModel.getConnections().observe(this, new Observer<ConnectionContainerDto>() {
            @Override
            public void onChanged(@Nullable ConnectionContainerDto connectionsContainer) {
                ConnectionDto connection = connectionsContainer.connections.get(0);
                originTime.setText(connection.from.departure.toString());
                destinationTime.setText(connection.to.arrival.toString());
            }
        });
    }
}