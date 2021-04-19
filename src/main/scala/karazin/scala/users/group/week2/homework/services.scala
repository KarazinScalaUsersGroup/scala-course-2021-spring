package karazin.scala.users.group.week2.homework

import java.util.UUID

// Do not forget to import custom implementation
import karazin.scala.users.group.week2.homework.adt._
import karazin.scala.users.group.week2.homework.model._

/*
  Dummy services
  
  The services need to be implemented in case of running the code
 */
object services:
  
   val uuid = UUID.randomUUID

  def getUserProfile(): ErrorOr[UserProfile] = ErrorOr(UserProfile(UUID.randomUUID))
  def getPosts(userId: UUID): ErrorOr[List[Post]] = ErrorOr(List(Post(UUID.randomUUID, UUID.randomUUID),
                                                                 Post(UUID.randomUUID, UUID.randomUUID)))
  def getComments(postId: UUID): ErrorOr[List[Comment]] = ErrorOr(Nil)
  def getLikes(postId: UUID): ErrorOr[List[Like]] = ErrorOr(List(Like(UUID.randomUUID, UUID.randomUUID),
                                                                 Like(UUID.randomUUID, UUID.randomUUID)))
  def getShares(postId: UUID): ErrorOr[List[Share]] = ErrorOr(Nil)
