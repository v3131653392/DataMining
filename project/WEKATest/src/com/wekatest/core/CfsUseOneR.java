package com.wekatest.core;

import java.io.File;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.rules.OneR;
import weka.core.Instances;

public class CfsUseOneR {
	static Instances insTrain = null;
	static Instances insTest = null;
	static Classifier cfs = null;
	
	public static void work() {

		try{
			File file = new File("D:/Program Files/Weka-3-6/data/iris.arff");
			insTrain = MyUtil.getInstances(file);
			insTrain.setClassIndex(insTrain.numAttributes() - 1);
			insTest = insTrain;
			
			cfs = new OneR();	
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
