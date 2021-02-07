package streams

object support {

  for { i <- 1 to 10 if i % 2 == 0 } yield i      //> res0: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4, 6, 8, 10)

  val list = List.range(1, 10, 1)                 //> list  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  List.range(1, 10, 1).filter(x => x % 2 == 0)    //> res1: List[Int] = List(2, 4, 6, 8)

  def range(start: Int, end: Int): Stream[Int] = {
    if (start >= end) Stream.empty
    else Stream.cons(start, range(start + 1, end))
  }                                               //> range: (start: Int, end: Int)Stream[Int]

  def range2(start: Int, end: Int): Stream[Int] = {
    if (start >= end) Stream.empty
    else start #:: range2(start + 1, end) //Stream.cons(start, range(start + 1, end))
  }                                               //> range2: (start: Int, end: Int)Stream[Int]
  
  val xxx = range(1,10) #::: range2(11,20)        //> xxx  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
  
  
  
  xxx.foldRight(List[Int]())( (x,y) => x :: y )   //> res2: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17
                                                  //| , 18, 19)
   
   Set.empty                                      //> res3: scala.collection.immutable.Set[Nothing] = Set()
   List.empty                                     //> res4: List[Nothing] = List()
   List(1111,2,3,0,111,10,4,1111,14,1).toStream.minBy(elem => elem)
                                                  //> res5: Int = 0
   
   xxx.minBy(elem => elem)                        //> res6: Int = 1
   
}