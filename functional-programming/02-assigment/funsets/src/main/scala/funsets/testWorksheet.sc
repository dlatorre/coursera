package funsets

object testWorksheet {
  println("hello")                                //> hello
  
  type Set = Int => Boolean
  
  def xxx (s:Set, x:Int) = s(x)                   //> xxx: (s: Int => Boolean, x: Int)Boolean
  
  xxx( x => x >= 0, -1)                           //> res0: Boolean = false
  xxx( x => x >= 0, 1)                            //> res1: Boolean = true
  
    def singletonSet(elem: Int): Set = x => x == elem
                                                  //> singletonSet: (elem: Int)Int => Boolean
    
    singletonSet(1)(1)                            //> res2: Boolean = true
    singletonSet(2)(2)                            //> res3: Boolean = true
    
    
    
    def launcher (x:Int):Boolean = singletonSet(1)(x)
                                                  //> launcher: (x: Int)Boolean
    
    launcher(1)                                   //> res4: Boolean = true
    launcher(2)                                   //> res5: Boolean = false

}