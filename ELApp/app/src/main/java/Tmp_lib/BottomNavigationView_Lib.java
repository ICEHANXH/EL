package Tmp_lib;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.lenovo.elapp.R;

public class BottomNavigationView_Lib {
    /**
     * @param textView :(it could be changed into your own views) return the action
     *                 listener to react something to the Onclick
    * */
    public BottomNavigationView.OnNavigationItemSelectedListener
    Get_OnNavigationItemselectedListener(final TextView textView) {
        return new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        textView.setText(R.string.title_home);
                        return true;
                    case R.id.navigation_dashboard:
                        textView.setText(R.string.title_dashboard);
                        return true;
                    case R.id.navigation_notifications:
                        textView.setText(R.string.title_notifications);
                        return true;
                }
                return false;
            }
        };
    }

}
