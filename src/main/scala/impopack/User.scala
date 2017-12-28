package impopack

/**
  * Created by a-mohammadi on 8/21/17.
  */
case class User(

               id : Int ,
               email : Option[String],
               first_name : Option[String],
               last_name : Option[String]


               )

case class userInfo(
                   id : Int,
                   order : Int,
                   phone : Option[Int],
                   country : Option[String],
                   city : Option[String] = None,
                   address : Option[String] = None,
                   postalCode : Option[String] = None

                   )