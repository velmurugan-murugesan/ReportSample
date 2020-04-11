package com.example.reportsample;

import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.IOException;

public class MyWebViewClient extends WebViewClient {

    String TAG = MyWebViewClient.class.getName();

    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        String resourceUrl = request.getUrl().toString();
        Log.d(TAG, "resource URL = " +resourceUrl.toString());
        String fileExtension = WebviewResourceMappingHelper.getInstance().getFileExt(resourceUrl);
        if(WebviewResourceMappingHelper.getInstance().getOverridableExtensions().contains(fileExtension)){
            String encoding = "UTF-8";
            String assetName = WebviewResourceMappingHelper.getInstance().getLocalAssetPath(resourceUrl);
            if (!assetName.isEmpty()) {
                String mimeType = WebviewResourceMappingHelper.getInstance().getMimeType(fileExtension);
                if (!mimeType.isEmpty()) {
                    try {
                        Log.e(TAG, "asset Name = "+assetName);
                        return WebviewResourceMappingHelper.getWebResourceResponseFromAsset(assetName, mimeType, encoding);
                    } catch (IOException e) {
                        return super.shouldInterceptRequest(view, request);
                    }
                }
            }
        }

        return super.shouldInterceptRequest(view,request);
    }
}