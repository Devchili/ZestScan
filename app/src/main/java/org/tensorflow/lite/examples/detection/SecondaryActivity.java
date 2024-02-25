package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class SecondaryActivity extends AppCompatActivity {


    private MeowBottomNavigation bottomNavigation;
    private TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);



        bottomNavigation = findViewById(R.id.bottomNavigation);
        toolbarTitle = findViewById(R.id.toolbarTitle);

        bottomNavigation.show(1, true);
        toolbarTitle.setText("Scanner");

//        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.camera));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.baseline_image_24));

        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                switch (model.getId()){
                    case 1:
                        toolbarTitle.setText("Scanner");
                        replaceFragment(new LiveScanFragment());
                        break;
                    case 2:
                        toolbarTitle.setText("Import");
                        replaceFragment(new ImportImageFragment());
                        break;
                }

                return null;
            }
        });

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                switch (model.getId()){
                    case 1:
                        toolbarTitle.setText("Scanner");
                        replaceFragment(new LiveScanFragment());
                        break;
                    case 2:
                        toolbarTitle.setText("Import");
                        replaceFragment(new ImportImageFragment());
                        break;
                }

                return null;
            }
        });
    }
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    private void detachFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentById(R.id.frameLayout);
        if (fragment != null) {
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
        }
    }
    }
}