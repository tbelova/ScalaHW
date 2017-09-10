package ru.spbau

object Parser {

  def parse(expr: String): ParseResult = {

    def p(s: String): Boolean = s.length > 0

    val numbers = expr.split((OperationGenerator.SYMBOLS + ' ').toCharArray).filter(p).map(_.toInt).toList

    def isOperation(c: Char): Boolean = {
      OperationGenerator.SYMBOLS.contains(c)
    }

    val operations = expr.filter(isOperation).toList.map(OperationGenerator.getOperation)

    new ParseResult(numbers, operations)

  }

}
