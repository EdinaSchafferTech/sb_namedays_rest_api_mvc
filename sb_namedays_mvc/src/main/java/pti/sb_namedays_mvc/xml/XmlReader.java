package pti.sb_namedays_mvc.xml;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Component;

import pti.sb_namedays_mvc.model.Nameday;

@Component
public class XmlReader {

	public Iterable<Nameday> read(String xml) {

		List<Nameday> namedays = new ArrayList<>();

		try {
			SAXBuilder saxBuilder = new SAXBuilder();
			Document document = saxBuilder.build(new StringReader(xml));

			Element root = document.getRootElement();

			for (Element element : root.getChildren("nameday")) {

				String name = element.getChildText("name");
				String date = element.getChildText("date");

				Nameday nameday = new Nameday( name, date);

				namedays.add(nameday);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return namedays;
	}
}
