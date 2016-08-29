/**
 * 
 */
package uff.ic.tcc00175.catfwk.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uff.ic.tcc00175.catfwk.model.CataloguingProcess;
import uff.ic.tcc00175.catfwk.view.GeoCatalogAppWindow;
import uff.ic.tcc00175.catfwk.view.WspWindow;

/**
 * @author Luiz Leme*/
public class UpdProcMenuItemAction implements ActionListener {
	private GeoCatalogAppWindow catAppWindow;

	/**
	 * @param window
	 */
	public UpdProcMenuItemAction(GeoCatalogAppWindow window) {
		catAppWindow = window;
	}

	public void actionPerformed(ActionEvent e) {
		CataloguingProcess proc = null;
		WspWindow wsp = ((WspWindow) catAppWindow.getJDesktopPane()
				.getSelectedFrame());
		if (wsp != null) {
			catAppWindow.getAddUpdateButton().setAction(
					catAppWindow.getUpdateProcessAction());
			catAppWindow.getAddUpdateButton().setText("Update");
			proc = wsp.getCurrentProcess();
			if (proc != null) {
				catAppWindow.getProcessName().setText(proc.getName());
				if (proc.getRepositories() != null
						&& proc.getRepositories()[0] != null)
					catAppWindow.getRepository().setText(
							proc.getRepositories()[0]);
				else
					catAppWindow.getRepository().setText(null);
				if (proc.getGazetteers() != null
						&& proc.getGazetteers()[0][1] != null)
					catAppWindow.getGazetteer().setText(
							proc.getGazetteers()[0][1]);
				else
					catAppWindow.getGazetteer().setText(null);
				catAppWindow.getCatalog().setText(proc.getCatalog());
				catAppWindow.getFails().setText(proc.getFails());
				catAppWindow.getProcessDialog().setVisible(true);
			}
		}

	}
}