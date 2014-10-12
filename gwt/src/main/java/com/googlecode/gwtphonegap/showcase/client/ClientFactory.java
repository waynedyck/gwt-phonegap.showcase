package com.googlecode.gwtphonegap.showcase.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.showcase.client.compass.CompassDisplay;
import com.googlecode.gwtphonegap.showcase.client.connection.ConnectionDisplay;
import com.googlecode.gwtphonegap.showcase.client.contact.ContactDisplay;
import com.googlecode.gwtphonegap.showcase.client.device.DeviceDisplay;
import com.googlecode.gwtphonegap.showcase.client.event.EventDisplay;
import com.googlecode.gwtphonegap.showcase.client.file.FileDisplay;
import com.googlecode.gwtphonegap.showcase.client.geolocation.GeolocationDisplay;
import com.googlecode.gwtphonegap.showcase.client.inappbrowser.InAppBrowserDisplay;
import com.googlecode.gwtphonegap.showcase.client.media.MediaDisplay;
import com.googlecode.gwtphonegap.showcase.client.notification.NotificationDisplay;

public interface ClientFactory {
	public PhoneGap getPhoneGap();

	public PlaceController getPlaceController();

	public EventBus getEventBus();

	public OverviewDisplay getOverviewDisplay();

	public CompassDisplay getCompassDisplay();

	public ConnectionDisplay getConnectionDisplay();

	public ContactDisplay getContactDisplay();

	public DeviceDisplay getDeviceDisplay();

	public EventDisplay getEventDisplay();

	public GeolocationDisplay getGeolocationDisplay();

	public MediaDisplay getMediaDisplay();

	public NotificationDisplay getNotificationDisplay();

	public InAppBrowserDisplay getChildBrowserDisplay();

	public FileDisplay getFileDisplay();
}
