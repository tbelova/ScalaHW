package ru.spbau
import java.util

class MyTinyOperation extends MyOperation {
  override val priority: Int = 0
  override def eval(numbers: util.ArrayList[Double]): util.ArrayList[Double] = numbers
}
