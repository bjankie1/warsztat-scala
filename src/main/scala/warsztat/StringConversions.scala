package warsztat

object StringConversions {

  implicit def toBigDecimal(s: String): BigDecimal = BigDecimal(s)

}
