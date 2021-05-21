package karazin.scala.users.group.week13.topic

import cats.Applicative
import cats.data.WriterT
import cats.implicits._

import java.util.UUID
import karazin.scala.users.group.week13.topic.model._

import java.io.Writer


object services:
  type Log = List[String]
  type Logged[V] = WriterT[Option, Log, V]
  type Comments = List[Comment]
  type Likes = List[Like]
  type Shares = List[Share]

  val getComments: UUID ⇒ Logged[Comments]  =
  uuid ⇒
    for {
     _        ← WriterT.tell("Executing `getComments`" :: Nil)
     comments ← WriterT.valueT(Option(List(Comment(userId = UUID.randomUUID(), uuid))))
     _        ← WriterT.tell("`getComments` successfuly executed" :: Nil)
   } yield comments

  val getLikes: UUID ⇒ Logged[Likes] =
   uuid ⇒
     for {
       _     ← WriterT.tell("Executing `getLikes`" :: Nil)
       likes ← WriterT.valueT(Option(List(Like(userId = UUID.randomUUID(), uuid))))
       _     ← WriterT.tell("`getLikes` successfuly executed" :: Nil)
     } yield likes

  val getShares: UUID ⇒ Logged[Shares] =
   uuid ⇒
     for {
       _       ← WriterT.tell("Executing `getShares`" :: Nil)
       shares  ← WriterT.valueT(Option(List(Share(userId = UUID.randomUUID(), uuid))))
       _       ← WriterT.tell("`getShares` successfuly executed" :: Nil)
     } yield shares
