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
import com.googlecode.gwtphonegap.showcase.client.connection.ConnectionPlace;
import com.googlecode.gwtphonegap.showcase.client.contact.ContactPlace;
import com.googlecode.gwtphonegap.showcase.client.device.DevicePlace;
import com.googlecode.gwtphonegap.showcase.client.event.EventPlace;
import com.googlecode.gwtphonegap.showcase.client.file.FilePlace;
import com.googlecode.gwtphonegap.showcase.client.geolocation.GeolocationPlace;
import com.googlecode.gwtphonegap.showcase.client.inappbrowser.InAppBrowserPlace;
import com.googlecode.gwtphonegap.showcase.client.media.MediaPlace;
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

		if (oldPlace instanceof OverviewPlace && newPlace instanceof ConnectionPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof ConnectionPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof ContactPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof ContactPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof DevicePlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof DevicePlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof EventPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof EventPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof GeolocationPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof GeolocationPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof MediaPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof MediaPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof NotificationPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof NotificationPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof InAppBrowserPlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof InAppBrowserPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof AboutActivity.MyPlace) {
			return Animations.SLIDE_UP;
		}

		if (oldPlace instanceof AboutActivity.MyPlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		if (oldPlace instanceof OverviewPlace && newPlace instanceof FilePlace) {
			return Animations.SLIDE;
		}

		if (oldPlace instanceof FilePlace && newPlace instanceof OverviewPlace) {
			return Animations.SLIDE_REVERSE;
		}

		return Animations.SLIDE;

	}
}
