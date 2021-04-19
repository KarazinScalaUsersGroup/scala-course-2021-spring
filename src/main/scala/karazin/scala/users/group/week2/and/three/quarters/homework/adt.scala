package karazin.scala.users.group.week2.and.three.quarters.homework

import scala.util.{Failure, Success, Try}

/* 
  Custom implementation of Option (Maybe monad in Haskell)
  Implemented via Scala 3 way for Algebraic Data Types (ADT)
  
  Resources:
  * https://en.wikipedia.org/wiki/Algebraic_data_type
  * https://docs.scala-lang.org/scala3/book/types-adts-gadts.html
*/

object adt:

  enum ErrorOr[+V]:
    case Some(x: V) extends ErrorOr[V]
    case Failure(x: Throwable) extends ErrorOr[V]

    /* 
      Two case must be defined: 
      * a case for a regular value
      * a case for an error (it should contain an actual throwable)
     */

    /* 
      The method is used for defining execution pipelines
      Provide a type parameter, an argument and a result type
      
      Make sure that in case of failing the method with exception
      no exception is thrown but the case for an error is returned
    */
    def flatMap[Q](f: V ⇒ ErrorOr[Q]): ErrorOr[Q] = this match
      case ErrorOr.Some(v) ⇒ ErrorOr.fromTry(Try(f(v))).flatten
      case ErrorOr.Failure(e) ⇒ ErrorOr.Failure(e)

    /* 
      The method is used for changing the internal object
      Provide a type parameter, an argument and a result type
      
      Make sure that in case of failing the method with exception
      no exception is thrown but the case for an error is returned
     */
    def map[Q](f: V ⇒ Q): ErrorOr[Q] = this match
      case ErrorOr.Some(v) ⇒ ErrorOr.fromTry(Try(f(v)))
      case ErrorOr.Failure(e) ⇒ ErrorOr.Failure(e)

    /* 
      The method is used for filtering
      Provide a type parameter, an argument and a result type
      
      Make sure that in case of failing the method with exception
      no exception is thrown but the case for an error is returned
     */
    def withFilter(p: V => Boolean): ErrorOr[V] = this match
      case ErrorOr.Some(v) ⇒ {
        ErrorOr.fromTry(Try(p(v)))
        this
      }
      case ErrorOr.Failure(e) ⇒ ErrorOr.Failure(e)

    /* 
      The method is used for getting rid of internal box
      Provide a type parameter, an argument and a result type
    */
    def flatten[U](implicit ev: V <:< ErrorOr[U]): ErrorOr[U] = this match
      case ErrorOr.Failure(e) ⇒ ErrorOr.Failure(e)
      case ErrorOr.Some(v) ⇒ v

    /* 
      The method is used for applying side effects without returning any result
      Provide a type parameter, an argument and a result type
    */
    def foreach[U](f: V => U): Unit = this match
      case ErrorOr.Failure(e) ⇒ ()
      case ErrorOr.Some(v) ⇒ f(v)

  // Companion object to define constructor
  object ErrorOr:
    /* 
      Provide a type parameter, an argument and a result type
      
      Make sure that in case of failing the method with exception
      no exception is thrown but the case for an error is returned
    */
    def apply[V](v: V): ErrorOr[V] = v match
      case v: Throwable ⇒ ErrorOr.Failure(v)
      case _ ⇒ ErrorOr.Some(v)

    def fromTry[V](v: Try[V]): ErrorOr[V] = v.fold(e ⇒ ErrorOr.Failure(e), v ⇒ ErrorOr(v))

  
