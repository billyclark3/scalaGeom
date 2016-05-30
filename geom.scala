
class Point(val x: Int, val y:Int)


class Region(val bounds: Array[(Int,Int)=>Boolean]) {
	 def getFilter(): (Int,Int) => Boolean = { 
		 bounds.fold( (x:Int, y:Int) => true  ) {
			 (
				 cumulativeBool: (Int, Int) => Boolean,
				 lambda: (Int, Int) => Boolean) => ( (x: Int, y: Int) => cumulativeBool(x,y) & lambda(x,y)
				 )
		 }  
	 }
	 def and(that: Region): Region = new Region(this.bounds ++ that.bounds)
	 def containsPoint(p: Point): Boolean = getFilter()(p.x,p.y)
 }