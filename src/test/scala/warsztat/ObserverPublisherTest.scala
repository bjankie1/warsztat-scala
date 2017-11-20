package warsztat

import org.reactivestreams.{Subscriber, Subscription}
import org.scalatest.{FlatSpec, Matchers}

class ObserverPublisherTest extends FlatSpec with Matchers {

  it should "publish some information" in {
    val publisher = new ObserverPublisher()
    publisher.subscribe(new Subscriber[String] {
      override def onError(t: Throwable): Unit = {}

      override def onComplete(): Unit = {}

      override def onNext(t: String): Unit = {
        println(t)
      }

      override def onSubscribe(s: Subscription): Unit = {

      }
    })
  }

}
