package impopack

import slick.jdbc.PostgresProfile.api.Database
import PostgresDriver.api._
import com.pintapin.typeController.db.DatabaseModule
//import example.PostgresDriver
import org.joda.time.Seconds
import slick.jdbc.GetResult
import slick.lifted.TableQuery
import slick.sql

import scala.concurrent.Await
import scala.concurrent.{Await, Future, duration}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random
import scala.xml.Elem






/**
  * Created by a-mohammadi on 8/21/17.
  */
object Main extends App with userTable {

  val user = User(1, Some("marmhossein98@gmail.com"), Some("Mike"), Some("Jackson"))
  val dbMoldule = new DatabaseModule
  val userModule = new UserModule(dbMoldule)

  val newUserQ = userModule.userService.persistUser(user)
  val readUser = userModule.userReadService.getUserById(1)
  val updateUser = userModule.userService.updateUser(34 , "Andrea" , "Bocelli")
  Await.result(newUserQ, duration.pairIntToDuration(5, duration.SECONDS))
  val m = Await.result(readUser, duration.pairIntToDuration(5, duration.SECONDS))
  val u = Await.result(updateUser, duration.pairIntToDuration(5, duration.SECONDS))
  println(m.get)

}