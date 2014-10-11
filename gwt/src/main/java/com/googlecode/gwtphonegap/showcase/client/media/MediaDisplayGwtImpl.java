package com.googlecode.gwtphonegap.showcase.client.media;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.ui.client.widget.button.ButtonBase;
import com.googlecode.mgwt.ui.client.widget.header.HeaderButton;

public class MediaDisplayGwtImpl extends Composite implements MediaDisplay {

	private static MediaDisplayGwtImplUiBinder uiBinder = GWT.create(MediaDisplayGwtImplUiBinder.class);

	interface MediaDisplayGwtImplUiBinder extends UiBinder<Widget, MediaDisplayGwtImpl> {
	}

	@UiField
	HTML position;

	@UiField
	ButtonBase play;

	@UiField
	ButtonBase pause;

	@UiField
	HeaderButton backButton;

	private Presenter presenter;

	public MediaDisplayGwtImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;

	}

	@Override
	public HasHTML getPosition() {
		return position;
	}

	@Override
	public void showPlayButton(boolean show) {
		play.setVisible(show);

	}

	@Override
	public void showPauseButton(boolean show) {
		pause.setVisible(show);

	}

	@UiHandler("backButton")
	protected void oBackButtonPressed(TapEvent event) {
		if (presenter != null) {
			presenter.onBackButtonPressed();
		}
	}

	@UiHandler("pause")
	protected void onPauseButton(TapEvent event) {
		if (presenter != null) {
			presenter.onPauseButtonPressed();
		}
	}

	@UiHandler("play")
	protected void onPlayButton(TapEvent event) {
		if (presenter != null) {
			presenter.onPlayButtonPressed();
		}
	}

}
