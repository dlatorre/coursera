package recfun

object balanceWorksheet {
  val nums: List[Int] = List(1, 2, 3)             //> nums  : List[Int] = List(1, 2, 3)

  val with4 = 4 :: nums                           //> with4  : List[Int] = List(4, 1, 2, 3)
  nums.init                                       //> res0: List[Int] = List(1, 2)
  with4.init                                      //> res1: List[Int] = List(4, 1, 2)

  val llista: List[Char] = 'a' :: 'b' :: Nil      //> llista  : List[Char] = List(a, b)
  llista.head :: llista                           //> res2: List[Char] = List(a, a, b)


  def balance(chars: List[Char]): Boolean = {

    def loop(e: List[Char], s: List[Char]): List[Char] =
      if (e.isEmpty) s
      else if (')'.equals(e.head) && s.isEmpty) ')' :: s
      else if (')'.equals(e.head)) loop(e.tail, s.init)
      else if ('('.equals(e.head)) loop(e.tail, s ::: List('('))
      else loop(e.tail, s)

    return loop(chars, List()).isEmpty

  }                                               //> balance: (chars: List[Char])Boolean

  balance("(if (zero? x) max (/ 1 x))".toList)    //> res3: Boolean = true
  balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList)
                                                  //> res4: Boolean = true
  balance(":-)".toList)                           //> res5: Boolean = false
  balance("())(".toList)                          //> res6: Boolean = false

}