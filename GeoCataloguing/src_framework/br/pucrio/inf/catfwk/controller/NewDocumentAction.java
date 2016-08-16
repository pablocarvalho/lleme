package br.pucrio.inf.catfwk.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import br.pucrio.inf.catfwk.appmodel.GeoCatalogAppImpl;

/**
 * @author Luiz André
 * @version 1.0
 * @since 1.0
 * @alias NewDocumentAction*/
public class NewDocumentAction extends AbstractAction {

	private static final long serialVersionUID = 5245227434505555313L;
	private GeoCatalogAppImpl catAppImpl = null;

	public NewDocumentAction(GeoCatalogAppImpl catAppImpl) {
		this.catAppImpl = catAppImpl;
	}

	public void actionPerformed(ActionEvent e) {
		catAppImpl.newDocument();
	}

	/**
	 * @return Returns the catApp.
	 */
	public GeoCatalogAppImpl getCatApp() {
		return catAppImpl;
	}

	/**
	 * @param catAppImpl
	 *            The catApp to set.
	 */
	public void setCatApp(GeoCatalogAppImpl catAppImpl) {
		this.catAppImpl = catAppImpl;
	}

}
