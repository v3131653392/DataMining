package com.wekatest.core;

import java.io.*;
import java.util.Random;

import weka.core.*;
import weka.core.converters.ArffLoader;
import weka.classifiers.*;
import weka.classifiers.trees.J48;

/*
 * define util
 */
public class MyUtil {
	public static Instances getInstances(String fileName) throws Exception{
		File file = new File(fileName);
		return getInstances(file);
	}
	
	public static Instances getInstances(File file) throws Exception{
		Instances ins = null;
		try {
			ArffLoader loader = new ArffLoader();
			loader.setFile(file);
			ins = loader.getDataSet();
			loader = null;
		}catch(Exception e){
			e.printStackTrace();
		}
		return ins;
	}
	
	public static void printInstances(Instances ins){
		System.out.println(ins.toSummaryString());
	}
	
	public static void printInstance(Instance ins){
		System.out.println(ins.toString());
	}
	
	public static void printJ48(J48 j48) throws Exception{
		System.out.println(j48.graph());
	}
	
	public static void outputResult(Instances insTrain,Instances insTest,Classifier cfs) throws Exception{
		int num = insTest.numInstances();
		for(int i=0;i<num;i++){
			double predicted = cfs.classifyInstance(insTest.instance(i));
			System.out.println("data"+(i+1)+":\t"+"\t"+insTrain.instance(i).classValue()+"\t"+predicted);
		}
	}
	
	public static J48 setJ48Tree(Instances ins) throws Exception{
		J48 cfs = new J48();
		cfs.buildClassifier(ins);
		return cfs;
	}
	
	public static void crossValidate(Classifier cfs,Instances ins) throws Exception{
		Evaluation eva = new Evaluation(ins);
		eva.crossValidateModel(cfs, ins, 10, new Random(1));
		System.out.println(eva.toClassDetailsString());
        System.out.println(eva.toSummaryString());
        System.out.println(eva.toMatrixString());
	}
	
	public void save(Instances ins){
		
	}
}
