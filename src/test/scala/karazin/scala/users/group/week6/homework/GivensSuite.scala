package karazin.scala.users.group.week6.homework

import scala.concurrent.Future

/*
  Write test for all programs in karazin.scala.users.group.week4.homework.givens

  Make sure that the following cases are tested:
    • json string representation for integers works
    • json string representation for booleans works
    • json string representation for strings works
    • json string representation for lists for integers, booleans and strings works
    • json string representation for maps for integers, booleans and strings works
    • all instances for integers, booleans, strings and lists should be randomly generated by scalacheck 
      (that's a good time to uncover homework implementations from the previous semester)

  Review:
    • https://www.json.org/json-en.html
    • https://scalameta.org/munit/docs/tests.html
    • https://scalameta.org/munit/docs/assertions.html
    • https://scalameta.org/munit/docs/assertions.html#compileerrors
    • https://scalameta.org/munit/docs/integrations/scalacheck.html
    
  NB: Do not use sync, this homework does not belong async stuff
    
 */
class GivensSuite extends munit.FunSuite:
  
  test("successful test example") {
    assertEquals(42, 42)
  }