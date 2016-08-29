/**
 * 
 */
package uff.ic.tcc00175.catfwk.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uff.ic.tcc00175.catfwk.view.GeoCatalogAppWindow;

/**
 * @author Luiz Leme*/
public class ExitApplicationAction implements ActionListener {
	private GeoCatalogAppWindow catAppWindow;

	/**
	 * @param window
	 */
	public ExitApplicationAction(GeoCatalogAppWindow window) {
		catAppWindow = window;
	}

	public void actionPerformed(ActionEvent e) {
		catAppWindow.exitForm();
	}
}