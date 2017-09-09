package ru.spbau

import java.util

abstract class MyBinaryOperation extends MyOperation {
  override def eval(numbers: util.ArrayList[Double]): util.ArrayList[Double] = {
    if (numbers.size() < 2) {
      throw new ParseError
    }
    val newNumbers = numbers
    val res = evaluate(newNumbers.get(newNumbers.size() - 2), newNumbers.get(newNumbers.size() - 1))
    newNumbers.remove(newNumbers.size() - 1)
    newNumbers.remove(newNumbers.size() - 1)
    newNumbers.add(res)
    newNumbers
  }

  def evaluate(a: Double, b: Double): Double
  override def isBinary: Boolean = true
}
