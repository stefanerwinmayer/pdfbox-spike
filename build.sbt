import Dependencies._

ThisBuild / scalaVersion     := "2.12.10"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val spike = (project in file("."))
  .settings(
    name := "pdfbox-spike",
    libraryDependencies ++= Seq(
      pdfBox,
      xmpBox,
      commonsIO,
      fs2,
      scalaTest % Test
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
