package karazin.scala.users.group.week13.topic

import cats.FlatMap
import cats.Applicative
import cats.data.WriterT
import cats.implicits._

import java.util.UUID
import karazin.scala.users.group.week13.topic.model._
import karazin.scala.users.group.week13.topic.services._

object program extends App:

  val getPostView: Post ⇒ Logged[PostView] =
    post ⇒
      for {
         _         ← WriterT.tell("Executing `getPostView`" :: Nil)
         comments  ← getComments.apply(post.postId)
         likes     ← getLikes.apply(post.postId)
         shares    ← getShares.apply(post.postId)
         _         ← WriterT.tell("`getPostView` successfully executed" :: Nil)
      } yield PostView(post, comments, likes, shares)

  val result: Logged[PostView] = getPostView.apply(Post(userId = UUID.randomUUID(), postId = UUID.randomUUID()))

  val value: Option[PostView] = result.value
  val log: Option[Log] = result.written

  value foreach println

  log foreach { log ⇒ println(log mkString "\n") }








