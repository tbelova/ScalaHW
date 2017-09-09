package ru.spbau

class MyMinus extends MyBinaryOperation{
  override val priority: Int = 1
  override def evaluate(a: Double, b: Double) = a - b
}
