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

  it should "Apply Buyone Get one Offer on Apple when there are even number of Apples in cart" in {
    val totalCost = CheckoutSystem.checkout(List(Apple, Apple, Apple, Apple), List(BuyOneGetOne(Apple)))
    assert(totalCost === 120)
  }

  it should "Apply Buyone Get one Offer on Apple when there are odd number of Apples in cart" in {
    val totalCost = CheckoutSystem.checkout(List(Apple, Apple, Apple, Apple, Apple, Apple, Apple), List(BuyOneGetOne(Apple)))
    assert(totalCost === 240)
  }

  it should "Apply Three for Two Offer on Oranges when there Oranges are multiple of 3" in {
    val totalCost = CheckoutSystem.checkout(List(Orange, Orange, Orange, Orange, Orange, Orange), List(ThreeForTwo(Orange)))
    assert(totalCost === 100)
  }

  it should "Apply Three for Two Offer on Oranges when there Oranges are not a multiple of 3" in {
    val totalCost = CheckoutSystem.checkout(List(Orange, Orange, Orange, Orange, Orange, Orange, Orange, Orange, Orange, Orange, Orange), List(ThreeForTwo(Orange)))
    assert(totalCost === 200)
  }

  it should "Apply all offers and calculate total price correctly" in {
    val totalCost = CheckoutSystem.checkout(List(Apple, Apple, Apple, Orange, Orange, Orange, Orange), List(BuyOneGetOne(Apple), ThreeForTwo(Orange)))
    assert(totalCost === 195)
  }
}
