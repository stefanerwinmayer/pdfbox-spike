package spike

import java.io.{File, InputStream}
import java.time._

import collection.JavaConverters._

import org.apache.commons.io.FileUtils

object Spike extends App {

  println("Spike starts")

  val file1 = "dummy.pdf"
  val pathFile1 = "./samplePDFs/"
  val file2 = "sample.pdf"
  val pathFile2 = "./samplePDFs/"

  val start = LocalDateTime.now
  var later = start
  var iterations = 0

  val pdfMerger = new PDFMerger

  while (Duration.between(start, later).getSeconds < 60) {

    val dummyInputStream =
      FileUtils
        .openInputStream(new File(s"$pathFile1$file1"))
        .asInstanceOf[InputStream]
    val sampleInputStream =
      FileUtils
        .openInputStream(new File(s"$pathFile2$file2"))
        .asInstanceOf[InputStream]
    val mergedInputStream = pdfMerger.merge(
      List(dummyInputStream, sampleInputStream).asJava
    )

    later = LocalDateTime.now
    iterations = iterations + 1
  }

  val end = LocalDateTime.now
  println(s"Time elapsed: ${Duration.between(start, end)}")
  println(s"Iterations: $iterations")
  println("Spike finished")
}
