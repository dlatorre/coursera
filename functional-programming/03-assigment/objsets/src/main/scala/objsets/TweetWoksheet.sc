package objsets

object TweetWoksheet {
  val set1 = new Empty                            //> set1  : objsets.Empty = .
  val a = new Tweet("a", "a body", 20)            //> a  : objsets.Tweet = User: a
                                                  //| Text: a body [20]
  val set2 = set1.incl(a)                         //> set2  : objsets.TweetSet = {.User: a
                                                  //| Text: a body [20].}
  val b = new Tweet("b", "b body", 20)            //> b  : objsets.Tweet = User: b
                                                  //| Text: b body [20]
  val set3 = set2.incl(b)                         //> set3  : objsets.TweetSet = {.User: a
                                                  //| Text: a body [20]{.User: b
                                                  //| Text: b body [20].}}
  val c = new Tweet("c", "c body", 7)             //> c  : objsets.Tweet = User: c
                                                  //| Text: c body [7]
  val d = new Tweet("d", "d body", 9)             //> d  : objsets.Tweet = User: d
                                                  //| Text: d body [9]
  val set4c = set3.incl(c)                        //> set4c  : objsets.TweetSet = {.User: a
                                                  //| Text: a body [20]{.User: b
                                                  //| Text: b body [20]{.User: c
                                                  //| Text: c body [7].}}}
  val set4d = set3.incl(d)                        //> set4d  : objsets.TweetSet = {.User: a
                                                  //| Text: a body [20]{.User: b
                                                  //| Text: b body [20]{.User: d
                                                  //| Text: d body [9].}}}
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  val set5 = set4c.incl(d)                        //> set5  : objsets.TweetSet = {.User: a
                                                  //| Text: a body [20]{.User: b
                                                  //| Text: b body [20]{.User: c
                                                  //| Text: c body [7]{.User: d
                                                  //| Text: d body [9].}}}}
  
  set5 mostRetweeted                              //> res0: objsets.Tweet = User: a
                                                  //| Text: a body [20]
    
  set5 remove(a) remove(b) remove(c) remove(d)    //> res1: objsets.TweetSet = .
  set5 remove(a)                                  //> res2: objsets.TweetSet = {.User: b
                                                  //| Text: b body [20]{.User: c
                                                  //| Text: c body [7]{.User: d
                                                  //| Text: d body [9].}}}
  //set5.remove(a).remove(b).remove(c)
  
  
  
  set5.descendingByRetweet.head                   //> res3: objsets.Tweet = User: a
                                                  //| Text: a body [20]
 
   //TweetReader.allTweets
   
   
   
   
   
   val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")
                                                  //> apple  : List[String] = List(ios, iOS, iphone, iPhone, ipad, iPad)

  apple.exists(p => "iosxsf".contains(p))         //> res4: Boolean = true
	                                                  
                                                  

}