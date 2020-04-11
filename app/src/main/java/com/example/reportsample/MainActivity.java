package com.example.reportsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainAdapter mainAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        mainAdapter = new MainAdapter();
        recyclerView.setAdapter(mainAdapter);

        mainAdapter.addVistuals(getVistuals());

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


