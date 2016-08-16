package lleme.letstalk.node;

import java.util.ArrayList;

import corbaObjects.scs.ComponentDescription;
import corbaObjects.scs.ComponentId;

public class ComponentsInfoBuilder implements Builder {
	private ComponentInfo[] result = null;

	@SuppressWarnings("unchecked")
	public void build(MetadataElement[] elements)
			throws InvalidSourceContentException, NumberFormatException {
		boolean fail = true;
		boolean fName = false, fVersion = false, fEntryPoint = false, fShared = false, fFilename = false, fHelpInfo = false;
		String name = null;
		int version = 0;
		String entryPoint = null;
		boolean shared = false;
		String filename = null;
		String helpInfo = null;
		ComponentInfo component = null;
		ArrayList components = new ArrayList();
		int end = 0;
		if (elements != null)
			end = elements.length;

		for (int i = 0; i < end; i++) {
			if (elements[i] != null
					&& elements[i].getQname().equals("component")) {
				fName = false;
				fVersion = false;
				fEntryPoint = false;
				fShared = false;
				fFilename = false;
				fHelpInfo = false;

			} else if (elements[i] != null
					&& elements[i].getQname().equals("name")) {
				name = elements[i].getValue();
				fName = true;
			} else if (elements[i] != null
					&& elements[i].getQname().equals("version")) {
				version = Integer.valueOf(elements[i].getValue()).intValue();
				fVersion = true;
			} else if (elements[i] != null
					&& elements[i].getQname().equals("entry-point")) {
				entryPoint = elements[i].getValue();
				fEntryPoint = true;
			} else if (elements[i] != null
					&& elements[i].getQname().equals("shared")) {
				shared = Boolean.valueOf(elements[i].getValue()).booleanValue();
				fShared = true;
			} else if (elements[i] != null
					&& elements[i].getQname().equals("filename")) {
				filename = elements[i].getValue();
				fFilename = true;
			} else if (elements[i] != null
					&& elements[i].getQname().equals("help-info")) {
				helpInfo = elements[i].getValue();
				fHelpInfo = true;
			}

			if (fName && fVersion && fEntryPoint && fShared && fFilename
					&& fHelpInfo) {
				fail = false;
				component = new ComponentInfo();
				component.desc = new ComponentDescription();
				component.desc.id = new ComponentId();
				component.desc.id.name = name;
				component.desc.id.version = version;
				component.desc.entry_point = entryPoint;
				component.desc.shared = shared;
				component.desc.help_info = helpInfo;
				component.filename = filename;
				components.add(component);
			}
		}
		if (!components.isEmpty()) {
			components.trimToSize();
			result = (ComponentInfo[]) components.toArray(new ComponentInfo[0]);
		} else
			throw new InvalidSourceContentException(
					"Building InformationResource: invalid source content");
	}

	public Object getResult() {
		return result;
	}
}
