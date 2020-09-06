package obfuscation

object ObfuscationUtil {

  def simpleStringObfuscation(value: String) : String = {
      if(value.isEmpty || value == null) {
          value
      } else {
          if(value.length <= 3) {
              value.substring(0, 1)
          } else {
              value.substring(0 ,3)
          }
      }
  }



}
