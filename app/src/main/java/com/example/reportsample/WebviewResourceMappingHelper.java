package com.example.reportsample;

import android.app.Application;
import android.os.Build;
import android.webkit.WebResourceResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebviewResourceMappingHelper {
    private static WebviewResourceMappingHelper instance;
    private List<LocalAssetMapModel> localAssetMapModelList;
    private List<String> overridableExtensions = new ArrayList<>(Arrays.asList("js", "css", "woff", "ttf", "eot", "ico"));

    private WebviewResourceMappingHelper(){

    }

    public static WebviewResourceMappingHelper getInstance(){
        if(instance == null){
            instance = new WebviewResourceMappingHelper();
        }
        return instance;
    }

    public String getLocalAssetPath(String url){
        if(url.isEmpty()){
            return "";
        }
        if(localAssetMapModelList == null){
            localAssetMapModelList = getLocalAssetList();
        }
        if(!localAssetMapModelList.isEmpty()){
            for(LocalAssetMapModel localAssetMapModel : localAssetMapModelList){
                if(localAssetMapModel.url.equals(url)){
                    return localAssetMapModel.asset_url;
                }
            }
        }
        return "";
    }


    private List<LocalAssetMapModel> getLocalAssetList(){
        List<LocalAssetMapModel> localAssetMapModelList = new ArrayList<>();
        String pageData = null;
        try {
            pageData = ResourceAccessHelper.getJsonData(MyApplication.getInstance(), "file.json");
        } catch (IOException e) {
        }
        if(pageData !=null){
            Type listType = new TypeToken<ArrayList<LocalAssetMapModel>>() {
            }.getType();
            localAssetMapModelList = new Gson().fromJson(pageData,listType);
        }

        pageData = null;
        try {
            pageData = ResourceAccessHelper.getJsonData(MyApplication.getInstance(), "web-assets/fonts-map.json");
        } catch (IOException e) {
        }
        if(pageData !=null){
            Type listType = new TypeToken<ArrayList<LocalAssetMapModel>>() {
            }.getType();
            List<LocalAssetMapModel> fontsMap = new Gson().fromJson(pageData,listType);
            localAssetMapModelList.addAll(fontsMap);
        }
        return localAssetMapModelList;
    }

    public List<String> getOverridableExtensions(){
        return overridableExtensions;
    }

    public String getFileExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
    }

    public String getMimeType(String fileExtension){
        String mimeType = "";
        switch (fileExtension){
            case "css" :
                mimeType = "text/css";
                break;
            case "js" :
                mimeType = "text/javascript";
                break;
            case "ico" :
                mimeType = "image/x-icon";
                break;
            case "woff" :
            case "ttf" :
            case "eot" :
                mimeType = "application/x-font-opentype";
                break;
        }
        return mimeType;
    }

    public static WebResourceResponse getWebResourceResponseFromAsset(String assetPath, String mimeType, String encoding) throws IOException{
        InputStream inputStream =  MyApplication.getInstance().getAssets().open(assetPath);
        int statusCode = 200;
        String reasonPhase = "OK";
        Map<String, String> responseHeaders = new HashMap<String, String>();
        responseHeaders.put("Access-Control-Allow-Origin", "*");
        return new WebResourceResponse(mimeType, encoding, statusCode, reasonPhase, responseHeaders, inputStream);
    }

    public static WebResourceResponse getWebResourceResponseFromFile(String filePath, String mimeType, String encoding) throws FileNotFoundException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int statusCode = 200;
            String reasonPhase = "OK";
            Map<String, String> responseHeaders = new HashMap<String, String>();
            responseHeaders.put("Access-Control-Allow-Origin","*");
            return new WebResourceResponse(mimeType, encoding, statusCode, reasonPhase, responseHeaders, fileInputStream);
        }
        return new WebResourceResponse(mimeType, encoding, fileInputStream);
    }

    private class LocalAssetMapModel{
        String url;
        String asset_url;
    }
}