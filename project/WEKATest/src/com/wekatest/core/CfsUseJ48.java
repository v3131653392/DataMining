package com.wekatest.core;

import java.io.File;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;


public class CfsUseJ48{
	static Instances insTrain = null;
	static Instances insTest = null;
	static Classifier cfs = null;
	
	public static void work() {

		try{
			File file = new File("D:/Program Files/Weka-3-6/data/iris.arff");
			insTrain = MyUtil.getInstances(file);
			insTrain.setClassIndex(insTrain.numAttributes() - 1);
			insTest = insTrain;
			
			cfs = MyUtil.setJ48Tree(insTrain);
			
			System.out.println(cfs);
			MyUtil.printJ48((J48) cfs);			
			MyUtil.outputResult(insTrain, insTest, cfs);
			MyUtil.printInstances(insTrain);
			
			MyUtil.crossValidate(cfs,insTrain);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
