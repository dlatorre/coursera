package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)

    val even = (x: Int) => x % 2 == 0
    val odd = (x: Int) => x % 2 == 1
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "singleton")
      assert(!contains(s1, 2), "singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersect contains all elements that are in both sets)") {
    new TestSets {
      val noSingletonIntersection = intersect(s1, s2)
      assert(!contains(noSingletonIntersection, 1), "intersect two singleton sets")

      val positives = intersect(s1, x => x > 0)
      assert(contains(positives, 1), "intersect singleton set with value 1 and positive set")
    }
  }

  test("diff contains all elements that are not in the other set") {

    new TestSets {
      val s = diff(s1, s2)
      assert(contains(s, 1), "diff using singleton sets")

      val x = diff(s1, x => x > 0)
      assert(!contains(x, 1), "'one' singleton set always is positive number")

      val y = diff(x => x > 0, x => x % 2 == 0)
      assert(!contains(y, 4), "value is multiple of two and positive")
      assert(contains(y, 3), "value is not multiple of two but positive")
    }
  }

  test("additional diff ") {
    new TestSets {
      //diff of {1,3,4,5,7,1000} and {1,2,3,4}
      // diff of {1,2,3,4} and {-1000,0}
      val s = diff(x => x >= 1 && x <= 4, x => x == 1000 || x == 0)
      assert(contains(s, 1), "one should be in diff operation")
      assert(contains(s, 2), "two should be in diff operation")
      assert(contains(s, 3), "three should be in diff operation")
      assert(contains(s, 4), "four should be in diff operation")
      assert(!contains(s, -1000), "-1000 should not be in diff operation")
    }
  }

  test("filters") {
    new TestSets {

      assert(contains(filter(s1, x => x > 0), 1), "filter positive elements")
      assert(contains(filter(odd, x => x > 0 && x <= 10), 3), "filter the ten first odd numbers")
      assert(contains(filter(odd, x => x > 0 && x <= 10), 5), "filter the ten first odd numbers")
      assert(contains(filter(odd, x => x > 0 && x <= 10), 9), "filter the ten first odd numbers")
      assert(!contains(filter(odd, x => x > 0 && x <= 10), 2), "filter the ten first odd numbers")
      assert(!contains(filter(odd, x => x > 0 && x <= 10), 8), "filter the ten first odd numbers")

    }
  }

  test("forall") {
    new TestSets {
      assert(forall(even, x => x % 2 == 0), "even set satisfies even predicate")
      assert(!forall(even, x => x % 2 == 1), "even set does not satisfy even predicate")

      assert(forall(odd, x => x % 2 == 1), "odd set satisfies odd predicate")
    }
  }

  test("exists") {
    new TestSets {
      assert(exists(even, x => x == -1000), "Exists -1000")
      assert(exists(even, x => x == 2), "Exists 2")
      assert(!exists(even, x => x == 3), "Exists 3")
      assert(exists(odd, x => x == 3), "Exists 3")
      assert(!exists(even, x => x == 12345), "Exists 12345")
    }
  }

  test("map") {
    new TestSets {

      val s = union(singletonSet(2), singletonSet(3))
      val mapS = map(s, x => 2 * x)

      assert(contains(mapS, 4), " 4 belongs to map set: 4 = 2 * 2")
      assert(!contains(mapS, 5), " 5 does not belong to map set: 4 = 2 * 2 and 6 = 3 * 2")

    }
  }

}
