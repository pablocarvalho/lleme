package lleme.letstalk.scs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import corbaObjects.scs.ComponentAlreadyInstalled;
import corbaObjects.scs.ComponentDescription;
import corbaObjects.scs.ComponentId;
import corbaObjects.scs.ComponentNotInstalled;
import corbaObjects.scs.ComponentRepository;
import corbaObjects.scs.ComponentRepositoryPOA;
import corbaObjects.scs.IOException;

public class ComponentRepositoryServant extends ComponentRepositoryPOA {

	private String catalogFilename = null;

	private HashMap components = null;

	public ComponentRepositoryServant() {
		catalogFilename = "componentsCatalog.dat";
		try {
			load();
		} catch (ClassNotFoundException e) {
			components = new HashMap();
		} catch (java.io.IOException e) {
			components = new HashMap();
		}
	}

	@SuppressWarnings("unchecked")
	public void install(ComponentId id, String entry_point, boolean shared,
			byte[] file, String help_info) throws ComponentAlreadyInstalled,
			IOException {
		if (components.get(id.name + id.version) != null)
			throw new ComponentAlreadyInstalled();
		ComponentDescription desc = new ComponentDescription();
		desc.id = id;
		desc.entry_point = entry_point;
		desc.shared = shared;
		desc.help_info = help_info;
		try {
			FileOutputStream out = new FileOutputStream(id.name + id.version
					+ ".jar");
			out.write(file);
			out.close();
			components.put(id.name + id.version, desc);
			save();
		} catch (FileNotFoundException e) {
			throw new IOException("Filename incorreto para componente");
		} catch (java.io.IOException e) {
			throw new IOException("Erro na gravação do arquivo do componente");
		}
	}

	public void uninstall(ComponentId id) throws ComponentNotInstalled,
			IOException {
		if (components.get(id.name + id.version) == null)
			throw new ComponentNotInstalled();
		File file = new File(id.name + id.version + ".jar");
		file.delete();
		components.remove(id.name + id.version);
		try {
			save();
		} catch (java.io.IOException e) {
			throw new IOException("Filename incorreto para componente");
		}
	}

	@SuppressWarnings( { "unused", "unused" })
	public void copy(ComponentId id, ComponentRepository rep)
			throws ComponentAlreadyInstalled, ComponentNotInstalled {
		// TODO Auto-generated method stub

	}

	public byte[] getComponentFile(ComponentId id)
			throws ComponentNotInstalled, IOException {
		if (components.get(id.name + id.version) == null)
			throw new ComponentNotInstalled();
		FileInputStream in = null;
		byte[] file = null;
		try {
			in = new FileInputStream(id.name + id.version + ".jar");
			in.read(file = new byte[in.available()]);
			in.close();
		} catch (FileNotFoundException e) {
			throw new IOException("Arquivo " + id.name + id.version + ".jar"
					+ " não encontrado");
		} catch (java.io.IOException e) {
			throw new IOException("Erro na leitura do arquivo " + id.name
					+ id.version + ".jar");
		}
		return file;
	}

	public ComponentDescription getComponentDescription(ComponentId id)
			throws ComponentNotInstalled {
		ComponentDescription desc = null;
		if ((desc = (ComponentDescription) components.get(id.name + id.version)) == null)
			throw new ComponentNotInstalled();
		return desc;
	}

	@SuppressWarnings("unchecked")
	public ComponentDescription[] getInstalledComponents() {
		return (ComponentDescription[]) components.values().toArray(
				new ComponentDescription[0]);
	}

	private void load() throws ClassNotFoundException, java.io.IOException {
		if (components == null) {
			File file = new File(catalogFilename);
			if (file.exists()) {
				FileInputStream in = new FileInputStream(catalogFilename);
				ObjectInputStream s = new ObjectInputStream(in);
				components = (HashMap) s.readObject();
				s.close();
			} else {
				components = new HashMap();
				ObjectOutputStream s = null;
				FileOutputStream out = null;
				out = new FileOutputStream(catalogFilename);
				s = new ObjectOutputStream(out);
				s.writeObject(components);
				s.flush();
				s.close();
			}
		}
	}

	private void save() throws java.io.IOException {
		ObjectOutputStream s = null;
		FileOutputStream out = null;
		out = new FileOutputStream(catalogFilename);
		s = new ObjectOutputStream(out);
		s.writeObject(components);
		s.flush();
		s.close();
	}

}
