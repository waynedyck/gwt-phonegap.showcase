package com.googlecode.gwtphonegap.showcase.client.plugin;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ChildBrowserPlace extends Place {
	public static class Tokenizer implements PlaceTokenizer<ChildBrowserPlace> {

		@Override
		public ChildBrowserPlace getPlace(String token) {
			return new ChildBrowserPlace();
		}

		@Override
		public String getToken(ChildBrowserPlace place) {
			return null;
		}

	}
}