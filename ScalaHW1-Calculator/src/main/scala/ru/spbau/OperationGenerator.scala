package ru.spbau

object OperationGenerator {

  val SYMBOLS = "()+-*/"

  def getOperation(c: Char): MyOperation = {
    if (c == '+') {
      new MyPlus
    } else if (c == '-') {
      new MyMinus
    } else if (c == '*') {
      new MyMult
    } else if (c == '/') {
      new MyDiv
    } else if (c == '(') {
      new MyOpenBrace
    } else if (c == ')') {
      new MyCloseBrace
    } else {
      throw new ParseError
    }
  }

}
