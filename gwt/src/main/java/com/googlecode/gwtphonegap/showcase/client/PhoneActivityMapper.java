/*
 * Copyright 2010 Daniel Kurka
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.showcase.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.googlecode.gwtphonegap.showcase.client.about.AboutActivity;
import com.googlecode.gwtphonegap.showcase.client.accelerometer.AccelerometerActivity;
import com.googlecode.gwtphonegap.showcase.client.camera.CameraActivity;
import com.googlecode.gwtphonegap.showcase.client.compass.CompassActivity;
import com.googlecode.gwtphonegap.showcase.client.connection.ConnectionActivity;
import com.googlecode.gwtphonegap.showcase.client.contact.ContactActivity;
import com.googlecode.gwtphonegap.showcase.client.device.DeviceActivity;
import com.googlecode.gwtphonegap.showcase.client.event.EventActivity;
import com.googlecode.gwtphonegap.showcase.client.file.FileActivity;
import com.googlecode.gwtphonegap.showcase.client.geolocation.GeolocationActivity;
import com.googlecode.gwtphonegap.showcase.client.inappbrowser.InAppBrowserActivity;
import com.googlecode.gwtphonegap.showcase.client.media.MediaActivity;
import com.googlecode.gwtphonegap.showcase.client.notification.NotificationActivity;

/**
 * @author Daniel Kurka
 *
 */
public class PhoneActivityMapper implements ActivityMapper {

	private final ClientFactory clientFactory;

	public PhoneActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof OverviewPlace) {
			return new OverviewActivity(clientFactory);
		}
		if (place instanceof AccelerometerActivity.MyPlace) {
			return new AccelerometerActivity(clientFactory);
		}

		if (place instanceof CameraActivity.MyPlace) {
			return new CameraActivity(clientFactory);
		}

		if (place instanceof CompassActivity.MyPlace) {
			return new CompassActivity(clientFactory);
		}

		if (place instanceof ConnectionActivity.MyPlace) {
			return new ConnectionActivity(clientFactory);
		}

		if (place instanceof ContactActivity.MyPlace) {
			return new ContactActivity(clientFactory);
		}

		if (place instanceof DeviceActivity.MyPlace) {
			return new DeviceActivity(clientFactory);
		}

		if (place instanceof EventActivity.MyPlace) {
			return new EventActivity(clientFactory);
		}

		if (place instanceof GeolocationActivity.MyPlace) {
			return new GeolocationActivity(clientFactory);
		}

		if (place instanceof MediaActivity.MyPlace) {
			return new MediaActivity(clientFactory);
		}

		if (place instanceof NotificationActivity.MyPlace) {
			return new NotificationActivity(clientFactory);
		}

		if (place instanceof InAppBrowserActivity.MyPlace) {
			return new InAppBrowserActivity(clientFactory);
		}

		if (place instanceof AboutActivity.MyPlace) {
			return new AboutActivity(clientFactory.getPlaceController());
		}

		if (place instanceof FileActivity.MyPlace) {
			return new FileActivity(clientFactory);
		}
		return null;
	}
}
