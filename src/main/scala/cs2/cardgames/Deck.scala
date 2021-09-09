package cs2.cardgames

class Deck {
  private var cards = List[Card]()

  def shuffle():Unit = {
    cards = scala.util.Random.shuffle(cards)
  }
}