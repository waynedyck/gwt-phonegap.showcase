package com.googlecode.gwtphonegap.showcase.client.contact;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.contacts.Contact;
import com.googlecode.gwtphonegap.client.contacts.ContactError;
import com.googlecode.gwtphonegap.client.contacts.ContactFindCallback;
import com.googlecode.gwtphonegap.client.contacts.ContactFindOptions;
import com.googlecode.gwtphonegap.collection.shared.CollectionFactory;
import com.googlecode.gwtphonegap.collection.shared.LightArray;
import com.googlecode.gwtphonegap.showcase.client.BasicCell;
import com.googlecode.gwtphonegap.showcase.client.ClientFactory;
import com.googlecode.gwtphonegap.showcase.client.OverviewPlace;
import com.googlecode.gwtphonegap.showcase.client.model.DemoContact;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.input.search.MSearchBox;
import com.googlecode.mgwt.ui.client.widget.list.celllist.CellList;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;

public class ContactActivity extends MGWTAbstractActivity {

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
  interface Binder extends UiBinder<Widget, ContactActivity> {}

  private final PhoneGap phoneGap;
  private Widget rootWidget;
  private PlaceController placeController;

  @UiField
  MSearchBox searchBox;

  @UiField
  ScrollPanel scrollPanel;

  @UiField(provided = true)
  CellList<DemoContact> cellList;


  public ContactActivity(ClientFactory clientFactory) {
    placeController = clientFactory.getPlaceController();
    BasicCell<DemoContact> cell = new BasicCell<DemoContact>() {

      @Override
      public String getDisplayString(DemoContact model) {
        return model.getName();
      }

      @Override
      public boolean canBeSelected(DemoContact model) {
        return false;
      }
    };
    cellList = new CellList<DemoContact>(cell);
    rootWidget = BINDER.createAndBindUi(this);
    this.phoneGap = clientFactory.getPhoneGap();
  }

  public void display(List<DemoContact> contacts) {
    cellList.render(contacts);
    scrollPanel.refresh();
  }

  @UiHandler("backButton")
  protected void oBackButtonPressed(TapEvent event) {
    placeController.goTo(new OverviewPlace());
  }

  @UiHandler("searchBox")
  public void onSearchTermEntered(ValueChangeEvent<String> event) {

    String term = event.getValue();

    if (term == null)
      return;
    if ("".equals(term)) {
      return;
    }

    LightArray<String> fields = CollectionFactory.<String> constructArray();

    fields.push("displayName");
    fields.push("name");

    ContactFindOptions findOptions = new ContactFindOptions(term, true);

    phoneGap.getContacts().find(fields, new ContactFindCallback() {

      @Override
      public void onSuccess(LightArray<Contact> contacts) {

        LinkedList<DemoContact> list = new LinkedList<DemoContact>();

        for (int i = 0; i < contacts.length(); i++) {
          DemoContact contact = new DemoContact(contacts.get(i).getName().getFormatted());
          list.add(contact);
        }

        if (contacts.length() == 0) {
          list.add(new DemoContact("nothing found...."));
        }

        display(list);
      }

      @Override
      public void onFailure(ContactError error) {
        // TODO improve error display
        Window.alert("error while searching for contacts");
      }
    }, findOptions);
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    panel.setWidget(rootWidget);
  }
}
