
name := "apollo -utilities"

version := "0.1"

scalaVersion := "2.12.12"

assemblyMergeStrategy in assembly := {
    //        case PathList("org","aopalliance", xs @ _*) => MergeStrategy.last
    //        case PathList("javax", "inject", xs @ _*) => MergeStrategy.last
    //        case PathList("javax", "servlet", xs @ _*) => MergeStrategy.last
    //        case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
    //        case PathList("org", "apache", xs @ _*) => MergeStrategy.concat
    //        case PathList("com", "google", xs @ _*) => MergeStrategy.last
    //        case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.last
    //        case PathList("com", "codahale", xs @ _*) => MergeStrategy.last
    //        case PathList("com", "yammer", xs @ _*) => MergeStrategy.last
    //        case "about.html" => MergeStrategy.rename
    //        case "overview.html" => MergeStrategy.discard
    //        case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
    //        case "META-INF/mailcap" => MergeStrategy.last
    //        case "META-INF/mimetypes.default" => MergeStrategy.last
    //        case "plugin.properties" => MergeStrategy.last
    //        case "log4j.properties" => MergeStrategy.last
    case "META-INF/services/org.apache.spark.sql.sources.DataSourceRegister" => MergeStrategy.concat
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case "reference.conf" => MergeStrategy.concat
    case x => MergeStrategy.first
}


libraryDependencies ++= Seq(
    "org.slf4j" % "slf4j-simple" % "1.7.25" % Test,
    "org.scalactic" %% "scalactic" % "3.1.1",
    "org.scalatest" %% "scalatest" % "3.1.1" % "test",
)