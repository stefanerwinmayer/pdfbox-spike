package spike

import java.io.{File, InputStream}

import collection.JavaConverters._

import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits._

import fs2._
import org.apache.commons.io.FileUtils

object Spike extends IOApp {

  val app: Stream[IO, Unit] =
    Stream.eval(
      IO {
        println("Spike starts")

        val file1 = "dummy.pdf"
        val pathFile1 = "./samplePDFs/"
        val file2 = "sample.pdf"
        val pathFile2 = "./samplePDFs/"

        val dummyInputStream =
          FileUtils
            .openInputStream(new File(s"$pathFile1$file1"))
            .asInstanceOf[InputStream]
        val sampleInputStream =
          FileUtils
            .openInputStream(new File(s"$pathFile2$file2"))
            .asInstanceOf[InputStream]
        val mergedInputStream = (new PDFMerger).merge(
          List(dummyInputStream, sampleInputStream).asJava
        )

        FileUtils
          .copyInputStreamToFile(mergedInputStream, new File("output.pdf"))

        println("Spike finished")
      }
    )

  def run(args: List[String]): IO[ExitCode] =
    app.compile.drain.as(ExitCode.Success)
}
