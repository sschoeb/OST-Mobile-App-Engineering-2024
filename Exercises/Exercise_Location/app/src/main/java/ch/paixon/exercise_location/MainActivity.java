package ch.paixon.exercise_location;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    private TextView longitudeTextView;
    private TextView latitudeTextView;
    private FusedLocationProviderClient client;

    private LocationCallback locationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            UpdateLocationOnUi(locationResult.getLocations().get(0));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Einfache Implementation um die Permissions für den Location-Zugriff zu erhalten
        // Fehlerhandling fehlt komplett -> App crashed wenn der Benutzer die Berechtigungen nicht erteilt
        // Mehr zu Fehlerhandling unter folgendem Link:
        // https://developer.android.com/training/permissions/requesting.html
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);

        longitudeTextView = findViewById(R.id.valueLongitude);
        latitudeTextView = findViewById(R.id.valueLatitude);

        client = LocationServices.getFusedLocationProviderClient(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        client.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                UpdateLocationOnUi(location);
            }
        });


        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        client.requestLocationUpdates(locationRequest, locationCallback, null);

    }

    @Override
    protected void onPause() {
        super.onPause();

        client.removeLocationUpdates(locationCallback);
    }

    private void UpdateLocationOnUi(Location location) {
        if (location != null) {
            latitudeTextView.setText(location.getLatitude() + "");
            longitudeTextView.setText(location.getLongitude() + "");
        }
    }
}
