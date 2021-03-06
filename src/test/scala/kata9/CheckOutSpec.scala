package kata9


import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CheckOutSpec extends Spec with ShouldMatchers {
    val RULES = Map(
        "A" -> (50, ""),
        "B" -> (10, "2 for 15")
    )
    describe("A supermarket check-out") {
      val co = new CheckOut(RULES)
      it("should begin a transaction with zero cost") {
        co.total() should be (0)
      }
      it("should add the cost of each item scanned") {
        co.scan("A")
        co.total() should be (50)
        co.scan("A")
        co.total() should be (100)
      }
    }
    describe("A supermarket check-out applying discounts") {
        val co = new CheckOut(RULES)
        it("should begin a transaction with zero cost") {
            co.total() should be (0)
        }
        it("should add the cost of each item scanned") {
            co.scan("B")
            co.total() should be (10)
            co.scan("B")
            co.total() should be (15)
        }
    }
}
