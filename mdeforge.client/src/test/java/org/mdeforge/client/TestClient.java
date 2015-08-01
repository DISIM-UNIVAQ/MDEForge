package org.mdeforge.client;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Workspace;

public class TestClient {

	private static ModelService modelService;


	private static EcoreMetamodelService ecoreMetamodelService; 
	private static ProjectService projectService; 
	private static WorkspaceService workspaceService; 
	@BeforeClass
	public static void setup() throws Exception {
		modelService = new ModelService("http://localhost:8080/mdeforge/", "maja", "majacdg");
		ecoreMetamodelService = new EcoreMetamodelService("http://localhost:8080/mdeforge/", "maja", "majacdg");
		projectService = new ProjectService("http://localhost:8080/mdeforge/", "maja", "majacdg");
		workspaceService = new WorkspaceService("http://localhost:8080/mdeforge/", "maja", "majacdg");
	}
	@Test
	public void testAddModelAndroid () {
		try {
			Model model = new Model();
			model.setName("android2.model");
			model.setOpen(true);
			Project p = new Project();
			p.setId("5514b9a6d4c6c379396fe8b9");
			//p.getArtifacts().add(emm);
			EcoreMetamodel emm = new EcoreMetamodel();
			emm.setId("551baa6545686c2b30f1351f");
			ConformToRelation c2 = new ConformToRelation();
			c2.setFromArtifact(model);
			c2.setToArtifact(emm);
			model.getRelations().add(c2);
			model.getProjects().add(p);
			modelService.addModel(model, "temp/android.model");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Ignore
	@Test	
	public void testSimilarityEcoreMetamodel () {
		try {
			System.out.println(ecoreMetamodelService.getEcoreMetamodelSimilarity("552657f44568f64e28214b2d", "552657f44568f64e28214b31"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Ignore
	@Test	
	public void testMetricEcoreMetamodel () {
		try {
			System.out.println(ecoreMetamodelService.getEcoreMetamodelMetrics("552bbd07d4c659da8e19ec99"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Ignore
	@Test	
	public void testValidateEcoreMetamodel () {
		try {
			System.out.println(ecoreMetamodelService.validateEcoreMetamodels("551d16574568e6d8551fc5af"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testAddEcoreMetamodel () {
		try {
			Project p = projectService.getProjects().get(0);
			EcoreMetamodel emm = new EcoreMetamodel();
			emm.setName("Prova Salvi");
			List<String> tags = Arrays.asList("DB, DataBase, Data Base, Relational".split(","));
			emm.setTags(tags);
			emm.setDescription("Describes the basic structure of a general Relational DB");
			emm.setAuthors("Metamodels Authors");
			emm.getProjects().add(p);
			ecoreMetamodelService.addEcoreMetamodel(emm, "temp/Database.ecore");
			System.out.println("Metamodel Saved!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Ignore
	@Test
	public void testAddModel(){
		try {
			Project p = projectService.getProjects().get(0);
			Artifact mm = p.getArtifacts().get(0);
			Model m = new Model();
			m.setName("ModelSalvi");
			List<String> tags = Arrays.asList("DB, Data, DataBase, Data Base, Relational".split(","));
			m.setTags(tags);
			m.setDescription("Rapresent a model of a general Relational DB");
			m.setAuthors("Models Authors");
			ConformToRelation rel = new ConformToRelation();
			rel.setFromArtifact(m);
			rel.setToArtifact(mm);
			m.getRelations().add(rel);
			m.getProjects().add(p);
			modelService.addModel(m, "temp/My.database");
			System.out.println("Model Saved!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Ignore
	@Test
	public void testSearch(){
		try {
			List<Artifact> artifacts = ecoreMetamodelService.orderedSearch("data");
			printArtifacts(artifacts);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void testCreateIndex(){
		try {
			String result = ecoreMetamodelService.createIndex();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void printArtifacts(List<Artifact> artifacts){
		for (Artifact artifact : artifacts) {
			System.out.println(artifact.getName());
			System.out.println(artifact.getDescription());
			System.out.println(artifact.getTags());
			System.out.println(artifact.getAuthors());
			System.out.println();
		}
	}
//
//	@Ignore
//	@Test
//	public void testSearch(){
//		try {
//			c = new MDEForgeClient("http://localhost:8080/mdeforge/", "maja", "majacdg");
//			List<Artifact> artifacts = c.orderedSearch("data");
//			printArtifacts(artifacts);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private void printArtifacts(List<Artifact> artifacts){
//		for (Artifact artifact : artifacts) {
//			System.out.println(artifact.getName());
//			System.out.println(artifact.getDescription());
//			System.out.println(artifact.getTags());
//			System.out.println(artifact.getAuthors());
//			System.out.println();
//		}
//	}

}