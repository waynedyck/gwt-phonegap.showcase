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
package com.googlecode.gwtphonegap.showcase.client.notification;

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
import com.googlecode.gwtphonegap.client.notification.AlertCallback;
import com.googlecode.gwtphonegap.client.notification.ConfirmCallback;
import com.googlecode.gwtphonegap.showcase.client.ClientFactory;
import com.googlecode.gwtphonegap.showcase.client.OverviewPlace;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class NotificationActivity extends MGWTAbstractActivity {

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
  interface Binder extends UiBinder<Widget, NotificationActivity> {}

  private final PhoneGap phoneGap;
  private Widget rootWidget;
  private PlaceController placeController;

  @UiField
  Button alert;

  @UiField
  Button confirm;

  @UiField
  Button vibrate;

  @UiField
  Button beep;

  public NotificationActivity(ClientFactory clientFactory) {
    placeController = clientFactory.getPlaceController();
    rootWidget = BINDER.createAndBindUi(this);
    this.phoneGap = clientFactory.getPhoneGap();
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    panel.setWidget(rootWidget);
  }

  @UiHandler("alert")
  public void onAlertButtonPressed(TapEvent event) {
    phoneGap.getNotification().alert("daniel says hi", new AlertCallback() {

      @Override
      public void onOkButtonClicked() {

      }
    }, "gwt-phonegap", "buttonText");

  }

  @UiHandler("confirm")
  public void onConfirmButtonPressed(TapEvent event) {
    phoneGap.getNotification().confirm("question?", new ConfirmCallback() {

      @Override
      public void onConfirm(int button) {

      }
    }, "gwt-phonegap");
  }

  @UiHandler("beep")
  public void onBeepButtonPressed(TapEvent event) {
    phoneGap.getNotification().beep(2);
  }

  @UiHandler("vibrate")
  public void onVibrateButtonPressed(TapEvent event) {
    phoneGap.getNotification().vibrate(2500);
  }

  @UiHandler("backButton")
  protected void onBackButtonPressed(TapEvent event) {
    placeController.goTo(new OverviewPlace());
  }
}
