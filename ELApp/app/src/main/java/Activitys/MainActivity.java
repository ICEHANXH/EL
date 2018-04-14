package Activitys;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.lenovo.elapp.R;

import Tmp_lib.BottomNavigationView_Lib;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mTextMessage = findViewById(R.id.show);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new
        BottomNavigationView_Lib().Get_OnNavigationItemselectedListener(mTextMessage));
    }

}
