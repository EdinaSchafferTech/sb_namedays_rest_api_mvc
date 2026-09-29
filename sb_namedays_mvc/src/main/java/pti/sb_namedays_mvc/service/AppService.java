package pti.sb_namedays_mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import pti.sb_namedays_mvc.dto.NamedayDTO;
import pti.sb_namedays_mvc.dto.XmlResponseDTO;
import pti.sb_namedays_mvc.model.Nameday;
import pti.sb_namedays_mvc.xml.XmlReader;

@Service
public class AppService {

	private RestClient restClient;
	private XmlReader xmlReader;

	@Autowired
	public AppService(XmlReader xmlReader) {
		super();
		this.restClient = RestClient.create();
		this.xmlReader = xmlReader;
	}

	public XmlResponseDTO getXml() {

		return restClient.get().uri("http://localhost:8080/namedays").retrieve().body(XmlResponseDTO.class);

	}

	public Iterable<NamedayDTO> getNameDays() {

		XmlResponseDTO response = getXml();

		String xml = response.getXml();

		Iterable<Nameday> namedays = xmlReader.read(xml);

		List<NamedayDTO> namedayDTOs = new ArrayList<>();

		for (Nameday nameday : namedays) {

			NamedayDTO dto = new NamedayDTO(nameday.getName(), nameday.getDate());

			namedayDTOs.add(dto);
		}

		return namedayDTOs;
	}

}
