package com.googlecode.gwtphonegap.showcase.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtphonegap.client.PhoneGap;

public interface ClientFactory {
	public PhoneGap getPhoneGap();

	public PlaceController getPlaceController();

	public EventBus getEventBus();

	public OverviewDisplay getOverviewDisplay();
}
