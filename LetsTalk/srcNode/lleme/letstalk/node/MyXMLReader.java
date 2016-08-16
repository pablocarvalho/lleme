package lleme.letstalk.node;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class MyXMLReader extends Reader {
	private String text = null;

	private ArrayList elements = new ArrayList();

	private MetadataElement current = null;

	public MyXMLReader(Builder builder) {
		super(builder);
	}

	@SuppressWarnings("unchecked")
	public MetadataElement[] parse(InputSource source)
			throws ParserConfigurationException, SAXException, IOException,
			InvalidSourceContentException {
		MetadataElement[] result = null;
		elements = new ArrayList();
		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setValidating(false);
		SAXParser saxParser = spf.newSAXParser();
		XMLReader reader = saxParser.getXMLReader();
		reader.setContentHandler(this);
		reader.parse(source);
		elements.trimToSize();
		result = (MetadataElement[]) elements.toArray(new MetadataElement[0]);
		if (getBuilder() != null)
			getBuilder().build(result);
		return result;
	}

	@SuppressWarnings("unchecked")
	public void startElement(String uri, String name, String qName,
			Attributes atts) {
		current = new MetadataElement(uri, name, qName, atts);
		elements.add(current);
		text = new String();

	}

	public void endElement(String uri, String name, String qName) {
		if (current != null && text != null) {
			current.setValue(text.trim());
		}
		current = null;
	}

	public void characters(char[] ch, int start, int length) {
		if (current != null && text != null) {
			String value = new String(ch, start, length);
			text += value;
		}
	}
}
