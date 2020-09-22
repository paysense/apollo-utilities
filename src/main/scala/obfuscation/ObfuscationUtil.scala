package obfuscation

import java.util.regex.Pattern
object ObfuscationUtil {

    final val DEFAULT_MASKED_DATE: String = ""
    final val DEFAULT_MASKED_STRING: String = "MASKED"
    final val DEFAULT_MASKED_NUMBER: Int = 0

    final val MAIL_PATTERN: String = "(\\w{1,3})(\\w+.*)(@.*)"
    final val STRING_PATTERN_SHORT: String = ".(?=.{2})"
    final val STRING_PATTERN_LONG: String = ".(?=.{3})"

    def simpleStringObfuscation(value: String) : String = {
      if(value.isEmpty || value == null) {
          value
      } else {
          if(value.length <= 3) {
              value.replaceAll(STRING_PATTERN_SHORT, "*")
          } else {
              value.replaceAll(STRING_PATTERN_LONG, "*")
          }
      }
    }

    def simpleNumericObfuscation (value: AnyVal): AnyVal = value match {
        case x_int: Int => x_int << 2
        case x_long: Long => x_long << 2
        case _ => 0
    }

    def defaultNumericObfuscation(value: AnyVal): AnyVal = DEFAULT_MASKED_NUMBER
    def defaultStringObfuscation(value: String): String = DEFAULT_MASKED_STRING
    def defaultDateObfuscation(value: String): String = DEFAULT_MASKED_STRING


    def simpleMailObfuscation(value: String): String = {

        if(value.isEmpty || value == null) {
            value
        } else {
            value.replaceAll(MAIL_PATTERN, "$1****$3")
        }
    }


}
