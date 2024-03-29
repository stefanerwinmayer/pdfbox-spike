import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.8"
  lazy val pdfBox = "org.apache.pdfbox" % "pdfbox" % "2.0.17"
  lazy val xmpBox = "org.apache.pdfbox" % "xmpbox" % "2.0.17"
  lazy val commonsIO = "commons-io" % "commons-io" % "2.6"
}
