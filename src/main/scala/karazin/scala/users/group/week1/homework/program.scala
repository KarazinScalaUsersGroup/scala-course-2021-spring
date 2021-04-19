package karazin.scala.users.group.week1.homework

// Do not forget to import custom implementation
import adt._
import model._
import services._

object program:

  /*
   Print all view for all user's posts if they exists
  */
  def printPostsViews(): ErrorOr[List[PostView]] = 
    for
      postsViews ← getPostsViews()
    yield
      postsViews.foreach(postView => println(postView))
      postsViews

  /*
   Getting view for all user's posts if they exists
  */
  def getPostsViews(): ErrorOr[List[PostView]] =
    for
      profile    ← getUserProfile()
      posts      ← getPosts(profile.userId)
      postsViews ← ErrorOr(posts map { post ⇒ getPostView(post) })
      flattenPostsViews ← ErrorOr(postsViews.foldLeft(List[PostView]()){
        (acc, element) ⇒ element match
          case ErrorOr.Some(v: PostView) ⇒ v :: acc
          case ErrorOr.Failer(_) ⇒ acc
      })
    yield flattenPostsViews

  /*
    Getting view for a particular user's post
    Provide an argument and a result type
  */
  def getPostView(post: Post): ErrorOr[PostView] =
    for
      comments  ← getComments(post.postId)
      likes     ← getLikes(post.postId)
      shares    ← getShares(post.postId) 
    yield PostView(post, comments, likes, shares)

  def getPostsViewDesugared(): ErrorOr[List[ErrorOr[PostView]]] =
    getUserProfile() flatMap { profile ⇒
      getPosts(profile.userId)} map { posts ⇒
      posts map { post ⇒
        getComments(post.postId) flatMap { comments ⇒
          getLikes(post.postId) flatMap { likes ⇒
            getShares(post.postId) map { shares ⇒
              PostView(post, comments, likes, shares)
            }
          }
        }
      }
    }


  
