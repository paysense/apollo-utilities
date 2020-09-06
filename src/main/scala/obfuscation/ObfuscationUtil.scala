package obfuscation

object ObfuscationUtil {


    def simpleStringObfuscation(value: String) : String = {
      if(value.isEmpty || value == null) {
          value
      } else {
          if(value.length <= 3) {
              value.replaceAll("\\d(?=\\d{1})", "*")
          } else {
              value.replaceAll("\\d(?=\\d{3})", "*")
          }
      }
    }

    def simpleNumericObfuscation (value: AnyVal): AnyVal = value match {
        case x_int: Int => x_int << 2
        case x_long: Long => x_long << 2
        case _ => 0
    }


}
