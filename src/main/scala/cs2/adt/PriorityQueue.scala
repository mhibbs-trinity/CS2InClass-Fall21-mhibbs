package cs2.adt

abstract class PriorityQueue[A <% Ordered[A]] {
  def add(elem:A):Unit
  def get():A
  def peek():A
  def isEmpty():Boolean
}


