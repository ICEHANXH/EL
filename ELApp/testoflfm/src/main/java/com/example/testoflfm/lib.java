//package com.example.testoflfm;
//
//
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
//import android.support.v7.app.AppCompatActivity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//public class lib extends AppCompatActivity {
//    private void replaceFragment(Fragment fragment, int Id) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.right_layout, fragment);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
//        public void changeFragment (View view){
//            switch (view.getId()) {
//                case R.id.button:
//                    replaceFragment(new AnotherFragment());
//                    break;
//                default:
//                    break;
//            }
//        }
//    }
//}
//
//
//class LeftFragment extends Fragment {
//    View onCreateView(LayoutInflater inflater, ViewGroup container,
//                      Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.left_fragment, container, false);
//        return view;
//    }
//}
