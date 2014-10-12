package com.googlecode.gwtphonegap.showcase.client.inappbrowser;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.inappbrowser.InAppBrowser;
import com.googlecode.gwtphonegap.showcase.client.ClientFactory;
import com.googlecode.gwtphonegap.showcase.client.OverviewPlace;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.button.ButtonBase;

public class InAppBrowserActivity extends MGWTAbstractActivity {

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
  interface Binder extends UiBinder<Widget, InAppBrowserActivity> {}

  private PhoneGap phoneGap;
  private InAppBrowser inAppBrowser;
  private Widget rootWidget;
  private PlaceController placeController;

  @UiField
  ButtonBase browserButton;

  public InAppBrowserActivity(ClientFactory clientFactory) {
    placeController = clientFactory.getPlaceController();
    rootWidget = BINDER.createAndBindUi(this);
    this.phoneGap = clientFactory.getPhoneGap();
    inAppBrowser = this.phoneGap.getInAppBrowser();
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    panel.setWidget(rootWidget);
  }

  @UiHandler("browserButton")
  public void onOpenButtonPressed(TapEvent event) {
    inAppBrowser.open("http://www.google.de", "_blank", "");
  }

  @UiHandler("backButton")
  protected void onBackButtonPressed(TapEvent event) {
    placeController.goTo(new OverviewPlace());
  }
}
