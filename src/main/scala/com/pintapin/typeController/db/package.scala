package com.pintapin.typeController

import com.pintapin.typeController.db.HasPrivilege
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Schema
import slick.dbio.Effect
import slick.dbio.Effect.{Read, Transactional, Write}

import scala.annotation.implicitNotFound

package object db {

  trait Role
  trait Master extends Role
  trait Slave extends Role

  @implicitNotFound("'${R}' database is not privileged to perform effect '${E}'.")
  trait HasPrivilege[R <: Role, E <: Effect]

  implicit val slaveCanRead: Slave HasPrivilege Read = null
  implicit val slaveCanDoExpensiveReads: Slave HasPrivilege ExpensiveRead = null

//  implicit val roleCanRead : Role HasPrivilege Read = null


  type ReadWriteTransaction = Read with Write with Transactional
  trait ExpensiveRead extends Read

  implicit val masterCanRead: Master HasPrivilege slick.dbio.Effect.Read = null
  implicit val masterCanWrite: Master HasPrivilege Write = null
//  implicit val masterCanUpdateSchema: Master HasPrivilege Schema = null
  implicit val masterCanPerformTransactions: Master HasPrivilege ReadWriteTransaction = null

}
