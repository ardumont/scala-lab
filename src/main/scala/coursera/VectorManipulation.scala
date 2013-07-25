package coursera

object sessionVectorManipulation {

  def main(args: Array[String]) = {
    def combi(m: Int, n: Int) = {
      (1 to m) flatMap (x => (1 to n) map (y => (x, y)))
    }

    def scalarPdt(xs: Vector[Int], ys: Vector[Int]): Int =
      (xs zip ys) map (xy => xy._1 * xy._2) sum

    val nums = Vector(1, 2, 3, -88)
    val names = Vector("one", "two", "three", "minus eighty eight")

    val nums2 = Vector(2, 3, 4, 0)

    println(nums)
    println(names)
    println(names zip nums)
    println(combi(2, 10))

    println(scalarPdt(nums, nums2))
  }

}

// [info] Running coursera.sessionVectorManipulation
// Vector(1, 2, 3, -88)
// Vector(one, two, three, minus eighty eight)
// Vector((one,1), (two,2), (three,3), (minus eighty eight,-88))
// Vector((1,1), (1,2), (1,3), (1,4), (1,5), (1,6), (1,7), (1,8), (1,9), (1,10), (2,1), (2,2), (2,3), (2,4), (2,5), (2,6), (2,7), (2,8), (2,9), (2,10))
// 20
// [success] Total time: 1 s, completed 25 juil. 2013 14:47:56
