package warsztat

import java.time.{LocalDate, LocalDateTime}
import java.util.UUID

import org.scalatest.{EitherValues, FlatSpec, Matchers}

class LogParserTest extends FlatSpec with Matchers with EitherValues {

  import LogConverters._

  it should "parse event record " in {
    val uuid = UUID.randomUUID()
    val record = s"${uuid},DELETE,2017-10-08"
    val event: Either[String, Event] = LogParser.parse(record)
//    event.leftSideValue shouldBe ""
    event.right.value shouldBe Event(uuid, "DELETE", LocalDate.parse("2017-10-08"))
  }

}
