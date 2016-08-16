package lleme.letstalk.scs.node;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.Attributes;

import org.omg.CORBA.ORB;

import corbaObjects.scs.IComponentPOA;

class JarClassLoader extends URLClassLoader {
	private URL url;

	private ORB orb = null;

	private ContainerServant container = null;

	private int version = 0;

	public JarClassLoader(URL url, ORB orb, ContainerServant container,
			int version) {
		super(new URL[] { url });
		this.url = url;
		this.orb = orb;
		this.container = container;
		this.version = version;
	}

	public String getMainClassName() throws IOException {
		URL u = new URL("jar", ":", url + "!/");
		JarURLConnection uc = (JarURLConnection) u.openConnection();
		uc.getJarFile();
		Attributes attr = uc.getMainAttributes();
		return attr != null ? attr.getValue(Attributes.Name.MAIN_CLASS) : null;
	}

	public IComponentPOA invokeClass(String name, String[] args)
			throws ClassNotFoundException, NoSuchMethodException,
			InvocationTargetException, IllegalArgumentException,
			IllegalAccessException {
		Class c = loadClass(name);
		Method m = c.getMethod("main", new Class[] { org.omg.CORBA.ORB.class,
				ContainerServant.class, int.class });
		m.setAccessible(true);
		int mods = m.getModifiers();
		if (!IComponentPOA.class.isAssignableFrom(m.getReturnType())
				|| !Modifier.isStatic(mods) || !Modifier.isPublic(mods)) {
			throw new NoSuchMethodException("main");
		}
		return (IComponentPOA) m.invoke(null, new Object[] { orb, container,
				version });
	}
}
