package com.googlecode.gwtphonegap.showcase.client.camera;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.base.ButtonBase;

public class CameraDisplayGwtImpl extends Composite implements CameraDisplay {

	private static CameraDisplayGwtImplUiBinder uiBinder = GWT.create(CameraDisplayGwtImplUiBinder.class);
	private Presenter presenter;

	interface CameraDisplayGwtImplUiBinder extends UiBinder<Widget, CameraDisplayGwtImpl> {
	}

	@UiField
	ButtonBase cameraButton;

	@UiField
	ScrollPanel scrollPanel;

	@UiField
	HeaderButton backButton;

	@UiField
	Image image;

	public CameraDisplayGwtImpl() {

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

	@Override
	public void displayFoto(String data) {
		image.setUrl(data);
		scrollPanel.refresh();

	}

	@UiHandler("cameraButton")
	protected void onCameraButtonPressed(TapEvent event) {
		if (presenter != null) {
			presenter.onCameraButtonPressed();
		}
	}

	@UiHandler("backButton")
	protected void onBackButtonPressed(TapEvent event) {
		if (presenter != null) {
			presenter.onBackButtonPressed();
		}
	}

}
