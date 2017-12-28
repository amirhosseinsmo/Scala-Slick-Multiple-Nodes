name := "Amir_slick"

version := "1.0"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.2.1",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.1",
  "com.github.tminglei" %% "slick-pg" % "0.15.0-RC",
  "com.github.tminglei" %% "slick-pg_json4s" % "0.15.0-RC",
  "com.github.tminglei" %% "slick-pg_jts" % "0.15.0-RC",
  "com.github.tminglei" %% "slick-pg_play-json" % "0.15.0-RC"
)
