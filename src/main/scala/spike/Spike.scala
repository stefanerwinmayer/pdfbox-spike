package spike

import org.apache.pdfbox.examples.util.PDFMergerExample

object Spike extends App {
  println("Spike starts")
  val pdfMerger = new PDFMergerExample
  val listInputStream = ???
  val inputStream = pdfMerger.merge(listInputStream)
  println("Spike finished")
}
