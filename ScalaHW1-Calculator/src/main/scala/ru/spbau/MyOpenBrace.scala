package ru.spbau

import java.util

class MyOpenBrace extends MyOperation {
  override val priority: Int = 10
  override def isMyOpenBrace: Boolean = true
  def eval(numbers: util.ArrayList[Double]): util.ArrayList[Double] = numbers
}
