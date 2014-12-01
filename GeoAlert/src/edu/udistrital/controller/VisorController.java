package edu.udistrital.controller;

import org.zkoss.gmaps.Ginfo;
import org.zkoss.gmaps.Gmaps;
import org.zkoss.gmaps.Gmarker;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Intbox;

public class VisorController extends SelectorComposer<Component> {

	@Wire
	private Gmaps gmaps;

	@Wire
	private Ginfo info;

	@Wire
	private Gmarker marker;

	@Wire
	private Doublebox latitude, longitude;

	@Wire
	private Intbox zoom;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		latitude.setValue(gmaps.getLat());
		longitude.setValue(gmaps.getLng());
		zoom.setValue(gmaps.getZoom());
	}

	@Listen("onChange = #latitude, #longitude")
	public void onPositionChange() {
		gmaps.panTo(latitude.getValue(), longitude.getValue());
	}

	@Listen("onChange = #zoom")
	public void onZoomChange() {
		gmaps.setZoom(zoom.getValue());
	}

	@Listen("onClick = #obtenerInformacion")
	public void obtenerInformacion() {
		System.out.println("------- |||" + gmaps);
		// System.out.println("------- |||" + info.getLng());

		if (gmaps != null) {
			info.setLat(gmaps.getLat());
			info.setLng(gmaps.getLng());
			
		}

		if (info.isOpen()) {
			marker.setOpen(true);
			info.setOpen(false);

		} else {
			marker.setOpen(false);
			info.setOpen(true);

		}
	}

	@Listen("onMapMove = #gmaps")
	public void onMapMove() {
		latitude.setValue(gmaps.getLat());
		longitude.setValue(gmaps.getLng());
	}

	@Listen("onMapZoom = #gmaps")
	public void onMapZoom() {
		zoom.setValue(gmaps.getZoom());
	}

}
