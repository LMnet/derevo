package org.manatki.derevo.circeDerivation
import org.manatki.derevo.derive

import io.circe.syntax._
import io.circe.parser._
import io.circe.derivation.renaming

@derive(encoder, decoder)
final case class Foo (string: String, int: Int)

@derive(decoder(renaming.snakeCase), encoder(renaming.kebabCase))
final case class Bar(stringName: String, integerAge: Int)

object CirceTest{
  def main(args: Array[String]): Unit = {
    println(Foo("Lol", 42).asJson.spaces2)
    println(decode[Foo](""" { "string" : "kek", "int": -4}"""))

    val bar = decode[Bar](
      """
        |{
        |   "string_name": "Cheburek",
        |   "integer_age": 146
        |}
      """.stripMargin).toOption.get
    println(bar)
    println(bar.asJson.spaces2)
  }
}
