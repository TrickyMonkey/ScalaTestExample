import scala.math.pow
import scala.math.sqrt

class Triangle(val side1: Int, val side2: Int, val side3: Int) {
  require(side1 > 0)
  require(side2 > 0)
  require(side3 > 0)
  require(side1 < side2 + side3)
  require(side2 < side1 + side3)
  require(side3 < side1 + side2)

  override def equals(other:Any) = other match {
        case that: Triangle =>
            (that.isInstanceOf[Triangle]) &&
            (Set(this.side1, this.side2, this.side3) == Set(that.side1, that.side2, that.side3))
        case _ => false
  }

  def similar(other:Any) = other match {
        case that: Triangle => {
          val l1 = List(this.side1, this.side2, this.side3).sorted
          val l2 = List(that.side1, that.side2, that.side3).sorted
          (that.isInstanceOf[Triangle]) && (l1.zip(l2).map(x => x._1.toFloat / x._2).toSet.size == 1)
        }
        case _ => false
  }

  def area():Double = {
    val squareA = pow(this.side1, 2)
    val squareB = pow(this.side2, 2)
    val squareC = pow(this.side3, 2)
    return sqrt(4 * squareA * squareB - pow((squareA + squareB - squareC), 2)) / 4
  }
}
