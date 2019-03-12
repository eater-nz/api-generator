package nz.eater.api.generator;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.espr.injector.Injector;

public class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);

	@Inject
	private PlacesGenerator placesGenerator;

	public static final void main(String[] params) {
		System.out.println("running");
		Injector.injector().get(Main.class).run();
	}

	private void run() {
		this.placesGenerator.generate();
	}
}
