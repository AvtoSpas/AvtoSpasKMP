package classes

import java.sql.Time


data class Order (
    val id : String,
    val orderType : String,
    val time : String,
    val price: String,
    val address: String
)