package it.si3p.supwsd.modules.classification.classifiers;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;
import it.si3p.supwsd.modules.classification.instances.AmbiguityTest;
import it.si3p.supwsd.modules.classification.instances.AmbiguityTrain;
import it.si3p.supwsd.modules.classification.instances.Instance;
import it.si3p.supwsd.modules.classification.scorer.Result;
import it.si3p.supwsd.modules.extraction.features.Feature;

/**
 * @author papandrea
 *
 */
public abstract class Classifier<T,V> {

	public abstract Object train(AmbiguityTrain ambiguity);
	protected abstract double[] predict(T model, V[] featuresNodes);
	protected abstract V[] getFeatureNodes(SortedSet<Feature> features);
	
	@SuppressWarnings("unchecked")
	public final Collection<Result> evaluate(AmbiguityTest ambiguity,Object model,String cls) {

		SortedSet<Result> results;
		V[] featureNode;
		SortedSet<Feature> features;
		Result result;
		double[] probs;

		results=new TreeSet<Result>();
	
		for (Instance instance : ambiguity.getInstances()) {

			features=instance.getFeatures();
			
			if(!features.isEmpty()){
				
				featureNode = getFeatureNodes(features);
				probs=predict((T) model, featureNode);
				result=new Result(instance.getID(), instance.getSenses(), ambiguity.getClasses(),probs,instance.getToken());
			}
			else
				result=new Result(instance.getID(), instance.getSenses(),cls,instance.getToken());
			
			results.add(result);
		}
		
		return results;
	}


}
