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
import com.googlecode.gwtphonegap.showcase.client.notification.NotificationPlace;
import com.googlecode.mgwt.mvp.client.AnimationMapper;
import com.googlecode.mgwt.ui.client.widget.animation.Animation;
import com.googlecode.mgwt.ui.client.widget.animation.Animations;

/**
 * @author Daniel Kurka
 *
 */
public class PhoneAnimationMapper implements AnimationMapper {

	@Override
	public Animation getAnimation(Place oldPlace, Place newPlace) {

		if (oldPlace == null) {
			return Animations.FADE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof AccelerometerActivity.MyPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof AccelerometerActivity.MyPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof CameraActivity.MyPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof CameraActivity.MyPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof CompassActivity.MyPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof CompassActivity.MyPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof ConnectionActivity.MyPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof ConnectionActivity.MyPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof ContactActivity.MyPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof ContactActivity.MyPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof DeviceActivity.MyPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof DeviceActivity.MyPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof EventActivity.MyPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof EventActivity.MyPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof GeolocationActivity.MyPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof GeolocationActivity.MyPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof MediaActivity.MyPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof MediaActivity.MyPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof NotificationPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof NotificationPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof InAppBrowserActivity.MyPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof InAppBrowserActivity.MyPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof AboutActivity.MyPlace) {
			return Animations.SLIDE_UP;
		}

		if (oldPlace instanceof AboutActivity.MyPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof FileActivity.MyPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof FileActivity.MyPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}
		return Animations.SLIDE;
	}
}
