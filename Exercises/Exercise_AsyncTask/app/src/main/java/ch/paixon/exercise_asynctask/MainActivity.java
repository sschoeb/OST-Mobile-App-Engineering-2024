package ch.paixon.exercise_asynctask;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textViewState;

    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textViewState = (TextView) findViewById(R.id.textViewState);

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                progressBar.setProgress(0);
                textViewState.setText("Started");

                thread = new Thread(new Worker());
                thread.start();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("Threading", "Interrupt running background thread");
        thread.interrupt();
    }

    class Worker implements Runnable {

        @Override
        public void run() {
            int progress = 0;
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Log.d("Threading", "Thread interrupted while sleeping");
                    return;
                }

                if (Thread.currentThread().isInterrupted()) {
                    Log.d("Threading", "Thread interrupted");
                    return;
                }

                progress += 10;
                publishProgress(progress);
            }

            finish();
        }

        private void publishProgress(int currentProgress) {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressBar.setProgress(currentProgress);
                }
            });

        }

        private void finish() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textViewState.setText("Finished");
                }
            });
        }
    }

}
