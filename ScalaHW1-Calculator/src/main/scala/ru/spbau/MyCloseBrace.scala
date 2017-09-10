package ru.spbau

import java.util

class MyCloseBrace extends MyOperation {
  override val priority: Int = 10
  override def isMyCloseBrace: Boolean = true
  def eval(numbers: util.ArrayList[Double]): util.ArrayList[Double] = numbers
}
