package lleme.letstalk.node;

import org.xml.sax.Attributes;

public class MetadataElement {
	private String uri = null;

	private String localName = null;

	private String qName = null;

	private String value = null;

	private Attributes attributes = null;

	public MetadataElement(String uri, String localName, String qName,
			Attributes attributes) {
		this.uri = uri;
		this.localName = localName;
		this.qName = qName;
		this.attributes = attributes;
	}

	public String getUri() {
		return uri;
	}

	public String getLocalName() {
		return localName;
	}

	public String getQname() {
		return qName;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
