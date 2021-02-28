package uk.gov.hmrc.test

import org.scalatest.flatspec.AnyFlatSpec



class CheckoutSystemSpec extends AnyFlatSpec {

  "Checkout system" should "take a list of items as input and give total cost in pence" in {
    val totalCost = CheckoutSystem.checkout(List(Apple, Apple, Orange))

    assert(totalCost === 145)
  }


  it should "give 0 as total cost if empty list is passed"  in {
    val totalCost = CheckoutSystem.checkout(List())

    assert(totalCost === 0)
  }

  it should "calculate total cost for larger list"  in {
    val totalCost = CheckoutSystem.checkout(List(Apple, Apple, Apple, Orange, Orange, Apple))

    assert(totalCost === 290)
  }
}
