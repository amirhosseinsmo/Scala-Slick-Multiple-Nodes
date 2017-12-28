package com.pintapin.typeController.db

import slick.dbio.{DBIOAction, NoStream}
import slick.driver.PostgresDriver.api._

import scala.concurrent.Future

class Db[R <: Role](databaseConfig: DatabaseConfiguration[R]) {

  private val underlyingDatabase = databaseConfig.createDatabase()

  def run[A, E <: Effect](a: DBIOAction[A, NoStream, E])(implicit p: R HasPrivilege E): Future[A] = underlyingDatabase.run(a)

}
