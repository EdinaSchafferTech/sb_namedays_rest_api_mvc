package pti.sb_namedays_rest.xml;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;
import org.springframework.stereotype.Component;

import pti.sb_namedays_rest.model.Nameday;

@Component
public class XmlGenerator {

	public String generate(Iterable<Nameday> namedays) {

		Element root = new Element("namedays");
		Document document = new Document(root);

		for (Nameday nameday : namedays) {

			Element namedayElement = new Element("nameday");

			Element nameElement = new Element("name");
			nameElement.setText(nameday.getName());

			Element dateElement = new Element("date");
			dateElement.setText(nameday.getDate());

			namedayElement.addContent(nameElement);
			namedayElement.addContent(dateElement);

			root.addContent(namedayElement);
		}
		XMLOutputter outputter = new XMLOutputter();

		return outputter.outputString(document);

	}
}
