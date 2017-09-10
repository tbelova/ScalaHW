package ru.spbau

class EvalResult(result: Double, numbers: List[Int], operations: List[MyOperation]) {
  def getResult = result
  def getNumbers = numbers
  def getOperations = operations
}
