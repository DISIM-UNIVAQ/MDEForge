package org.mdeforge.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.ETLTransformation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Workspace;

public class CreateTest {

	private static MDEForgeClient c;

	@BeforeClass
	public static void setup() throws Exception {
		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "maja", "majacdg");
	}
	
	@Ignore
	@Test
	public void addWorkspace() throws Exception {
		Workspace w = new Workspace();
		w.setName("Francesco WorkSpace");
		w.setDescription("Test Project");
		c.addWorkspace(w);
	}
	
	@Ignore
	@Test
	public void addProject() throws Exception {
		Project p = new Project();
		p.setName("Progetto di prova");
		p.setWorkspaces(new ArrayList<Workspace>());
		List<Workspace> ws = c.getWorkspaces();
		for (Workspace workspace : ws) {
			p.getWorkspaces().add(workspace);
		}
		c.addProject(p);
	}
	
	@Test
	public void addEcoreMetamodel() throws Exception {
		EcoreMetamodel emm = new EcoreMetamodel();
		emm.setName("AndroidAppMM.ecore");
		List<String> tags = Arrays.asList("DB, DataBase, Data Base, Relational".split(","));
		emm.setTags(tags);
		emm.setDescription("Describes the basic structure of a general Relational DB");
		emm.setAuthors("Metamodels Authors");
		emm.setOpen(false);	
		List<Workspace> worspaces = c.getWorkspaces();
		for (Workspace project : worspaces) {
			emm.getWorkspaces().add(project);
		}
		c.addEcoreMetamodel(emm,"temp/AndroidAppMM.ecore");	
	}
	
	@Ignore
	@Test
	public void testAddProjectToWorkspace() {
		try {
			Workspace w = c.getWorkspace("5514aa53d4c67eee3e2c1b12");
			Project p = new Project();
			p.setName("Test bascio");
			p.getWorkspaces().add(w);
			c.addProject(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Ignore
	@Test
	public void testArtifactToWorkspace() {
		try {
			Workspace w = c.getWorkspace("5514aa53d4c67eee3e2c1b12");
			ETLTransformation p = new ETLTransformation();
			p.setName("Android2Web");
			p.getWorkspaces().add(w);
			c.addETLTransformation(p, "temp/Android2Web.etl");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void addATLTransformation() throws Exception {
		ATLTransformation emm = new ATLTransformation();
		emm.setName("BibTeX2DocBook");
		emm.setOpen(true);	
		c.addATLTransformation(emm,"temp/BibTeX2DocBook.atl");
	}
}
