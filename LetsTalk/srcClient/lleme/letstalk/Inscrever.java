package lleme.letstalk;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

import corbaObjects.letstalk.usermanager.UserManagerFacet;
import corbaObjects.letstalk.usermanager.UserManagerFacetHelper;
import corbaObjects.letstalk.usermanager.enum_type;

public class Inscrever extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8605904716664257217L;

	private JTextField usern;

	private JPasswordField pw;

	public Inscrever(JFrame frInscrever) {
		super(frInscrever, true);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));
		panel.add(new JLabel("User name:"));
		panel.add(usern = new JTextField(""));
		panel.add(new JLabel("Password:"));
		panel.add(pw = new JPasswordField(""));
		add(panel, BorderLayout.CENTER);
		JButton ok = new JButton("Ok");
		// inserir ações do botão OK
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					org.omg.CORBA.ORB orb = null;
					String[] args = new String[2];
					args[0] = "-ORBInitialPort";
					args[1] = "2900";
					// args[2] = "-ORBInitialHost";
					// args[3] = "192.168.254.1";
					orb = ORB.init(args, null);

					UserManagerFacet userManager = null;
					NamingContextExt nc = null;
					POA poa = null;
					nc = NamingContextExtHelper.narrow(orb
							.resolve_initial_references("TNameService"));
					poa = POAHelper.narrow(orb
							.resolve_initial_references("RootPOA"));
					poa.the_POAManager().activate();
					userManager = UserManagerFacetHelper.narrow(nc.resolve(nc
							.to_name("userManager")));

					// String ior = null;
					// BufferedReader in;
					// in = new BufferedReader(new FileReader(
					// LetsTalk.USER_MANAGER_IOR));
					// ior = in.readLine();
					// in.close();
					// userManager = UserManagerHelper.narrow(orb
					// .string_to_object(ior));

					if (userManager.subscribe(usern.getText(), pw.getText()) == enum_type.OK)
						JOptionPane.showMessageDialog(getOwner().getOwner()
								.getOwner(), "OK");
					else
						JOptionPane.showMessageDialog(getOwner().getOwner(),
								"Erro");
				} catch (InvalidName e) {
					JOptionPane.showMessageDialog(getOwner().getOwner()
							.getOwner(), e.getMessage());
				} catch (AdapterInactive e) {
					JOptionPane.showMessageDialog(getOwner().getOwner()
							.getOwner(), e.getMessage());
				} catch (NotFound e) {
					JOptionPane.showMessageDialog(getOwner().getOwner()
							.getOwner(), e.getMessage());
				} catch (CannotProceed e) {
					JOptionPane.showMessageDialog(getOwner().getOwner()
							.getOwner(), e.getMessage());
				} catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
					JOptionPane.showMessageDialog(getOwner().getOwner()
							.getOwner(), e.getMessage());
				}
			}
		});
		panel.add(ok);
		setSize(200, 100);
	}

	public void setUserName(String u) {
		usern.setText(u);
	}

	public String getUserName() {
		return (usern.getText());
	}

	public void setPassword(String p) {
		pw.setText(p);
	}

	public String getPassword() {
		return (pw.getText());
	}
}
