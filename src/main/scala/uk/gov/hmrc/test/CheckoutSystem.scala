package uk.gov.hmrc.test


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
  def checkout(items: List[Item]):Int = {
    items.map(_.cost).sum
  }

}
