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
package com.googlecode.gwtphonegap.showcase.client;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableEvent;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableHandler;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutEvent;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutHandler;
import com.googlecode.gwtphonegap.showcase.client.css.AppBundle;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;
import com.googlecode.mgwt.mvp.client.AnimationMapper;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.MGWTSettings.ViewPort;
import com.googlecode.mgwt.ui.client.layout.MasterRegionHandler;
import com.googlecode.mgwt.ui.client.layout.OrientationRegionHandler;
import com.googlecode.mgwt.ui.client.widget.animation.AnimationWidget;
import com.googlecode.mgwt.ui.client.widget.dialog.TabletPortraitOverlay;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ShowCaseEntryPoint implements EntryPoint {
  private Logger log = Logger.getLogger(getClass().getName());

  @Override
  public void onModuleLoad() {

    GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {

      @Override
      public void onUncaughtException(Throwable e) {
        Window.alert("uncaught: " + e.getLocalizedMessage());
        Window.alert(e.getMessage());
        log.log(Level.SEVERE, "uncaught exception", e);
      }
    });

    final PhoneGap phoneGap = GWT.create(PhoneGap.class);

    phoneGap.addHandler(new PhoneGapAvailableHandler() {

      @Override
      public void onPhoneGapAvailable(PhoneGapAvailableEvent event) {
        startShowCase(phoneGap);

      }
    });

    phoneGap.addHandler(new PhoneGapTimeoutHandler() {

      @Override
      public void onPhoneGapTimeout(PhoneGapTimeoutEvent event) {
        Window.alert("can not load phonegap");

      }
    });

    phoneGap.initializePhoneGap();

  }

  private void startShowCase(PhoneGap phoneGap) {
    final ClientFactoryGwtImpl clientFactory = new ClientFactoryGwtImpl();
    clientFactory.setPhoneGap(phoneGap);

    buildDisplay(clientFactory);

  }

  private void buildDisplay(ClientFactory clientFactory) {

    ViewPort viewPort = new MGWTSettings.ViewPort();
    viewPort.setUserScaleAble(false).setMinimumScale(1.0).setMinimumScale(1.0).setMaximumScale(1.0);

    MGWTSettings settings = new MGWTSettings();
    settings.setViewPort(viewPort);
    settings.setIconUrl("logo.png");
    settings.setFullscreen(true);
    settings.setPreventScrolling(true);

    MGWT.applySettings(settings);

    // Start PlaceHistoryHandler with our PlaceHistoryMapper
    AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
    final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);

    historyHandler.register(clientFactory.getPlaceController(), clientFactory.getEventBus(),
        new OverviewPlace());

    if (MGWT.getOsDetection().isTablet()) {

      // very nasty workaround because GWT does not corretly support
      // @media
      StyleInjector.inject(AppBundle.INSTANCE.css().getText());

      createTabletDisplay(clientFactory);
    } else {

      createPhoneDisplay(clientFactory);

    }
    historyHandler.handleCurrentHistory();

  }

  private void createPhoneDisplay(ClientFactory clientFactory) {
    AnimationWidget animationWidget = new AnimationWidget();

    PhoneActivityMapper appActivityMapper = new PhoneActivityMapper(clientFactory);

    PhoneAnimationMapper appAnimationMapper = new PhoneAnimationMapper();

    AnimatingActivityManager activityManager =
        new AnimatingActivityManager(appActivityMapper, appAnimationMapper, clientFactory
            .getEventBus());

    activityManager.setDisplay(animationWidget);

    RootPanel.get().add(animationWidget);

  }

  private void createTabletDisplay(ClientFactory clientFactory) {
    SimplePanel navContainer = new SimplePanel();
    navContainer.getElement().setId("nav");
    navContainer.getElement().addClassName("landscapeonly");
    AnimationWidget navAnimationWidget = new AnimationWidget();

    final TabletPortraitOverlay tabletPortraitOverlay = new TabletPortraitOverlay();

    new OrientationRegionHandler(navContainer, tabletPortraitOverlay, navAnimationWidget);
    new MasterRegionHandler(clientFactory.getEventBus(), "nav", tabletPortraitOverlay);

    ActivityMapper navActivityMapper = new TabletNavActivityMapper(clientFactory);

    AnimationMapper navAnimationMapper = new TabletNavAnimationMapper();

    AnimatingActivityManager navActivityManager =
        new AnimatingActivityManager(navActivityMapper, navAnimationMapper, clientFactory
            .getEventBus());

    navActivityManager.setDisplay(navAnimationWidget);

    RootPanel.get().add(navContainer);

    SimplePanel mainContainer = new SimplePanel();
    mainContainer.getElement().setId("main");
    AnimationWidget mainAnimationWidget = new AnimationWidget();

    TabletMainActivityMapper tabletMainActivityMapper = new TabletMainActivityMapper(clientFactory);

    AnimationMapper tabletMainAnimationMapper = new TabletMainAnimationMapper();

    AnimatingActivityManager mainActivityManager =
        new AnimatingActivityManager(tabletMainActivityMapper, tabletMainAnimationMapper,
            clientFactory.getEventBus());

    mainActivityManager.setDisplay(mainAnimationWidget);
    mainContainer.setWidget(mainAnimationWidget);

    RootPanel.get().add(mainContainer);
  }
}
