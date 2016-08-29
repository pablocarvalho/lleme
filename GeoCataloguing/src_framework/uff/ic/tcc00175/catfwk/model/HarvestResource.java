package uff.ic.tcc00175.catfwk.model;

import uff.ic.tcc00175.lib.agent.Message;

/**
 * @author Luiz Andr�
 * @version 1.0
 * @since 1.0
 * @alias NewDataset*/
public class HarvestResource extends Message {

	private static final long serialVersionUID = 1134004306170375742L;

	public HarvestResource(Object body) {
		super(body);
	}
}
