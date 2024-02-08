package ch.paixon.exercise_network;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ch.paixon.exercise_network.dtos.ConnectionContainerDto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://transport.opendata.ch/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ConnectionService service = retrofit.create(ConnectionService.class);

        service.searchConnections("Zürich", "Bern").enqueue(new Callback<ConnectionContainerDto>() {
            @Override
            public void onResponse(Call<ConnectionContainerDto> call, Response<ConnectionContainerDto> response) {
                if (response.isSuccessful()) {
                    ConnectionContainerDto connectionsContainer = response.body();
                    // Handle result...
                    originTime.setText(connectionsContainer.connections.get(0).from.departure.toString());
                    destinationTime.setText(connectionsContainer.connections.get(0).to.arrival.toString());
                }
            }

            @Override
            public void onFailure(Call<ConnectionContainerDto> call, Throwable t) {
                Log.d("Test", "fail");
            }
        });   }
}
