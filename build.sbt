name := "apollo -utilities"

version := "0.1"

scalaVersion := "2.12.12"


libraryDependencies ++= Seq(
    "org.slf4j" % "slf4j-simple" % "1.7.25" % Test,
    "org.scalactic" %% "scalactic" % "3.1.1",
    "org.scalatest" %% "scalatest" % "3.1.1" % "test",
)