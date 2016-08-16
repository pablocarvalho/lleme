package br.pucrio.inf.catfwk.appmodel;

import br.pucrio.inf.catfwk.model.CataloguingProcess;

/**
 * @alias Workspace*/
public interface Workspace {

	public abstract boolean addProcess(CataloguingProcess process);

	public abstract CataloguingProcess[] getProcessList();

	public abstract boolean removeProcess(CataloguingProcess process);

}