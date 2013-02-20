package com.googlecode.gwtphonegap.android;

import org.apache.cordova.CordovaChromeClient;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.DroidGap;

import android.os.Bundle;

public class MainActivity extends DroidGap {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    super.loadUrl("file:///android_asset/www/index.html");
  }

  @Override
  public void init() {
    super.init(new CordovaWebView(this), new GWTCordovaWebViewClient(this), new CordovaChromeClient(this));
    System.out.println("asdfasdf");
  }

}