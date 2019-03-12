package nz.eater.api.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import nz.eater.util.FileReader;
import nz.eater.util.yaml.Yaml;

public class PlacesGenerator {

	private static final Logger log = LoggerFactory.getLogger(PlacesGenerator.class);

	@Inject
	private FileReader fileReader;

	@Inject
	private Yaml yaml;

	private ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

	public void generate() {
		try {
			List<File> files = new ArrayList<>();
			listAllPlaces("./data/places", files);
			log.debug("Found {} files", files.size());

			List<Place> places = new ArrayList<>();
			for (File file : files) {
				places.add(this.yaml.decode(this.fileReader.readFile(file.getAbsolutePath()), Place.class));
			}
			fileReader.writeFile("./out/places.json", mapper.writeValueAsString(places));

		} catch (Exception e) {
			log.error("Problem when converting places", e);
		}
	}

	public void listAllPlaces(String directoryName, List<File> files) {
		File directory = new File(directoryName);

		// Get all files from a directory.
		File[] fList = directory.listFiles();
		if (fList != null)
			for (File file : fList) {
				if (file.isFile() && file.getName().endsWith(".place")) {
					files.add(file);
				} else if (file.isDirectory()) {
					listAllPlaces(file.getAbsolutePath(), files);
				}
			}
	}
}
