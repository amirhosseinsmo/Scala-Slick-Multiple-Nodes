package com.pintapin.typeController.db



class DatabaseModule {
  val masterDatabase: Db[Master] = new Db(DatabaseConfiguration.Master)
  val slaveDatabase: Db[Slave] = new Db(DatabaseConfiguration.Slave)
  val masterAsSlave:Db[Slave] = new Db(DatabaseConfiguration.MasterAsSlave)
}
