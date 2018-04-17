package Activitys;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.lenovo.elapp.R;

import java.util.LinkedList;

import Fragments.Fragment_Lib;
import Fragments.MainActivityLeftFragment;
import Tmp_lib.BottomNavigationView_Lib;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationTask();
        //       NavigationViewTask();

    }

    private void NavigationViewTask() {
        NavigationView navigationView = findViewById(R.id.navigation_view_left);
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {

            }
            return false;
        });
    }

    private void BottomNavigationTask() {
        Fragment_Lib.replaceFragment(this, new MainActivityLeftFragment(), R.id.root_Frame_layout);
        BottomNavigationView navigation = findViewById(R.id.MainActivityNavigation);
        navigation.setOnNavigationItemSelectedListener(
                BottomNavigationView_Lib.Get_OnNavigationItemselectedListener(this));
    }
//
//    /**
//     * Conduct the actions of the NavigationBottom.
//     */
//    private void NavigationView_part() {
//        BottomNavigationView navigation = findViewById(R.id.MainActivityNavigation);
//        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.navigation_home:
//                        Fragment_Lib.replaceFragment(new MainActivity(), new MainActivityLeftFragment()
//                                , R.id.root_Frame_layout);
//                        return true;
//                    case R.id.navigation_dashboard:
//                        return true;
//                    case R.id.navigation_notifications:
//                        Fragment_Lib.replaceFragment(new MainActivity(), new MainActivityRightFragment()
//                                , R.id.root_Frame_layout);
//                        return true;
//                }
//                return false;
//            }
//        });
//    }
//
//    private void replaceFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.root_Frame_layout, fragment);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
//    }
}
