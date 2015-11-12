package org.mdeforge.business;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.mdeforge.business.model.EcoreMetamodel;

public interface EcoreMetamodelService extends CRUDArtifactService<EcoreMetamodel>,
		MetricProvider, SimilarityService, ValidateService, ClusterService {
	
	List<EcoreMetamodel> findEcoreMetamodelByURI(String URI);
	ResponseGrid<EcoreMetamodel> findAllEcorePaginated(RequestGrid requestGrid)  throws BusinessException;
	void registerMetamodel (EcoreMetamodel ecoreMetamodel) throws BusinessException;
	String serializeContent(EcoreMetamodel emm) throws BusinessException;
	List<String> getNSUris(EcoreMetamodel ecoreMetamodel)
			throws BusinessException;
	List<EcoreMetamodel> searchByExample(EcoreMetamodel searchSample) throws BusinessException;
	void registerMetamodel(String ecoreMetamodel) throws BusinessException;
	List<EcoreMetamodel> searchByExample(EcoreMetamodel searchSample,
			double score) throws BusinessException;
	double calculateContainment(EcoreMetamodel art1, EcoreMetamodel art2);
	Resource loadArtifacrt(String id);
	
}
