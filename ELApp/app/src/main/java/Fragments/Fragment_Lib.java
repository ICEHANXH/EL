package Fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.lenovo.elapp.R;

public class Fragment_Lib extends AppCompatActivity {

    /**
     * @param fragment:Destination of the replacement
     * @param idOfLayout:source    of the layout of the fragment
     */
    public void replaceFragment(Fragment fragment, int idOfLayout) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(idOfLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
