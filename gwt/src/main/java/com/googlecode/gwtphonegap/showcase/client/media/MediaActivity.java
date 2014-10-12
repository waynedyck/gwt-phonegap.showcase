package com.googlecode.gwtphonegap.showcase.client.media;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.media.Media;
import com.googlecode.gwtphonegap.client.media.MediaCallback;
import com.googlecode.gwtphonegap.client.media.MediaError;
import com.googlecode.gwtphonegap.client.media.MediaPositionCallback;
import com.googlecode.gwtphonegap.showcase.client.ClientFactory;
import com.googlecode.gwtphonegap.showcase.client.OverviewPlace;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.button.ButtonBase;

public class MediaActivity extends MGWTAbstractActivity {

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
  interface Binder extends UiBinder<Widget, MediaActivity> {}

  private final PhoneGap phoneGap;
  private Media media;
  private Timer timer;
  private Widget rootWidget;
  private PlaceController placeController;

  @UiField
  HTML position;

  @UiField
  ButtonBase play;

  @UiField
  ButtonBase pause;

  public MediaActivity(ClientFactory clientFactory) {
    placeController = clientFactory.getPlaceController();
    rootWidget = BINDER.createAndBindUi(this);
    this.phoneGap = clientFactory.getPhoneGap();
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {

    showPlayButton(true);
    showPauseButton(false);

    panel.setWidget(rootWidget);

    String url = "";
    if (MGWT.getOsDetection().isIOs()) {
      url = "sound.mp3";
    } else {
      if (MGWT.getOsDetection().isAndroid()) {
        url = "http://audio.ibeat.org/content/p1rj1s/p1rj1s_-_rockGuitar.mp3";
      } else {
        if (MGWT.getOsDetection().isDesktop()) {

        } else {
          // what are your running on
          Window.alert("currently media only on android and ios");
        }
      }
    }

    media = phoneGap.getMedia().create(url, new MediaCallback() {

      @Override
      public void onSuccess() {

      }

      @Override
      public void onStatusChange(int mediaStatus) {

      }

      @Override
      public void onError(MediaError error) {
        Window.alert("error: " + error.getErrorCode() + " " + error.getErrorMessage());
      }
    });

    timer = new Timer() {

      @Override
      public void run() {
        media.getCurrentPosition(new MediaPositionCallback() {

          @Override
          public void onSuccess(long position) {
            if (position == -1) {
              getPosition().setHTML("");
            } else {
              getPosition().setHTML(position + " / " + media.getDuration());
            }
          }

          @Override
          public void onFailure(MediaError error) {

          }
        });
      }
    };
    timer.scheduleRepeating(200);
  }

  @Override
  public void onStop() {
    super.onStop();
    media.release();
    timer.cancel();
  }

  public HasHTML getPosition() {
    return position;
  }

  public void showPlayButton(boolean show) {
    play.setVisible(show);
  }

  public void showPauseButton(boolean show) {
    pause.setVisible(show);
  }

  @UiHandler("backButton")
  protected void oBackButtonPressed(TapEvent event) {
    placeController.goTo(new OverviewPlace());
  }

  @UiHandler("play")
  public void onPlayButtonPressed(TapEvent event) {
    showPlayButton(false);
    showPauseButton(true);
    media.play();
  }

  @UiHandler("pause")
  public void onPauseButtonPressed(TapEvent event) {
    showPlayButton(true);
    showPauseButton(false);
    media.pause();
  }
}
