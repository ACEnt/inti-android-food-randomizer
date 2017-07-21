package com.example.inti.foodrandom;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Asus on 19-Jul-17.
 */

public class LastFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        //Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.last_fragment, container ,false);

        WebView webView = (WebView)rootView.findViewById(R.id.webView);

        webView.setInitialScale(1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);
        webView.setWebViewClient(new WebViewClient()); //Force url open in webview form.
        webView.loadUrl("https://maps.google.com/"); // Load google map in webview form.

        return rootView;
    }
}
