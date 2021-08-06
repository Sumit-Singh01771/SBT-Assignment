name := "SBT Assignment"

version := "0.1"

scalaVersion := "2.13.6"


lazy val common=(project in file("common"))

  .settings(
    name:= "common module",
    libraryDependencies ++=Seq(
      "org.json4s" %% "json4s-native" % "4.0.3",
      "com.orhanobut" % "logger" % "2.2.0",
      "puppetlabs" % "typesafe-config" % "0.2.0",
      "org.typelevel" %% "discipline-scalatest" % "2.1.5" % Test,
      "org.mockito" %% "mockito-scala" % "1.16.37" % Test
))
lazy val persistence=(project in file("persistence"))

  .settings(
    name:= "persistence module",
    libraryDependencies ++=Seq(
      "com.typesafe.slick" %% "slick" % "3.3.3",
      "org.postgresql" % "postgresql" % "42.2.23",
      "com.h2database" % "h2" % "1.4.200" % Test
    )).dependsOn(common)

lazy val root = (project in file(".")).aggregate(persistence,common)

