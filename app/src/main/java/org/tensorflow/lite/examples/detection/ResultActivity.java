package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Retrieve the captured image bitmap from the intent extras
        Bitmap capturedBitmap = getIntent().getParcelableExtra("capturedBitmap");

        // Display the captured image in an ImageView
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageBitmap(capturedBitmap);
    }
}
