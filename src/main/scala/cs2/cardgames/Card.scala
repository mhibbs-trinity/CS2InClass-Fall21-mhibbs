package cs2.cardgames

class Card(val rank:Int, val suit:Char) {
  override def toString():String = {
    rank + " of " + suit
  }

  def isRed():Boolean = { 
    suit == Card.HEART || suit == Card.DIAMOND
  }
  def isBlack():Boolean = !isRed

  def > (other:Card):Boolean = {
    this.rank > other.rank
  }
  def < (other:Card):Boolean = {
    this.rank < other.rank
  }
  def >= (other:Card):Boolean = {
    this.rank >= other.rank
  }
  def <= (other:Card):Boolean = {
    this.rank <= other.rank
  }
}

object Card {
  val DIAMOND = 'D'
  val HEART = 'H'
  val SPADE = 'S'
  val CLUB = 'C'

  def apply(r:Int, s:Char):Card = new Card(r, s)
  def apply():Card = new Card(1, SPADE)

  def main(args:Array[String]):Unit = {
    val c = Card()
    println(c)
    val d = Card(7, CLUB)
    println(d)
  }

}




