package concurrency

import scala.language.postfixOps
import scala.util._
import scala.util.control.NonFatal
import scala.concurrent._
import scala.concurrent.duration._
import ExecutionContext.Implicits.global
import scala.async.Async.{async, await}

object tryouts {

  def computeSomeStrings: List[String] = List("hello",
                                              "did you understand the futures/promises?",
                                              "I'm beginning to see something, is this light?")

  def simpleFuture(): Unit = {
    println("Start - simpleFuture method.")
    val f: Future[List[String]] = future {
      computeSomeStrings
    }

    f onComplete {
      case Success(x) => println("future completes: " + x)
      case Failure(t) => println("an error occurred.")
    }

    println("Stop - simpleFuture method.")
  }
// [info] Running concurrency.tryouts
// Start - simpleFuture method.
// Stop - simpleFuture method.
// future completes: List(hello, did you understand the futures/promises?)
// [success] Total time: 1 s, completed 20 nov. 2013 09:25:05

  def simpleFutureOnSuccessOnFailure(): Unit = {
    println("Start - simpleFutureOnSuccessOnFailure method.")
    val f: Future[List[String]] = future {
      computeSomeStrings
    }

    f onSuccess {
      case x => println("future completes: " + x)
    }

    f onFailure {
      case t => println("an error occurred.")
    }

    println("Stop - simpleFutureOnSuccessOnFailure method.")
  }
// [info] Running concurrency.tryouts
// Start - simpleFutureOnSuccessOnFailure method.
// future completes: List(hello, did you understand the futures/promises?)
// Stop - simpleFutureOnSuccessOnFailure method.
// [success] Total time: 1 s, completed 20 nov. 2013 13:16:18

  def main(args: Array[String]): Unit = {
//    simpleFuture

    simpleFutureOnSuccessOnFailure
  }

}