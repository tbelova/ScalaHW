package ru.spbau

import java.util

object Calculator {

  def evaluate(expr: String): Double = {
    val parseResult = Parser.parse(expr)
    val evalResult = evaluate(parseResult.getNumbers,parseResult.getOperations)
    if (evalResult.getNumbers.nonEmpty || evalResult.getOperations.nonEmpty) {
      throw new ParseError
    }
    evalResult.getResult
  }

  def evaluate(numbers: List[Int], operations: List[MyOperation]): EvalResult = {

    var stackOfNumbers = new util.ArrayList[Double]
    var stackOfOperations = new util.ArrayList[MyOperation]

    var currentNumbers = numbers
    var currentOperations = operations

    if (currentOperations.isEmpty || currentOperations.head.isBinary || currentOperations.head.isMyCloseBrace) {
      stackOfNumbers.add(currentNumbers.head)
      currentNumbers = currentNumbers.tail
    }

    def dowhile: EvalResult = {
      if (currentOperations.isEmpty) {
        new EvalResult(finish(stackOfNumbers, stackOfOperations), currentNumbers, currentOperations)
      } else if (currentOperations.head.isMyCloseBrace) {
        new EvalResult(finish(stackOfNumbers, stackOfOperations), currentNumbers, currentOperations.tail)
      } else if (currentOperations.head.isMyOpenBrace) {
        val result = evaluate(currentNumbers, currentOperations.tail)
        stackOfNumbers.add(result.getResult)
        currentNumbers = result.getNumbers
        currentOperations = result.getOperations
        dowhile
      } else {
        val res = process(currentOperations.head, stackOfNumbers, stackOfOperations)
        stackOfNumbers = res.getNumbers
        stackOfOperations = res.getOperations

        stackOfOperations.add(currentOperations.head)
        currentOperations = currentOperations.tail

        if (currentOperations.isEmpty || currentOperations.head.isBinary || currentOperations.head.isMyCloseBrace) {
          stackOfNumbers.add(currentNumbers.head)
          currentNumbers = currentNumbers.tail
        }

        dowhile
      }
    }

    dowhile

  }

  def finish(numbers: util.ArrayList[Double], operations: util.ArrayList[MyOperation]): Double = {
    process(new MyTinyOperation, numbers, operations).getNumbers.get(0)
  }

  def process(operation: MyOperation, numbers: util.ArrayList[Double], operations: util.ArrayList[MyOperation]): ProcessResult = {
    if (operations.isEmpty) {
      new ProcessResult(numbers, operations)
    } else if (operation.getPriority <= operations.get(operations.size() - 1).getPriority) {
      val res = operations.get(operations.size() - 1).eval(numbers)
      operations.remove(operations.size() - 1)
      process(operation, res, operations)
    } else {
      new ProcessResult(numbers, operations)
    }
  }

  class ProcessResult (numbers: util.ArrayList[Double], operations: util.ArrayList[MyOperation]) {
    def getNumbers = numbers
    def getOperations = operations
  }

}
