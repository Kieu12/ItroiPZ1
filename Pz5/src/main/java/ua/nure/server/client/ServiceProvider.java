package ua.nure.server.client;

import ua.nure.service.AirplaneService;
import ua.nure.service.Airplane;

import java.net.MalformedURLException;
import java.net.URL;

public class ServiceProvider {
	private static AirplaneService airplanes;
	private static String url;
	
	protected ServiceProvider() {}
	
	private static AirplaneService getDefaultAirplane() {
		Airplane port = new Airplane();
//		port.setHandlerResolver(portInfo -> List.of(new SecurityHandler()));
		return port.getAirplanePort();
	}
	
	private static AirplaneService getAirplanes(String url) throws MalformedURLException {
		Airplane port = new Airplane(new URL(url));
//		port.setHandlerResolver(portInfo -> List.of(new SecurityHandler()));
		return port.getAirplanePort();
	}
	
	public static synchronized AirplaneService getInstance(String url) {
		if (airplanes == null) {
			if (url == null) {
				airplanes = getDefaultAirplane();
			} else {
				try {
					airplanes = getAirplanes(url);
				} catch (MalformedURLException e) {
					airplanes = null;
				}
			}
		} else if (!url.equals(ServiceProvider.url)) {
			try {
				airplanes = getAirplanes(url);
				ServiceProvider.url = url;
			} catch (MalformedURLException e) {
				ServiceProvider.url = null;
				airplanes = null;
			}
		}
		return airplanes;
	}
}
