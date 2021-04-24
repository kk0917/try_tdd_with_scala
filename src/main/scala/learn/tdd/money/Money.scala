package learn.tdd.money

class Money(
  val amount: Int,
  protected val currencyType: String
) extends Expression {

  def times(multiplier: Int): Money = new Money(amount * multiplier, currencyType)

  def plus(addend: Money): Expression = new Sum(Money.this, addend)

  override def reduce(to: String): Money = {
    val rate: Int =
      if (currencyType.equals("CHF") && to.equals("USD")) 2 else 1

      new Money(amount / rate, to)
  }

  def currency(): String = currencyType

  def equals(obj: Money): Boolean = {
    val money: Money = obj
    amount == money.amount && currencyType.equals(money.currencyType)
  }
}

object Money {
  def dollar(amount: Int): Money = new Money(amount, "USD")

  def franc(amount: Int): Money = new Money(amount, "CHF")
}
