package com.bddsample

import com.holdenkarau.spark.testing.DataFrameSuiteBase
import org.scalatest.Matchers._
import org.scalatest.{FeatureSpec, GivenWhenThen}
import scala.util.Random

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.{DateType, DecimalType, StructType}

class WordCountSpecs extends FeatureSpec with GivenWhenThen with DataFrameSuiteBase {
  feature("Word Count") {
    scenario("When dealing with rdds") {

      Given("A list of words")
      val input = List("hi", "hi holden", "bye")


      When("Parralising the RDD")
      val rdd = tokenize(sc.parallelize(input)).collect().toList

      Then("We should get the expected output")
      val expected = List(List("hi"), List("hi", "holden"), List("bye"))
      rdd should be (expected)

    }
    def tokenize(f: RDD[String]) = {
      f.map(_.split(" ").toList)
    }
  }
}