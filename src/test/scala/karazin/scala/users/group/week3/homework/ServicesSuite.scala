package karazin.scala.users.group.week3.homework

import karazin.scala.users.group.week3.homework.model._
import karazin.scala.users.group.week3.homework.services._

import java.util.UUID
import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.ExecutionContext.Implicits.global

/*
  Write test for all service in karazin.scala.users.group.week3.homework.services

  Review:
    • https://scalameta.org/munit/docs/tests.html
    • https://scalameta.org/munit/docs/assertions.html
 */

class ServicesSuite extends munit.FunSuite :
  test("getUserProfile") {
    getUserProfile()(ExecutionContext.global) map {
      obj => assert(obj.isInstanceOf[UserProfile])
    }
  }

  test("getPosts") {
    getPosts(UUID.randomUUID)(ExecutionContext.global) map {
      obj => assert(obj.isInstanceOf[List[Post]])
    }
  }

  test("getLikes") {
    getLikes(UUID.randomUUID)(ExecutionContext.global) map {
      obj => assert(obj.isInstanceOf[List[Like]])
    }
  }

  test("getShares") {
    getShares(UUID.randomUUID)(ExecutionContext.global) map {
      obj => assert(obj.isInstanceOf[List[Share]])
    }
  }

  
