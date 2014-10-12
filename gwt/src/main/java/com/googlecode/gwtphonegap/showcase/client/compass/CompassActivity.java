package com.googlecode.gwtphonegap.showcase.client.compass;

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
import com.googlecode.gwtphonegap.client.compass.CompassCallback;
import com.googlecode.gwtphonegap.client.compass.CompassError;
import com.googlecode.gwtphonegap.client.compass.CompassHeading;
import com.googlecode.gwtphonegap.client.compass.CompassOptions;
import com.googlecode.gwtphonegap.client.compass.CompassWatcher;
import com.googlecode.gwtphonegap.showcase.client.ClientFactory;
import com.googlecode.gwtphonegap.showcase.client.OverviewPlace;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class CompassActivity extends MGWTAbstractActivity {

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
  interface Binder extends UiBinder<Widget, CompassActivity> {}

  private final PhoneGap phoneGap;
  private Widget rootWidget;
  private final PlaceController placeController;
  private CompassWatcher watcher;

  @UiField
  HTML mh;

  @UiField
  HTML th;

  @UiField
  HTML ha;

  @UiField
  HTML timestamp;

  @UiField
  Button startButton;

  public CompassActivity(ClientFactory clientFactory) {
    this.phoneGap = clientFactory.getPhoneGap();
    placeController = clientFactory.getPlaceController();
    rootWidget = BINDER.createAndBindUi(this);
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    startButton.setText("Start");
    ha.setText("");
    mh.setText("");
    timestamp.setText("");
    th.setText("");

    panel.setWidget(rootWidget);
  }

  @Override
  public void onStop() {
    if (watcher != null) {
      phoneGap.getCompass().clearWatcher(watcher);
      watcher = null;
    }
  }

  @UiHandler("backButton")
  protected void oBackButtonPressed(TapEvent event) {
    placeController.goTo(new OverviewPlace());
  }

  @UiHandler("startButton")
  public void onStartStopButtonPressed(TapEvent event) {
    if (watcher != null) {

      startButton.setText("Start");
      ha.setText("");
      mh.setText("");
      timestamp.setText("");
      th.setText("");

      if (watcher != null) {
        phoneGap.getCompass().clearWatcher(watcher);
        watcher = null;
      }

    } else {
      startButton.setText("Stop");
      watcher = phoneGap.getCompass().watchHeading(new CompassOptions(), new CompassCallback() {

        @Override
        public void onSuccess(CompassHeading heading) {
          ha.setText("" + heading.getHeadingAccuracy());
          mh.setText("" + heading.getMagneticHeading());
          timestamp.setText("" + heading.getTimeStamp());
          th.setText("" + heading.getTrueHeading());
        }

        @Override
        public void onError(CompassError error) {
          // TODO better error display
          Window.alert("error with compass");
        }
      });
    }
  }
}
