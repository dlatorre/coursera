package recfun

object worksheet {

  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)       //> factorial: (n: Int)Int

  factorial(2)                                    //> res0: Int = 2
  factorial(3)                                    //> res1: Int = 6
  factorial(4)                                    //> res2: Int = 24

  def fact(n: Int): Int = {

    def loop(acc: Int, n: Int): Int =

      if (n == 0) acc
      else loop(acc * n, n - 1)

    loop(1, n)

  }                                               //> fact: (n: Int)Int

  fact(2)                                         //> res3: Int = 2
  fact(3)                                         //> res4: Int = 6
  fact(4)                                         //> res5: Int = 24

  
  def pascal(c: Int, r: Int): Int =

    //if (c == 0) 0
    //else if (r == 1 && column == 1) 1
    //else if (c > r) 0
    if(c == 0 || r == c) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)  //> pascal: (c: Int, r: Int)Int
    
    
  
  pascal(0,2)                                     //> res6: Int = 1
  pascal(1,2)                                     //> res7: Int = 2
  pascal(1,3)                                     //> res8: Int = 3
  
  pascal(1,1)                                     //> res9: Int = 1
  
  pascal(1,2)                                     //> res10: Int = 2
  pascal(2,2)                                     //> res11: Int = 1
  
  pascal(1,3)                                     //> res12: Int = 3
  pascal(2,3)                                     //> res13: Int = 3
  pascal(3,3)                                     //> res14: Int = 1
  
  pascal(1,4)                                     //> res15: Int = 4
  pascal(2,4)                                     //> res16: Int = 6
  pascal(3,4)                                     //> res17: Int = 4
  pascal(4,4)                                     //> res18: Int = 1
  
  pascal(1,5)                                     //> res19: Int = 5
  pascal(2,5)                                     //> res20: Int = 10
  pascal(3,5)                                     //> res21: Int = 10
  pascal(4,5)                                     //> res22: Int = 5
  pascal(5,5)                                     //> res23: Int = 1
  
  pascal(1,6)                                     //> res24: Int = 6
  pascal(2,6)                                     //> res25: Int = 15
  pascal(3,6)                                     //> res26: Int = 20
  pascal(4,6)                                     //> res27: Int = 15
  pascal(5,6)                                     //> res28: Int = 6
  pascal(6,6)                                     //> res29: Int = 1
  
  
//               1
//      	     1    1
//    	    1    2    1
//   		 1    3    3    1
//  	 1    4    6    4    1
//		1   5   10  10    5   1




}