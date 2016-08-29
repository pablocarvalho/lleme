/**
 * 
 */
package uff.ic.tcc00175.catfwk.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import uff.ic.tcc00175.catfwk.view.GeoCatalogAppWindow;
import uff.ic.tcc00175.catfwk.view.WspWindow;

/**
 * @author Luiz Leme*/
public class SaveDocumentAction implements ActionListener {
	private final GeoCatalogAppWindow catAppWindow;

	/**
	 * @param window
	 */
	public SaveDocumentAction(GeoCatalogAppWindow window) {
		catAppWindow = window;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			((WspWindow) catAppWindow.getJDesktopPane().getSelectedFrame())
					.saveWspWindow();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(catAppWindow, e1.getMessage());
		}
	}
}