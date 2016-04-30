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
package com.googlecode.gwtphonegap.showcase.client.device;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.showcase.client.ClientFactory;
import com.googlecode.gwtphonegap.showcase.client.OverviewPlace;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

public class DeviceActivity extends MGWTAbstractActivity {

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
  interface Binder extends UiBinder<Widget, DeviceActivity> {}

  private Widget rootWidget;
  private PlaceController placeController;

  private final PhoneGap phoneGap;

  @UiField
  HTML name;

  @UiField
  HTML platform;

  @UiField
  HTML version;

  @UiField
  HTML pversion;

  @UiField
  HTML uuid;

  @UiField
  HTML model;

  @UiField
  HTML manufacturer;

  @UiField
  HTML serial;
  
  @UiField
  HTML isVirtual;
  
  public DeviceActivity(ClientFactory clientFactory) {
    placeController = clientFactory.getPlaceController();
    rootWidget = BINDER.createAndBindUi(this);
    this.phoneGap = clientFactory.getPhoneGap();
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    version.setHTML(phoneGap.getDevice().getVersion());
    name.setHTML(phoneGap.getDevice().getModel());
    pversion.setHTML(phoneGap.getDevice().getPhoneGapVersion());
    platform.setHTML(phoneGap.getDevice().getPlatform());
    uuid.setHTML(phoneGap.getDevice().getUuid());
    isVirtual.setHTML(String.valueOf(phoneGap.getDevice().isVirtual()));
    serial.setHTML(phoneGap.getDevice().getSerial());
    manufacturer.setHTML(phoneGap.getDevice().getManufacturer());
    model.setHTML(phoneGap.getDevice().getModel());
    panel.setWidget(rootWidget);
  }

  @UiHandler("backButton")
  protected void oBackButtonPressed(TapEvent event) {
    placeController.goTo(new OverviewPlace());
  }
}
