package ru.spbau

import java.util

abstract class MyOperation {
  val priority: Int

  def eval(numbers: util.ArrayList[Double]): util.ArrayList[Double]
  def getPriority: Int = priority
  def isBinary: Boolean = false
  def isMyOpenBrace: Boolean = false
  def isMyCloseBrace: Boolean = false

}

