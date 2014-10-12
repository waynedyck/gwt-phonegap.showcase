package com.googlecode.gwtphonegap.showcase.client.event;

import java.util.Date;
import java.util.LinkedList;

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
import com.googlecode.gwtphonegap.client.event.BackButtonPressedEvent;
import com.googlecode.gwtphonegap.client.event.BackButtonPressedHandler;
import com.googlecode.gwtphonegap.client.event.MenuButtonPressedEvent;
import com.googlecode.gwtphonegap.client.event.MenuButtonPressedHandler;
import com.googlecode.gwtphonegap.client.event.OffLineEvent;
import com.googlecode.gwtphonegap.client.event.OffLineHandler;
import com.googlecode.gwtphonegap.client.event.OnlineEvent;
import com.googlecode.gwtphonegap.client.event.OnlineHandler;
import com.googlecode.gwtphonegap.client.event.PauseEvent;
import com.googlecode.gwtphonegap.client.event.PauseHandler;
import com.googlecode.gwtphonegap.client.event.ResumeEvent;
import com.googlecode.gwtphonegap.client.event.ResumeHandler;
import com.googlecode.gwtphonegap.client.event.SearchButtonPressedEvent;
import com.googlecode.gwtphonegap.client.event.SearchButtonPressedHandler;
import com.googlecode.gwtphonegap.showcase.client.BasicCell;
import com.googlecode.gwtphonegap.showcase.client.ClientFactory;
import com.googlecode.gwtphonegap.showcase.client.OverviewPlace;
import com.googlecode.gwtphonegap.showcase.client.model.EventDemo;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.list.celllist.CellList;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;

public class EventActivity extends MGWTAbstractActivity {

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

  private final PhoneGap phoneGap;
  private Widget rootWidget;
  private PlaceController placeController;
  private LinkedList<EventDemo> list = new LinkedList<EventDemo>();

  private static Binder BINDER = GWT.create(Binder.class);
  interface Binder extends UiBinder<Widget, EventActivity> {}

  @UiField
  ScrollPanel scrollPanel;

  @UiField(provided = true)
  CellList<EventDemo> cellList;

  public EventActivity(ClientFactory clientFactory) {

    BasicCell<EventDemo> cell = new BasicCell<EventDemo>() {

      @Override
      public String getDisplayString(EventDemo model) {
        return model.getText();
      }
    };

    cellList = new CellList<EventDemo>(cell);

    placeController = clientFactory.getPlaceController();
    rootWidget = BINDER.createAndBindUi(this);
    this.phoneGap = clientFactory.getPhoneGap();

    phoneGap.getEvent().getBackButton().addBackButtonPressedHandler(new BackButtonPressedHandler() {

      @Override
      public void onBackButtonPressed(BackButtonPressedEvent event) {
        String res = "Back Button Pressed: " + new Date();
        addText(res);
      }
    });

    phoneGap.getEvent().getOffLineHandler().addOfflineHandler(new OffLineHandler() {

      @Override
      public void onOffLine(OffLineEvent event) {
        String res = "Offline Event: " + new Date();
        addText(res);
      }
    });

    phoneGap.getEvent().getOnlineHandler().addOnlineHandler(new OnlineHandler() {

      @Override
      public void onOnlineEvent(OnlineEvent event) {
        String res = "Online Event: " + new Date();
        addText(res);
      }
    });

    phoneGap.getEvent().getPauseHandler().addPauseHandler(new PauseHandler() {

      @Override
      public void onPause(PauseEvent event) {
        String res = "Pause Event: " + new Date();
        addText(res);
      }
    });

    phoneGap.getEvent().getResumeHandler().addResumeHandler(new ResumeHandler() {

      @Override
      public void onResumeEvent(ResumeEvent event) {
        String res = "Resume Event: " + new Date();
        addText(res);
      }
    });

    phoneGap.getEvent().getSearchButton().addSearchButtonHandler(new SearchButtonPressedHandler() {

      @Override
      public void onSearchButtonPressed(SearchButtonPressedEvent event) {
        String res = "Search Button Pressed Event: " + new Date();
        addText(res);
      }
    });

    phoneGap.getEvent().getMenuButton().addMenuButtonPressedHandler(new MenuButtonPressedHandler() {

      @Override
      public void onMenuButtonPressed(MenuButtonPressedEvent event) {
        String res = "Menu Button Pressed Event: " + new Date();
        addText(res);
      }
    });
  }

  private void addText(String text) {
    list.add(new EventDemo(text));
    render(list);
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    panel.setWidget(rootWidget);
  }

  @UiHandler("backButton")
  protected void oBackButtonPressed(TapEvent event) {
    placeController.goTo(new OverviewPlace());
  }

  public void render(LinkedList<EventDemo> list) {
    cellList.render(list);
    scrollPanel.refresh();
  }
}
