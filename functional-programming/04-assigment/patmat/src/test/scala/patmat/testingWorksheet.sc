package patmat

import scala.util.Sorting

object testingWorksheet {
  val l1 = List('a', 'b')                         //> l1  : List[Char] = List(a, b)

  'c' :: l1                                       //> res0: List[Char] = List(c, a, b)
  val l2 = List('c', 'd')                         //> l2  : List[Char] = List(c, d)

  l1 ::: l2                                       //> res1: List[Char] = List(a, b, c, d)
  l2.:::(l1)                                      //> res2: List[Char] = List(a, b, c, d)

  "55".toLong                                     //> res3: Long = 55
  "FALSE".toBoolean                               //> res4: Boolean = false
  "Hello world!!!".toList                         //> res5: List[Char] = List(H, e, l, l, o,  , w, o, r, l, d, !, !, !)

  val pair: (Char, Int) = ('c', 1)                //> pair  : (Char, Int) = (c,1)
  pair._1                                         //> res6: Char = c
  pair._2                                         //> res7: Int = 1

  import patmat.Huffman._

  val trees = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3))
                                                  //> trees  : List[patmat.Huffman.Leaf] = List(Leaf(e,1), Leaf(t,2), Leaf(x,3))

  trees match {
    case x :: y :: xs => println(y)
    case x :: Nil => trees
  }                                               //> Leaf(t,2)
                                                  //| res8: Any = ()

  val secret: List[Bit] = List(0, 0, 1, 1, 1, 0, 1)
                                                  //> secret  : List[patmat.Huffman.Bit] = List(0, 0, 1, 1, 1, 0, 1)

  val tree = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
                                                  //> tree  : patmat.Huffman.Fork = Fork(Leaf(a,2),Leaf(b,3),List(a, b),5)

  val x: List[(Char, List[Int])] = ('b', 1 :: 0 :: 0 :: Nil) :: ('a', 0 :: 0 :: 0 :: Nil) :: Nil
                                                  //> x  : List[(Char, List[Int])] = List((b,List(1, 0, 0)), (a,List(0, 0, 0)))
  val y: List[(Char, List[Int])] = ('d', 1 :: 0 :: 0 :: Nil) :: ('d', 0 :: 0 :: 0 :: Nil) :: Nil
                                                  //> y  : List[(Char, List[Int])] = List((d,List(1, 0, 0)), (d,List(0, 0, 0)))

  def convertAcc(tree: CodeTree, bits:List[Bit], codeTable:CodeTable): CodeTable = tree match {
         case elem:Leaf => (elem.char, bits) :: codeTable
         case elem:Fork =>
         	
         	convertAcc(elem.right, 1::bits, convertAcc(elem.left, 0::bits, codeTable))
  }                                               //> convertAcc: (tree: patmat.Huffman.CodeTree, bits: List[patmat.Huffman.Bit],
                                                  //|  codeTable: patmat.Huffman.CodeTable)patmat.Huffman.CodeTable
  
  val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
                                                  //> t2  : patmat.Huffman.Fork = Fork(Fork(Leaf(a,2),Leaf(b,3),List(a, b),5),Lea
                                                  //| f(d,4),List(a, b, d),9)
  
  convertAcc(t2, Nil, Nil)                        //> res9: patmat.Huffman.CodeTable = List((d,List(1)), (b,List(1, 0)), (a,List(
                                                  //| 0, 0)))
  val table = convert(t2)                         //> table  : patmat.Huffman.CodeTable = List((a,List(0, 0)), (b,List(0, 1)), (d
                                                  //| ,List(1)))
  
  val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
                                                  //> t1  : patmat.Huffman.Fork = Fork(Leaf(a,2),Leaf(b,3),List(a, b),5)
  
  encode(t2)("ab".toList)                         //> res10: List[patmat.Huffman.Bit] = List(0, 0, 0, 1)
  quickEncode(t2)("ab".toList)                    //> res11: List[patmat.Huffman.Bit] = List(0, 0, 0, 1)
  codeBits(convert(t2))('a')                      //> res12: List[patmat.Huffman.Bit] = List(0, 0)
  codeBits(convert(t2))('b')                      //> res13: List[patmat.Huffman.Bit] = List(0, 1)
  
  
 
//  decode(frenchCode,encode(frenchCode)(List('t', 'u', 'r', 'e',' ', 'f', 'r', 'o', 'm',' ', '4', '5',' ', 'B', 'C',' ')))

}