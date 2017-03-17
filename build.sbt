import sbtsparkpackage.SparkPackagePlugin.autoImport.sparkVersion

name := "spark-wordcount-bdd"

version := "1.0"
scalaVersion := "2.11.8"
sparkVersion := "2.1.0"
organization := "com.bddsample"
crossScalaVersions := Seq("2.10.6", "2.11.8")
sparkComponents := Seq("core", "sql","streaming")
spAppendScalaVersion := false
spIncludeMaven := true
spIgnoreProvided := true
parallelExecution in Test := false
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.1.0",
  "org.apache.spark" %% "spark-hive" % "2.1.0"  % "test",
  "com.holdenkarau" %% "spark-testing-base" % "2.0.0_0.4.7" % "test",
  "joda-time" % "joda-time" % "2.9.3",
  "org.mockito" % "mockito-core" % "1.8.5" % "test",
  "org.scalatest" %% "scalatest" % "2.2.5" % "test"
)
