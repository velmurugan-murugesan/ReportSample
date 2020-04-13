package com.example.reportsample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import com.example.reportsample.features.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final FragmentManager fm = getSupportFragmentManager();

    private Fragment home1 = new HomeFragment(1);
    private Fragment home2 = new HomeFragment(2);
    private Fragment home3 = new HomeFragment(3);
    private Fragment home4 = new HomeFragment(4);

    private Fragment active = home1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);


        fm.beginTransaction().add(R.id.content, home4, "4").hide(home4).commit();
        fm.beginTransaction().add(R.id.content, home3, "3").hide(home3).commit();
        fm.beginTransaction().add(R.id.content, home2, "2").hide(home2).commit();
        fm.beginTransaction().add(R.id.content, home1, "1").commit();


       /* Fragment fragment = new HomeFragment(R.id.navigation_home_1);
        addFragment(fragment);*/

        navigation.setOnNavigationItemSelectedListener(itemSelectedListener);

        /*RecyclerView recyclerView = findViewById(R.id.recyclerview);
        mainAdapter = new MainAdapter();
        recyclerView.setAdapter(mainAdapter);

        mainAdapter.addVistuals(getVistuals());*/

    }

    private BottomNavigationView.OnNavigationItemSelectedListener itemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home_1:
                    fm.beginTransaction().hide(active).show(home1).commit();
                    active = home1;
                    return true;

                case R.id.navigation_home_2:
                    fm.beginTransaction().hide(active).show(home2).commit();
                    active = home2;
                    return true;

                case R.id.navigation_home_3:
                    fm.beginTransaction().hide(active).show(home3).commit();
                    active = home3;
                    return true;
                case R.id.navigation_home_4:
                    fm.beginTransaction().hide(active).show(home4).commit();
                    active = home4;
                    return true;
            }
            return false;
        }
    };
    private void addFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, fragment, fragment.getClass().getSimpleName())
                .commit();
    }

    private List<Vistual> getVistuals() {

        List<Vistual> vis = new ArrayList<>();
        vis.add(new Vistual("", ""));
        vis.add(new Vistual("", ""));
        vis.add(new Vistual("", ""));
        vis.add(new Vistual("", ""));
        vis.add(new Vistual("", ""));
        return vis;
    }

}


