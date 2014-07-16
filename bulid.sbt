name := "ScalaTestExample"

version := "1.0"

scalaVersion := "2.11.1"

resolvers ++= Seq(
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= Seq(
    "org.scalatest" % "scalatest_2.11" % "2.2.0" % "test",
    "org.scalacheck" %% "scalacheck" % "1.11.4" % "test"
)

scalacOptions ++= Seq("-encoding", "UTF-8")
