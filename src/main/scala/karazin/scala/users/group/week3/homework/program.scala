package karazin.scala.users.group.week3.homework

import java.util.UUID
import scala.concurrent.{ExecutionContext, ExecutionContextExecutorService, Future}
import scala.util.Success
import scala.util.Failure
import karazin.scala.users.group.week3.homework.model._
import karazin.scala.users.group.week3.homework.services.{getComments, getLikes, getShares}

import java.util.concurrent.Executors
import scala.concurrent.ExecutionContext.Implicits.global


object program:

  def getPostView(post: Post): Future[PostView] =
    val fixedThreadPoolContext: ExecutionContextExecutorService =
        ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(3))
    val getCommentsService  = getComments(post.postId)(fixedThreadPoolContext)
    val getLikesService     = getLikes(post.postId)(fixedThreadPoolContext)
    val getSharesService    = getShares(post.postId)(fixedThreadPoolContext)
    
    for
      comments  ← getCommentsService
      likes     ← getLikesService
      shares    ← getSharesService
    yield PostView(post, comments, likes, shares)
