package nz.eater.util.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;

public class Yaml {

	private ObjectMapper mapper;

	{
		YAMLFactory yaml = new YAMLFactory();
		yaml.configure(Feature.MINIMIZE_QUOTES, true);
		yaml.configure(Feature.INDENT_ARRAYS, true);
		yaml.configure(Feature.WRITE_DOC_START_MARKER, false);
		mapper = new ObjectMapper(yaml);
	}

	public String encode(Object object) throws YamlException {
		try {
			return mapper.writeValueAsString(object);
		} catch (Exception e) {
			throw new YamlException("Problem when encoding object to YAML", e);
		}
	}

	public <Type> Type decode(String text, Class<Type> type) throws YamlException {
		try {
			return mapper.readValue(text, type);
		} catch (Exception e) {
			throw new YamlException("Problem when decoding object from YAML", e);
		}
	}

}
