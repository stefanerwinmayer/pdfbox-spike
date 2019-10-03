package spike

import java.io.{File, InputStream}

import collection.JavaConverters._

import org.apache.commons.io.FileUtils

object Spike extends App {

  println("Spike starts")

  val dummyInputStream =
    FileUtils
      .openInputStream(new File("./samplePDFs/dummy.pdf"))
      .asInstanceOf[InputStream]
  val sampleInputStream =
    FileUtils
      .openInputStream(new File("./samplePDFs/sample.pdf"))
      .asInstanceOf[InputStream]
  val mergedInputStream = (new PDFMerger).merge(
    List(dummyInputStream, sampleInputStream).asJava
  )

  FileUtils.copyInputStreamToFile(mergedInputStream, new File("output.pdf"))

  println("Spike finished")
}
