package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class MainActivity extends AppCompatActivity {

    private static int currentClicks = 0;

    static long secondsUntilDayAfterTomorrow = calculateTimeUntilDayAfterTomorrow(); // result for seconds

    public static long calculateTimeUntilDayAfterTomorrow() { // calculate seconds to lesson on wednesday 8:50
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime dayAfterTomorrowDateTime = LocalDateTime.of(currentDateTime.toLocalDate().plusDays(2), LocalTime.of(8, 50));

        Duration duration = Duration.between(currentDateTime, dayAfterTomorrowDateTime);
        return duration.getSeconds();
    }

    public static String formatTime(long seconds) { // Formating seconds to normal date on third task
        long days = seconds / (24 * 3600);
        long hours = (seconds % (24 * 3600)) / 3600;
        long minutes = ((seconds % (24 * 3600)) % 3600) / 60;
        long remainingSeconds = ((seconds % (24 * 3600)) % 3600) % 60;

        return String.format("%d:%02d:%02d:%02d", days, hours, minutes, remainingSeconds);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // загрузка вёрстки
        Button firstButton = findViewById(R.id.catButton);


        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondsUntilDayAfterTomorrow = calculateTimeUntilDayAfterTomorrow(); // result for seconds
                setTitle(String.valueOf(formatTime(secondsUntilDayAfterTomorrow))); // Title for date
                if(currentClicks < 20)                                                       // Start of second task
                {
                    firstButton.setText(String.valueOf(currentClicks));
                    currentClicks++;
                }
                else{
                    firstButton.setText("доброго вечора ми пес патрон");
                    firstButton.setEnabled(false);
                }                                                                            // End of second task
                firstButton.setWidth(firstButton.getWidth() + 10); // First Task
                Toast.makeText(MainActivity.this,
                        "Hello from handler!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void func(View view)
    {
        Toast.makeText(this, "lol", Toast.LENGTH_LONG).show();
    }
}