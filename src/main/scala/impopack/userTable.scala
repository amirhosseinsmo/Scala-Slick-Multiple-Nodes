package impopack

import slick.jdbc.PostgresProfile.api.Database
import slick.jdbc.PostgresProfile.Table
import PostgresDriver.api._
import com.sun.org.apache.bcel.internal.generic.Select
import example.PostgresDriver
import slick.jdbc.GetResult
import slick.lifted.{ProvenShape, Rep, TableQuery, Tag}

import scala.concurrent.{Await, Future, duration}
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by a-mohammadi on 8/21/17.
  */
trait userTable {

  class Users(tag: Tag) extends Table[User](tag, "amirhossein_users") {

    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

    def email = column[Option[String]]("user_email")

    def first_name = column[Option[String]]("user_first_name")

    def last_name = column[Option[String]]("user_last_name")

    def * = (id, email, first_name, last_name) <> (User.tupled, User.unapply)
  }

  class UserInfo(tag: Tag) extends Table[userInfo](tag, "amirhossein_user_inf") {

    val query = TableQuery[Users]

    def id = column[Int]("user_id")

    def order = column[Int]("order", O.PrimaryKey, O.AutoInc)

    def phone = column[Option[Int]]("phone")

    def country = column[Option[String]]("country")

    def city = column[Option[String]]("city")

    def adderss = column[Option[String]]("address")

    def postalCode = column[Option[String]]("postal_code")

    def user_id = foreignKey("user_id", id, query)(_.id, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Cascade)

    def * = (id, order, phone, country, city, adderss, postalCode) <> (userInfo.tupled, userInfo.unapply)




  }



}

object Users extends userTable{
  lazy val userQuery = TableQuery[Users]
}
