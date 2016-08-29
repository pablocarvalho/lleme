/**
 * 
 */
package uff.ic.tcc00175.catfwk.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uff.ic.tcc00175.catfwk.view.GeoCatalogAppWindow;

/**
 * @author Luiz Leme*/
public class AddProcMenuItemAction implements ActionListener {
	private GeoCatalogAppWindow catAppWindow;

	/**
	 * @param window
	 */
	public AddProcMenuItemAction(GeoCatalogAppWindow window) {
		catAppWindow = window;
	}

	public void actionPerformed(ActionEvent e) {
		catAppWindow.getAddUpdateButton().setAction(
				catAppWindow.getAddProcessAction());
		catAppWindow.getAddUpdateButton().setText("Add");
		catAppWindow.getProcessDialog().setVisible(true);
	}
}