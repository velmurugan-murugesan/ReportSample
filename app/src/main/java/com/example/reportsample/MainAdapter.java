package com.example.reportsample;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<Vistual> vistualList = new ArrayList<>();

    public void addVistuals(List<Vistual> vistuals) {
        this.vistualList = vistuals;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_main, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {

        Vistual vistual = vistualList.get(position);

        WebSettings webSetting =  holder.webView.getSettings();
        webSetting.setBuiltInZoomControls(true);
        webSetting.setJavaScriptEnabled(true);
        webSetting.setCacheMode(WebSettings.LOAD_DEFAULT);

        webSetting.setAppCacheEnabled(true);
        webSetting.setDomStorageEnabled(true);
        holder.webView.setWebViewClient(new MyWebViewClient());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // chromium, enable hardware acceleration
            holder.webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
            // older android version, disable hardware acceleration
            holder.webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        holder.webView.loadUrl("file:///android_asset/page.html");


    }

    @Override
    public int getItemCount() {
        return vistualList.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {
        WebView webView;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            webView = itemView.findViewById(R.id.webview);

        }



    }
}




