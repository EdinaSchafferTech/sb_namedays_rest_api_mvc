package pti.sb_namedays_rest.service;

import org.springframework.stereotype.Service;

import pti.sb_namedays_rest.dto.XmlResponseDTO;
import pti.sb_namedays_rest.model.Nameday;
import pti.sb_namedays_rest.repository.NamedayRepository;
import pti.sb_namedays_rest.xml.XmlGenerator;

@Service
public class AppService {

	private final XmlGenerator xmlgenerator;
	private final NamedayRepository namedayRepository;

	public AppService(XmlGenerator xmlgenerator, NamedayRepository namedayRepository) {
		super();
		this.xmlgenerator = xmlgenerator;
		this.namedayRepository = namedayRepository;
	}

	public Iterable<Nameday> findAll() {
		return namedayRepository.findAll();

	}

	public XmlResponseDTO getXml() {

		Iterable<Nameday> namedays = findAll();

		String xml = xmlgenerator.generate(namedays);

		return new XmlResponseDTO(xml);

	}
}
