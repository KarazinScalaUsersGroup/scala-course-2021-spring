package karazin.scala.users.group.week3.homework

import karazin.scala.users.group.week3.homework.model.{Post, PostView}
import karazin.scala.users.group.week3.homework.program.getPostView

import java.util.UUID
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/*
  Write test for all programs in karazin.scala.users.group.week3.homework.program

  Review:
    • https://scalameta.org/munit/docs/tests.html
    • https://scalameta.org/munit/docs/assertions.html
 */

class ProgramSuite extends munit.FunSuite :

  test("getPostView") {
    getPostView(Post(UUID.randomUUID, UUID.randomUUID)) map {
      obj => assert(obj.isInstanceOf[PostView])
    }
  }
