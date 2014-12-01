package edu.udistrital.controller;

import org.zkoss.gmaps.Gmarker;
import org.zkoss.gmaps.event.MapMouseEvent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;

public class MapaController extends SelectorComposer<Component> {
	@Wire
	private Gmarker marker;
	
	public MapaController() {
		// TODO Auto-generated constructor stub

	}

	@Listen("onMapClick = #gmaps")
	public void onMapClick(MapMouseEvent event) {
//		marker = new Gmarker("Nuevo punto seleccionado",
//				event.getLat(), event.getLng());
//
//		if (marker != null) {
//			System.out.println("*-*-*" + marker.getLat());
//			System.out.println("*-*-*" + marker.getLng());
//		
//			marker.setOpen(true);
//		}
		
		System.out.println("*-*-*" + marker);
		marker.setOpen(true);
	}
}
