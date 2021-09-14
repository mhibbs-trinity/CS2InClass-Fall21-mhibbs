package cs2.cardgames

class Deck {
  private var cards = List[Card]()
  def shuffle():Unit = {
    cards = scala.util.Random.shuffle(cards)
  }
  def deal():Card = {
    val tmp = cards(0) //cards.head
    cards = cards.tail
    tmp
  }
  def isEmpty():Boolean = { cards.length == 0 }
  def add(c:Card):Unit = { cards = c :: cards }
}

object Deck {
  def apply():Deck = {
    val d = new Deck()
    for(suit <- List(Card.DIAMOND,'H','S','C')) {
      for(rank <- 1 to 13) {
        d.add(Card(rank,suit))
      }
    }
    d
  }
  def empty():Deck = new Deck()

  def main(args:Array[String]):Unit = {
    val fullDeck = Deck()
    println(fullDeck.isEmpty())
    val emptyDeck = Deck.empty()
    println(emptyDeck.isEmpty())
  }
}


