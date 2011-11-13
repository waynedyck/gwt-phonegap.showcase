package com.googlecode.gwtphonegap.showcase.client.plugin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.base.ButtonBase;

public class ChildBrowserDisplayGwtImpl extends Composite implements ChildBrowserDisplay {

	private static ChildBrowserDisplayGwtImplUiBinder uiBinder = GWT.create(ChildBrowserDisplayGwtImplUiBinder.class);

	interface ChildBrowserDisplayGwtImplUiBinder extends UiBinder<Widget, ChildBrowserDisplayGwtImpl> {
	}

	@UiField
	HeaderButton backButton;

	@UiField
	ButtonBase browserButton;

	private Presenter presenter;

	public ChildBrowserDisplayGwtImpl() {
		initWidget(uiBinder.createAndBindUi(this));

		if (MGWT.getOsDetection().isTablet()) {
			backButton.setBackButton(false);
			backButton.setText("Modules");
			backButton.addStyleName(MGWTStyle.getTheme().getMGWTClientBundle().getUtilCss().portraitonly());
		}
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;

	}

	@UiHandler("backButton")
	protected void onBackButtonPressed(TapEvent event) {
		if (presenter != null) {
			presenter.onBackButtonPressed();
		}
	}

	@UiHandler("browserButton")
	protected void onBrowserButton(TapEvent event) {
		if (presenter != null) {
			presenter.onOpenButtonPressed();
		}
	}

}
