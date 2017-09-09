package ru.spbau

object Main {

  def main(args: Array[String]) = {
    val expr = "(2 + (2 * 3 + (1 + 2 + 3) * 2) / 2 + 1) / 3 / 4 - 1 - 2 - 3 * 2 - 12 + 8 + 5"
    System.out.println(Calculator.evaluate(expr))
  }

}
