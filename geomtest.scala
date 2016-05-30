
 import org.scalatest._
 import org.scalatest.FlatSpec
 
 class ExampleSpec extends FlatSpec with Matchers  {
	 

     def fixture =
       new {
  		 val r1 = new Region(Array(
  			 (x: Int, y: Int) => x >= 0,
   			 (x: Int, y: Int) => y >= 0,
  			 (x: Int, y: Int) => y <= 100-x
  			 ))
  		 val r2 = new Region(Array(
  			 (x: Int, y: Int) => x <= 10,
  	 		 (x: Int, y: Int) => y <= 10
  			 ))
  		 val r3 = new Region(Array(
  			(x: Int, y: Int) => y <= x
  			))
       }
	 
	 "A Region" should "be addable to other regions such that their bounds are merged" in {
		 val r4 = r1 and r2
		 r4.bounds should equal (r1.bounds ++ r2.bounds)
	 }
	 
	 "A Region" should "be able to test for containment of given points" in {
		 val r3 = r1 and r2 and r3
		 val p1 = new Point(4,2)
		 val p2 = new Point(-1,-1)
		 val p3 = new Point(-1,1)
		 r3.containsPoint(p1) should be true
		 r3.containsPoint(p2) should be false
		 r3.containsPoint(p3) should be false
	 }

 }
	 