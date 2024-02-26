package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnPicture = findViewById(R.id.btnPicture);
        Button btnLive = findViewById(R.id.btnLive);

        btnPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for "Picture" button
                // Navigate to PictureActivity
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for "Live" button
                // Navigate to CameraActivity
                Intent intent = new Intent(SecondActivity.this, DetectorActivity.class);
                startActivity(intent);
            }
        });
    }
}
