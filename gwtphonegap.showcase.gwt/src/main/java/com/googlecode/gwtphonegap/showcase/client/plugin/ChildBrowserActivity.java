package com.googlecode.gwtphonegap.showcase.client.plugin;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.plugins.childbrowser.ChildBrowser;
import com.googlecode.gwtphonegap.showcase.client.ClientFactory;
import com.googlecode.gwtphonegap.showcase.client.NavBaseActivity;

public class ChildBrowserActivity extends NavBaseActivity implements ChildBrowserDisplay.Presenter {

  private ChildBrowserDisplay display;
  private PhoneGap phoneGap;
  private ChildBrowser childBrowser;

  public ChildBrowserActivity(ClientFactory clientFactory) {
    super(clientFactory);

    this.display = clientFactory.getChildBrowserDisplay();
    this.phoneGap = clientFactory.getPhoneGap();

    childBrowser = (ChildBrowser) this.phoneGap.getPluginById("childBrowser");

  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    display.setPresenter(this);
    panel.setWidget(display);

  }

  @Override
  public void onOpenButtonPressed() {
    childBrowser.showWebPage("http://www.google.de");

  }
}
