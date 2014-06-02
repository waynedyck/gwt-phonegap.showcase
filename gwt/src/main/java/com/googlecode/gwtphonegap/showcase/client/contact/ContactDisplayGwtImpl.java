package com.googlecode.gwtphonegap.showcase.client.contact;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import com.googlecode.gwtphonegap.showcase.client.BasicCell;
import com.googlecode.gwtphonegap.showcase.client.model.DemoContact;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.resource.MainResourceHolder;
import com.googlecode.mgwt.ui.client.widget.header.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.input.search.MSearchBox;
import com.googlecode.mgwt.ui.client.widget.list.celllist.CellList;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;

import java.util.List;

public class ContactDisplayGwtImpl extends Composite implements ContactDisplay {

	private static ContactDisplayGwtImplUiBinder uiBinder = GWT.create(ContactDisplayGwtImplUiBinder.class);

	interface ContactDisplayGwtImplUiBinder extends UiBinder<Widget, ContactDisplayGwtImpl> {
	}

	@UiField
	MSearchBox searchBox;
	private Presenter presenter;

	@UiField
	HeaderButton backButton;

	@UiField
	ScrollPanel scrollPanel;

	@UiField(provided = true)
	CellList<DemoContact> cellList;

	public ContactDisplayGwtImpl() {

		BasicCell<DemoContact> cell = new BasicCell<DemoContact>() {

			@Override
			public String getDisplayString(DemoContact model) {
				return model.getName();
			}

			@Override
			public boolean canBeSelected(DemoContact model) {
				return false;
			}
		};

		cellList = new CellList<DemoContact>(cell);

		initWidget(uiBinder.createAndBindUi(this));

		if (MGWT.getOsDetection().isTablet()) {
			backButton.setBackButton(false);
			backButton.setText("Modules");
			backButton.addStyleName(MainResourceHolder.getUtilCss().portraitonly());
		}
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;

	}

	@Override
	public void display(List<DemoContact> contacts) {
		cellList.render(contacts);
		scrollPanel.refresh();

	}

	@UiHandler("searchBox")
	protected void onSearchBoxTyped(ValueChangeEvent<String> event) {
	  presenter.onSearchTermEntered(event.getValue());
	}

	@UiHandler("backButton")
	protected void oBackButtonPressed(TapEvent event) {
		if (presenter != null) {
			presenter.onBackButtonPressed();
		}
	}

}
