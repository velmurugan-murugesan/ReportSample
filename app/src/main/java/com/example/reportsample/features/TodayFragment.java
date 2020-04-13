package com.example.reportsample.features;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reportsample.MainAdapter;
import com.example.reportsample.R;
import com.example.reportsample.Vistual;

import java.util.ArrayList;
import java.util.List;

public class TodayFragment extends BaseFragment {

    public TodayFragment(int someInt) {
        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        setArguments(args);
    }

    @Override
    int getResource() { return  R.layout.fragment_today; }


    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int someInt = getArguments() != null ? getArguments().getInt("someInt") : 0;
        Log.d("someInt",someInt+"");
        recyclerView = view.findViewById(R.id.rv_vistuals);
        mainAdapter = new MainAdapter();
        recyclerView.setAdapter(mainAdapter);
        recyclerView.setItemViewCacheSize(10);
        mainAdapter.addVistuals(getVistuals(someInt));

    }
    private List<Vistual> getVistuals(int count) {
        List<Vistual> vis = new ArrayList<>();
        for (int i = 0; i <count; i++) {
            vis.add(new Vistual("", ""));
        }
        return vis;
    }
}
