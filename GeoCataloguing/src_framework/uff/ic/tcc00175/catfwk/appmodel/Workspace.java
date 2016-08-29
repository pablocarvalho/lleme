package uff.ic.tcc00175.catfwk.appmodel;

import uff.ic.tcc00175.catfwk.model.CataloguingProcess;

/**
 * @alias Workspace*/
public interface Workspace {

	public abstract boolean addProcess(CataloguingProcess process);

	public abstract CataloguingProcess[] getProcessList();

	public abstract boolean removeProcess(CataloguingProcess process);

}