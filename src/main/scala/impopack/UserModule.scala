package impopack

import javax.management.relation.Role

import com.pintapin.typeController.db.{DatabaseModule, Master, Slave}

class UserModule(databaseModule: DatabaseModule) {

  import databaseModule._

  val userReadService = new UserReadService(List(slaveDatabase,masterAsSlave))
  val userService = new UserService(masterDatabase)



}
