# scalaGeom
Scala implementation of my computational Geometry library, previously written in Ruby. I'm starting this one by defining a Region class that is bound by several functions: for instance, the lines y <= x, y >=0, x <= 2, are bounds for a right triangle in the cartesian plane. If these functions can be represented as lambdas that return true or false for a point with given coordinates, then a Region can be represented by a class that contains a collection of these lambdas, and a method to return true or false if a given point is in the Region.

The Region class is compiled. Next up I'm writing tests and implementing some more Geometry features from the Ruby computational geometry library I wrote (https://github.com/billyclark3/geometry-rb).
