package warsztat

import java.time.{LocalDate, LocalDateTime}
import java.time.format.DateTimeFormatter
import java.util.UUID

import scala.util.{Failure, Success, Try}

case class Event(id: UUID, `type`: String, date: LocalDate)

case class User(id: UUID, name: String, group: String)

object LogConverters {

  implicit val eventConv: (String) => Try[Event] = { line =>
    val uuidPattern = "\\d+".r
    val dateRegex = "\\d{4}-\\d{2}-\\d{2}".r
    line.split(',') match {
      case Array(uuid, t, date) =>
        Success(
          Event(UUID.fromString(uuid),
                t,
                LocalDate.from(DateTimeFormatter.ISO_DATE.parse(date))))
      case _ =>
        Failure(new RuntimeException("Linia nie pasuje mi do obiektu Event"))
    }
  }

}

object LogParser {

  def parse[T](line: String)(
      implicit converter: String => Try[T]): Either[String, T] = {
    converter(line) match {
      case Success(res) => Right(res)
      case Failure(ex)  => Left(ex.getMessage)
    }
  }

  // val line = "1,Bartosz,aaa"
  // val user: Either[String, User] = parse(line)

}
