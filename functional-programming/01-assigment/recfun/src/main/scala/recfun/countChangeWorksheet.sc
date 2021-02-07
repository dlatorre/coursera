
package recfun

object countChangeWorksheet {

	

 	val llista1:List[Int] = List(1,1,2,2,2,3) //> llista1  : List[Int] = List(1, 1, 2, 2, 2, 3)
	val freq:Map[Int,Int] = llista1.groupBy(identity).mapValues(_.size)
                                                  //> freq  : Map[Int,Int] = Map(2 -> 3, 1 -> 2, 3 -> 1)
	val llista2:List[Int] = List(1,1,2,2,2,3) //> llista2  : List[Int] = List(1, 1, 2, 2, 2, 3)
	val freq2:Map[Int,Int] = llista2.groupBy(identity).mapValues(_.size)
                                                  //> freq2  : Map[Int,Int] = Map(2 -> 3, 1 -> 2, 3 -> 1)
	
	


  val prova: List[(Int, Int)] = List((1, 2), (3, 4))
                                                  //> prova  : List[(Int, Int)] = List((1,2), (3,4))
  val prova2: List[(Int, Int)] = List((1, 2), (5, 4))
                                                  //> prova2  : List[(Int, Int)] = List((1,2), (5,4))
  
  (prova ::: prova2).distinct                     //> res0: List[(Int, Int)] = List((1,2), (3,4), (5,4))
  
  prova.head._1                                   //> res1: Int = 1

  val coins: List[Int] = List(1, 2, 3)            //> coins  : List[Int] = List(1, 2, 3)
  coins.foreach((element: Int) => if (2 - element >= 0) println(element))
                                                  //> 1
                                                  //| 2

  // def countChange(money: Int, coins: List[Int]): Int = ???

  def loop(money: Int, coins: List[Int], ways: List[Int], ongoing: List[Int]): Unit =

    if (money == 0) println(ongoing)
    else coins.foreach((element: Int) => if (money - element >= 0) loop(money - element, coins, ways, ongoing ::: List(element)))
                                                  //> loop: (money: Int, coins: List[Int], ways: List[Int], ongoing: List[Int])Uni
                                                  //| t

  val ways = List()                               //> ways  : List[Nothing] = List()
  loop(4, List(1, 2), ways, List())               //> List(1, 1, 1, 1)
                                                  //| List(1, 1, 2)
                                                  //| List(1, 2, 1)
                                                  //| List(2, 1, 1)
                                                  //| List(2, 2)
  loop(0, List(1, 2), ways, List())               //> List()
  loop(4, List(), ways, List())

  loop(4, List(3), ways, List())
  loop(4, List(3, 1), ways, List())               //> List(3, 1)
                                                  //| List(1, 3)
                                                  //| List(1, 1, 1, 1)

println(ways)                                     //> List()

def countChange(money: Int, coins: List[Int]): Int =
		
    if (money == 0) 1
    else if (money  < 0) 0
    else if (coins.isEmpty && money > 0) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
                                                  //> countChange: (money: Int, coins: List[Int])Int
    // else coins.((element: Int) => if (money - element >= 0) loop2(money - element, coins, ongoing ::: List(element)))
    
 //   loop2(4, List(1,2))
   // loop2(4, List(3))
   // loop2(4, List(1,3))
    //loop2(4, List(3,1))
    countChange(0, List(1,3))                     //> res2: Int = 1
    //loop2(4, List())
    
    
}