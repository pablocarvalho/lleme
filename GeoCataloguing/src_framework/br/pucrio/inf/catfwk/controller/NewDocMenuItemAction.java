/**
 * 
 */
package br.pucrio.inf.catfwk.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.pucrio.inf.catfwk.view.GeoCatalogAppWindow;

/**
 * @author Luiz Leme*/
public class NewDocMenuItemAction implements ActionListener {
	private GeoCatalogAppWindow catAppWindow;

	/**
	 * @param window
	 */
	public NewDocMenuItemAction(GeoCatalogAppWindow window) {
		catAppWindow = window;
	}

	public void actionPerformed(ActionEvent e) {
		catAppWindow.getNewOpenButton().setAction(
				catAppWindow.getNewDocumentAction());
		catAppWindow.getNewOpenButton().setActionCommand("New");
		catAppWindow.getNewOpenButton().setText("New");
		catAppWindow.getFilenameDialog().setVisible(true);
	}
}