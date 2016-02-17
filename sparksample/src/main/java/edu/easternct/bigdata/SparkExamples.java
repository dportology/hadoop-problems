package edu.easternct.bigdata;

import java.util.Arrays;
import java.util.List;
import java.lang.Iterable;
import scala.Tuple2;
import org.apache.commons.lang.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;


public class SparkExamples {
  public static void main(String[] args) throws Exception {
    String master = args[0];
    SparkConf conf = new SparkConf().setAppName("wordCount"); 
	conf.setMaster(master);
	JavaSparkContext sc = new JavaSparkContext(conf);
    JavaRDD<String> rdd = sc.textFile(args[1]);
      
  
//  	}}).reduceByKey(new Function2<Integer, Integer, Integer>(){
//                public Integer call(Integer x, Integer y){ return x+y;}});
    System.out.println("Input found : " + rdd.count());
    System.out.println("First Line found : " + rdd.first());
//      JavaPairRDD<String, Integer> samples = wcounts.take(10);
//      wcounts.take(10).saveAsTextFile(args[1]);
      sc.stop();
	}
  
}

//  static class ContainsJPG implements Function<String, Boolean>() {
//	  public Boolean call(String x) { return x.contains(".jpg");}
//}
