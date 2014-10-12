/*
 * Copyright 2010 Daniel Kurka
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.showcase.client.accelerometer;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.accelerometer.Acceleration;
import com.googlecode.gwtphonegap.client.accelerometer.AccelerationCallback;
import com.googlecode.gwtphonegap.client.accelerometer.AccelerationOptions;
import com.googlecode.gwtphonegap.client.accelerometer.AccelermeterMock;
import com.googlecode.gwtphonegap.client.accelerometer.AccelerometerWatcher;
import com.googlecode.gwtphonegap.client.accelerometer.browser.AccelerationBrowserImpl;
import com.googlecode.gwtphonegap.showcase.client.ClientFactory;
import com.googlecode.gwtphonegap.showcase.client.OverviewPlace;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class AccelerometerActivity extends MGWTAbstractActivity {

  public static class MyPlace extends Place {
    public static class Tokenizer implements PlaceTokenizer<MyPlace> {

      @Override
      public MyPlace getPlace(String token) {
        return new MyPlace();
      }
      @Override
      public String getToken(MyPlace place) {
        return null;
      }
    }
  }

  private static Binder BINDER = GWT.create(Binder.class);
  interface Binder extends UiBinder<Widget, AccelerometerActivity> {}

  private final PhoneGap phoneGap;
  private AccelerometerWatcher watcher = null;
  private final PlaceController placeController;
  private Widget rootWidget;

  @UiField
  HTML xValue;

  @UiField
  HTML yValue;

  @UiField
  HTML zValue;

  @UiField
  HTML timestamp;

  @UiField
  Button startButton;

  public AccelerometerActivity(ClientFactory clientFactory) {
    this.phoneGap = clientFactory.getPhoneGap();
    placeController = clientFactory.getPlaceController();
    rootWidget = BINDER.createAndBindUi(this);
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {

    startButton.setText("Start");

    if (!phoneGap.isPhoneGapDevice()) {
      AccelermeterMock mock = ((AccelermeterMock) phoneGap.getAccelerometer());

      ArrayList<Acceleration> list = new ArrayList<Acceleration>();
      list.add(new AccelerationBrowserImpl(1, 1, 1));
      list.add(new AccelerationBrowserImpl(1, 0, 0));
      list.add(new AccelerationBrowserImpl(0, 1, 0));
      list.add(new AccelerationBrowserImpl(0, 0, 1));
      mock.setMockValues(list);
    }
    panel.setWidget(rootWidget);
  }

  @Override
  public void onStop() {
    super.onStop();

    if (watcher != null) {
      phoneGap.getAccelerometer().clearWatch(watcher);
      watcher = null;
    }
  }

  @UiHandler("backButton")
  protected void oBackButtonPressed(TapEvent event) {
    placeController.goTo(new OverviewPlace());
  }

  @UiHandler("startButton")
  protected void onStartStopButtonPressed(TapEvent event) {
    if (watcher == null) {
      final AccelerationOptions options = new AccelerationOptions();
      options.setFrequency(50);
      watcher = phoneGap.getAccelerometer().watchAcceleration(options, new AccelerometerCallbackImpl());
      startButton.setText("Stop");
    } else {
      phoneGap.getAccelerometer().clearWatch(watcher);
      watcher = null;
      startButton.setText("Start");
      xValue.setText("");
      yValue.setText("");
      zValue.setText("");
      timestamp.setText("");
    }
  }

  private class AccelerometerCallbackImpl implements AccelerationCallback {

    public AccelerometerCallbackImpl() {}

    @Override
    public void onSuccess(Acceleration acceleration) {
      xValue.setText("" + acceleration.getX());
      yValue.setText("" + acceleration.getY());
      zValue.setText("" + acceleration.getZ());
      timestamp.setText("" + acceleration.getTimeStamp());
    }

    @Override
    public void onFailure() {
      // TODO display error in app
      Window.alert("failure while reading acceleromter");
    }
  }
}
