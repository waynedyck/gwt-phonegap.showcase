package com.googlecode.gwtphonegap.showcase.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.googlecode.gwtphonegap.client.PhoneGap;

public class ClientFactoryGwtImpl implements ClientFactory {

	private PhoneGap phoneGap;
	private SimpleEventBus eventBus;
	private PlaceController placeController;
	private OverviewDisplay overviewDisplay;

	public ClientFactoryGwtImpl() {
		eventBus = new SimpleEventBus();

		placeController = new PlaceController(eventBus);
	}

	public void setPhoneGap(PhoneGap phoneGap) {
		this.phoneGap = phoneGap;
	}

	@Override
	public PhoneGap getPhoneGap() {
		return phoneGap;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public OverviewDisplay getOverviewDisplay() {
		if (overviewDisplay == null) {
			overviewDisplay = new OverviewDisplayGwtImpl();
		}
		return overviewDisplay;
	}
}
