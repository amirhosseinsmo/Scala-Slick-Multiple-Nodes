package com.pintapin.typeController.db
import slick.driver.PostgresDriver
import slick.driver.PostgresDriver.backend.DatabaseDef
import slick.driver.PostgresDriver.api._

sealed trait DatabaseConfiguration[R <: Role] {
  def createDatabase(): DatabaseDef
}

object DatabaseConfiguration {
  object Master extends DatabaseConfiguration[Master] {
    def createDatabase() = Database.forConfig("dbs.master")
  }

  object Slave extends DatabaseConfiguration[Slave] {
    def createDatabase() = Database.forConfig("dbs.slave")
  }

  object MasterAsSlave extends DatabaseConfiguration[Slave]{
    override def createDatabase(): PostgresDriver.backend.DatabaseDef = Database.forConfig("dbs.master")
  }
}