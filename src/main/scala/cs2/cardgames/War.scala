package cs2.cardgames

object War {
  def main(args:Array[String]):Unit = {
    val deck = Deck()
    deck.shuffle()
    var p1Hand = Deck.empty()
    var p2Hand = Deck.empty()
    while(!deck.isEmpty()) {
      p1Hand.add(deck.deal())
      p2Hand.add(deck.deal())
    }
    while(!p1Hand.isEmpty() && !p2Hand.isEmpty()) {
      var p1Card = p1Hand.deal()
      var p2Card = p2Hand.deal()
      if(p1Card > p2Card) {
        p1Hand.add(p1Card)
        p1Hand.add(p2Card)
        p1Hand.shuffle()
      } else if(p2Card > p1Card) {
        p2Hand.add(p1Card)
        p2Hand.add(p2Card)
        p2Hand.shuffle()
      } else {
        println("WAR!!!")
        //I'll post code that does this
      }
    }
    if(p1Hand.isEmpty()) println("Player 2 wins!")
    else println("Player 1 wins!")
  }
}
