package com.googlecode.gwtphonegap.showcase.client.plugin;

import com.google.gwt.user.client.ui.IsWidget;

public interface ChildBrowserDisplay extends IsWidget {
	public void setPresenter(Presenter presenter);

	public interface Presenter {

		public void onBackButtonPressed();

		public void onOpenButtonPressed();

	}

}