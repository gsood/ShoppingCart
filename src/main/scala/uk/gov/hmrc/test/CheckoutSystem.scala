package uk.gov.hmrc.test


trait Offer {
  val item:Item
  def offerDiscount(cart: List[Item]): Int
}

case class BuyOneGetOne(item:Item) extends Offer {
  override def offerDiscount(cart: List[Item]): Int = {
    (cart.filter(_ == item).size / 2) * item.cost
  }
}

case class ThreeForTwo(item:Item) extends Offer {
  override def offerDiscount(cart: List[Item]): Int = {
    (cart.filter(_ == item).size / 3) * item.cost
  }
}

trait Item {
  val cost:Int
}

case object Apple extends Item {
  override val cost: Int = 60
}
case object Orange extends Item {
  override val cost: Int = 25
}

object CheckoutSystem {

  def checkout(items: List[Item], offers: List[Offer] = Nil):Int = {
    val totalDiscount = offers.map(_.offerDiscount(items)).sum
    val totalCost = items.map(_.cost).sum
    totalCost - totalDiscount
  }

}
