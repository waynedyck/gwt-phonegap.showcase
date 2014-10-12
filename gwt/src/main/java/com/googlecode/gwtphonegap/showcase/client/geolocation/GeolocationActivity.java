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
package com.googlecode.gwtphonegap.showcase.client.geolocation;

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
import com.googlecode.gwtphonegap.client.geolocation.GeolocationCallback;
import com.googlecode.gwtphonegap.client.geolocation.GeolocationOptions;
import com.googlecode.gwtphonegap.client.geolocation.GeolocationWatcher;
import com.googlecode.gwtphonegap.client.geolocation.Position;
import com.googlecode.gwtphonegap.client.geolocation.PositionError;
import com.googlecode.gwtphonegap.showcase.client.ClientFactory;
import com.googlecode.gwtphonegap.showcase.client.OverviewPlace;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class GeolocationActivity extends MGWTAbstractActivity {

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
  interface Binder extends UiBinder<Widget, GeolocationActivity> {}

  private Widget rootWidget;
  private PlaceController placeController;
  private final PhoneGap phoneGap;
  private GeolocationWatcher watcher;

  @UiField
  HTML latitude;

  @UiField
  HTML longitude;

  @UiField
  HTML altitude;

  @UiField
  HTML accuracy;

  @UiField
  HTML aa;

  @UiField
  HTML heading;

  @UiField
  HTML speed;

  @UiField
  HTML timestamp;

  @UiField
  Button startButton;

  public GeolocationActivity(ClientFactory clientFactory) {
    placeController = clientFactory.getPlaceController();
    rootWidget = BINDER.createAndBindUi(this);
    this.phoneGap = clientFactory.getPhoneGap();
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {

    startButton.setText("Start");
    accuracy.setText("");
    altitude.setText("");
    aa.setText("");
    heading.setText("");
    latitude.setText("");
    longitude.setText("");
    timestamp.setText("");

    panel.setWidget(rootWidget);
  }

  @Override
  public void onStop() {
    if (watcher != null) {
      phoneGap.getGeolocation().clearWatch(watcher);
      watcher = null;
    }
  }

  @UiHandler("startButton")
  public void onStartStopButtonPressed(TapEvent event) {

    if (watcher == null) {
      GeolocationOptions options = new GeolocationOptions();
      watcher = phoneGap.getGeolocation().watchPosition(options, new GeoLocationCallbackImpl());
      startButton.setText("Stop");

    } else {
      phoneGap.getGeolocation().clearWatch(watcher);
      watcher = null;
      startButton.setText("Start");
      accuracy.setText("");
      altitude.setText("");
      aa.setText("");
      heading.setText("");
      latitude.setText("");
      longitude.setText("");
      timestamp.setText("");
      speed.setText("");
    }
  }

  private class GeoLocationCallbackImpl implements GeolocationCallback {

    @Override
    public void onSuccess(Position position) {

      accuracy.setText("" + position.getCoordinates().getAccuracy());
      altitude.setText("" + position.getCoordinates().getAltitude());
      aa.setText("" + position.getCoordinates().getAltitudeAccuracy());
      heading.setText("" + position.getCoordinates().getHeading());
      latitude.setText("" + position.getCoordinates().getLatitude());
      longitude.setText("" + position.getCoordinates().getLongitude());
      speed.setText("" + position.getCoordinates().getSpeed());
      timestamp.setText("" + position.getTimeStamp());
    }

    @Override
    public void onFailure(PositionError error) {
      switch (error.getCode()) {
        case PositionError.PERMISSION_DENIED:
          Window.alert("no permission - stoping watcher");
          break;
        case PositionError.POSITION_UNAVAILABLE:
          Window.alert("unavaible");
          break;
        case PositionError.TIMEOUT:
          Window.alert("timeout");
          break;
        default:
          break;
      }

      if (watcher != null) {
        phoneGap.getGeolocation().clearWatch(watcher);
        watcher = null;
        startButton.setText("Start");
      }
    }
  }

  @UiHandler("backButton")
  protected void oBackButtonPressed(TapEvent event) {
    placeController.goTo(new OverviewPlace());
  }
}
