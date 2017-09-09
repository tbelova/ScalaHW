package ru.spbau

class MyDiv extends MyBinaryOperation{
  override val priority: Int = 3
  override def evaluate(a: Double, b: Double) = a / b
}
