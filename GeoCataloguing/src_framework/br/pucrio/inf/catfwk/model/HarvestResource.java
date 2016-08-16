package br.pucrio.inf.catfwk.model;

import br.pucrio.inf.lib.agent.Message;

/**
 * @author Luiz André
 * @version 1.0
 * @since 1.0
 * @alias NewDataset*/
public class HarvestResource extends Message {

	private static final long serialVersionUID = 1134004306170375742L;

	public HarvestResource(Object body) {
		super(body);
	}
}
