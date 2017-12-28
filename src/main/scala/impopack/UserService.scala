package impopack

import com.pintapin.typeController.db.{Db, Master}
import slick.jdbc.GetResult
import slick.driver.PostgresDriver.api._
import slick.lifted.TableQuery

import scala.concurrent.Future

class UserService(db:Db[Master]) {

  def persistUser(user: User): Future[User] = {

    implicit val getUserResult = GetResult(r => User(r.<<, r.<<, r.<<, r.<<))
    val query = Users.userQuery returning Users.userQuery.map(_.id) into ((item, id ) => item.copy(id = id))
    val action = query += user
    db.run(action)
  }

  def updateUser(id:Int , firstName:String , lastName:String) : Future[Int] ={

    val user = for{q <- Users.userQuery if q.id === id} yield(q.first_name , q.last_name)
    db.run(user.update(Option(firstName), Option(lastName)))
  }

}
