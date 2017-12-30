package impopack

import com.amirhosseinSmo.typeController.db.{Db, Master, Role, Slave}
import slick.lifted.TableQuery
import impopack.userTable
import slick.driver.PostgresDriver.api._

import scala.concurrent.Future
import scala.util.Random

class UserReadService(dbs:List[Db[Slave]]) extends userTable{

  def getUserById(id:Int): Future[Option[User]] = {

    val user = TableQuery[Users]
    dbs(Random.nextInt(dbs.length)).run(user.filter(_.id === id).result.headOption)

  }

}
