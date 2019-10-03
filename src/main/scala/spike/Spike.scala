package spike

import java.io.{File, InputStream}

import collection.JavaConverters._

import org.apache.commons.io.FileUtils
import org.apache.pdfbox.examples.util.PDFMergerExample

object Spike extends App {

  println("Spike starts")

  val dummyInputStream =
    FileUtils
      .openInputStream(new File("./sample-pdfs/dummy.pdf"))
      .asInstanceOf[InputStream]
  val sampleInputStream =
    FileUtils
      .openInputStream(new File("./sample-pdfs/sample.pdf"))
      .asInstanceOf[InputStream]
  val mergedInputStream = (new PDFMergerExample).merge(
    List(dummyInputStream, sampleInputStream).asJava
  )

  FileUtils.copyInputStreamToFile(mergedInputStream, new File("output.pdf"))

  println("Spike finished")
}
