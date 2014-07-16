import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.MustMatchers._

import org.scalatest.prop.PropertyChecks

class TriangleSpec extends FlatSpec with ShouldMatchers with PropertyChecks {
    "Triangle" should "have three sides whose lengths are greater than 0" in {
      val triangle = new Triangle(2, 3, 4)
      triangle should have ('side1 (2), 'side2 (3), 'side3 (4))
    }

    it should "throw IAE if it cannot satisfy triangle inequality" in {
      forAll { (a: Int, b: Int, c: Int) =>
        whenever (a >= b + c || b >= a + c || c >= a + b) {
          evaluating { new Triangle(a, b, c) } should produce [IllegalArgumentException]
        }
      }
    }

    it should "equal to that which has the same length sides" in {
      val sideList =
        Table(
          ("a", "b", "c"),
          (3  , 4  , 5),
          (3  , 3  , 5),
          (3  , 3  , 3)
        )
      forAll (sideList) { (a: Int, b: Int, c: Int) =>
        val triangle1 = new Triangle(a, b, c)
        val triangle2 = new Triangle(c, a, b)
        val triangle3 = new Triangle(b, c, a)
        triangle1 should equal (triangle2)
        triangle2 should equal (triangle3)
        triangle3 should equal (triangle1) 
      }
    }

    it should "similar to that whose sides have lengths in the same ratio" in {
      val triangle1 = new Triangle(3, 4, 5)
      val triangle2 = new Triangle(5 * 2, 3 * 2, 4 * 2)
      assert(triangle1 similar triangle2)
      assert(triangle2 similar triangle1)
    }

    "Triangle.area" must "be 6 given the lengths of sides are 3, 4, 5" in {
      val triangle = new Triangle(3, 4, 5)
      triangle.area must be (6.0)
    }

}
