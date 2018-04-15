package com.example.testoflfm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NavigationView navigationView = findViewById(R.id.navigation_view_left);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.image_navigationView_left:
                        Toast.makeText(MainActivity.this, "image", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.favorite:
                        Toast.makeText(MainActivity.this, "Favorite", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.wallet:
                        Toast.makeText(MainActivity.this, "wallet", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.photo:
                        Toast.makeText(MainActivity.this, "Photo", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.file:
                        Toast.makeText(MainActivity.this, "file", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;

            }
        });
    }

}
