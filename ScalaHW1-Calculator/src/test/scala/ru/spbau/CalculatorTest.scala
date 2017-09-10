package ru.spbau

import org.scalatest.FunSuite

class CalculatorTest extends FunSuite {

  test("SimpleAddition") {
    assert(Calculator.evaluate("10 + 20") == (10d + 20d))
  }

  test("SimpleSubtraction") {
    assert(Calculator.evaluate("10 - 20") == (10d - 20d))
  }

  test("SimpleMultiplication") {
    assert(Calculator.evaluate("10 * 20") == (10d * 20d))
  }

  test("SimpleDivision") {
    assert(Calculator.evaluate("10 / 20") == (10d / 20d))
  }

  test("Addition") {
    assert(Calculator.evaluate("1 + 2 + 3 + 4 + 5") == (1d + 2d + 3d + 4d + 5d))
  }

  test("Subtraction") {
    assert(Calculator.evaluate("1 - 2 - 3 - 4 - 5") == (1d - 2d - 3d - 4d - 5d))
  }

  test("Multiplication") {
    assert(Calculator.evaluate("1 * 2 * 3 * 4 * 5") == (1d * 2d * 3d * 4d * 5d))
  }

  test("Division") {
    assert(Calculator.evaluate("1 / 2 / 3 / 4 / 5") == (1d / 2d / 3d / 4d / 5d))
  }

  test("Addition ans Subtraction") {
    assert(Calculator.evaluate("1 + 2 - 3 + 4 - 5") == (1d + 2d - 3d + 4d - 5d))
  }

  test("Multiplication and Division") {
    assert(Calculator.evaluate("1 * 2 / 3 * 4 / 5") == (1d * 2d / 3d * 4d / 5d))
  }

  test("RandomExpression1") {
    val expr = "(2 + (2 * 3 + (1 + 2 + 3) * 2) / 2 + 1) / 3 / 4 - 1 - 2 - 3 * 2 - 12 + 8 + 5"
    val expected = (2d + (2d * 3d + (1d + 2d + 3d) * 2d) / 2d + 1d) / 3d / 4d - 1d - 2d - 3d * 2d - 12d + 8d + 5d
    assert(Calculator.evaluate(expr) == expected)
  }

  test("RandomExpression2") {
    val expr = "213 - 435 + (335) * (32 + 15) - 34 - 432 * 4/6 -  34 + 1232*7 + 152"
    val expected = 213d - 435d + 335d * (32d + 15d) - 34d - 432d * 4d / 6d -  34d + 1232d * 7d + 152d
    assert(Calculator.evaluate(expr) == expected)
  }

  test("RandomExpression3") {
    val expr = "(34 / 5 + 34 * (314 - 2340) - 34 - 344 - (1 + 3 * 3))"
    val expected = 34d / 5d + 34d * (314d - 2340d) - 34d - 344d - (1d + 3d * 3d)
    assert(Calculator.evaluate(expr) == expected)
  }

}
