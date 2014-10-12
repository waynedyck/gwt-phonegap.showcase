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
package com.googlecode.gwtphonegap.showcase.client.camera;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.camera.PictureCallback;
import com.googlecode.gwtphonegap.client.camera.PictureOptions;
import com.googlecode.gwtphonegap.showcase.client.ClientFactory;
import com.googlecode.gwtphonegap.showcase.client.OverviewPlace;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.button.ButtonBase;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;

public class CameraActivity extends MGWTAbstractActivity {

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
  interface Binder extends UiBinder<Widget, CameraActivity> {}

  private final PhoneGap phoneGap;
  private Widget rootWidget;
  private final PlaceController placeController;
  private HandlerRegistration addLoadHandler;

  @UiField
  ButtonBase cameraButton;

  @UiField
  ScrollPanel scrollPanel;

  @UiField
  Image image;

  public CameraActivity(ClientFactory clientFactory) {
    this.phoneGap = clientFactory.getPhoneGap();
    placeController = clientFactory.getPlaceController();
    rootWidget = BINDER.createAndBindUi(this);
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    panel.setWidget(rootWidget);
  }

  public void displayFoto(String data) {

    addLoadHandler = image.addLoadHandler(new LoadHandler() {

      @Override
      public void onLoad(LoadEvent event) {
        addLoadHandler.removeHandler();
        scrollPanel.refresh();
      }
    });
    image.setUrl(data);
  }

  @UiHandler("backButton")
  protected void onBackButtonPressed(TapEvent event) {
    placeController.goTo(new OverviewPlace());
  }

  @UiHandler("cameraButton")
  public void onCameraButtonPressed(TapEvent event) {
    PictureOptions options = new PictureOptions(25);
    options.setDestinationType(PictureOptions.DESTINATION_TYPE_DATA_URL);
    options.setSourceType(PictureOptions.PICTURE_SOURCE_TYPE_CAMERA);

    phoneGap.getCamera().getPicture(options, new PictureCallback() {

      @Override
      public void onSuccess(String data) {
        displayFoto("data:image/jpeg;base64," + data);
      }

      @Override
      public void onFailure(String message) {
        // TODO better error display
        Window.alert("failure");
      }
    });
  }
}
