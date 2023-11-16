ThisBuild / version := "0.1.0"

ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "lost-item"
  )

ThisBuild / libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.17" % Test