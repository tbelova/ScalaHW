package ru.spbau

object Main {

  def main(args: Array[String]) = {
    try {
      System.out.println(Calculator.evaluate(args(0)))
    } catch {
      case _: ParseError => System.out.println("Parse Error")
    }
  }

}
