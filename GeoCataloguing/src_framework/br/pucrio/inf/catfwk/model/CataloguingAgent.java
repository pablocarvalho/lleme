package br.pucrio.inf.catfwk.model;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import br.pucrio.inf.lib.agent.Agent;

/**
 * @version 1.0
 * @since 1.0
 * @author Luiz André
 * @alias CataloguingAgent*/
public class CataloguingAgent extends Agent {

	/**
	 * @supplierCardinality 1..*
	 * @link aggregation
	 * @label query
	 * @labelDirection forward*/
	private Gazetteer[] dictionaries = null;

	/**
	 * @supplierRole +tempCatalog*/
	private Catalog tempCatalog;

	/**
	 * @supplierRole +catalog*/
	private Catalog catalog = null;

	/**
	 * @supplierRole +fails*/
	private Catalog fails = null;

	/**
	 * @link aggregation
	 * @associates <{Catalog}>
	 * @label query
	 * @labelDirection forward*/
	private Vector catalogService;

	public CataloguingAgent(String id, Gazetteer[] dictionaries,
			Catalog tempCatalog, Catalog catalog, Catalog fails) {
		super(id);
		this.dictionaries = dictionaries;
		this.catalog = catalog;
		this.fails = fails;
		this.tempCatalog = tempCatalog;
	}

	public void run() {
		super.run();
	}

	/**
	 * Para cada imagem na InBox, recupera informações relacionadas dos
	 * gazetteers e a cataloga. Caso não seja possível encontrar nehuma
	 * informação grama a imagem em um banco de dados de falhas.
	 * 
	 * @since 1.0
	 */
	public void agentBehavior() {
		DatasetDescription dataset = null;
		DatasetDescription annotations = null;
		HarvestResource message = null;

		try {
			Calendar t1 = new GregorianCalendar();
			message = (HarvestResource) readMessage(new HarvestResource(null));
			dataset = (DatasetDescription) message.getBody();
			/*
			 * Para cada dicionário recupera informações relacionadas ao
			 * Resource
			 */
			for (int j = 0; j < dictionaries.length; j++) {
				/*
				 * Recupera informações do dicionário:
				 * dictionaries[j].getContent(resource.getUri())
				 */
				annotations = dictionaries[j].getDescription(dataset);
				if (annotations != null) {
					System.out.println("Agent id:" + getId() + " catalogando "
							+ dataset.getUri());
					/*
					 * Mescla os metadados do Resource com aqueles obtidos nos
					 * dicionários e cataloga o recurso
					 */
					dataset.aggregateDescription(annotations);
					dataset.setStatus("catalogued");
					catalog(dataset);
					// tempCatalog.remove(dataset);
					// catalog.put(dataset);
				} else {
					/*
					 * Caso não seja possível recuperar nehuma informação sobre
					 * o recurso rigistra-o como falha
					 */
					dataset.setStatus("failed");
					dataset.setFailReason("no related information");
					tempCatalog.remove(dataset);
					fails.put(dataset);
					getProcess().notifyObservers();
				}
			}
			catalog.exportXML();
			Calendar t2 = new GregorianCalendar();
			System.out.println("tempo ="
					+ Long
							.toString(t2.getTimeInMillis()
									- t1.getTimeInMillis()));
		} catch (InterruptedException e) {
			System.out.println("Agent id:" + getId()
					+ " reiniciando processamento após receber nova mensagem.");
		} catch (IOException e) {
			e.printStackTrace();
			getProcess().reportError();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			getProcess().reportError();
		} catch (InvalidDatasetDescException e) {
			System.err.println("Erro na decodificação de "
					+ "meta-informações do arquivo "
					+ "do information resource " + dataset.getUri());
			try {
				fails.put(dataset);
			} catch (IOException e1) {
				e1.printStackTrace();
				getProcess().reportError();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
				getProcess().reportError();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			getProcess().reportError();
		} catch (SAXException e) {
			e.printStackTrace();
			getProcess().reportError();
		}
	}

	public void catalog(DatasetDescription dataset) throws IOException,
			ClassNotFoundException {
		tempCatalog.remove(dataset);
		catalog.put(dataset);
	}

	public void filterDescription() {
	}
}
