package co.com.japl.alameda181.core.model

data class Carousel(
    val id:Int,
    val name:String,
    val description:String,
    val url:String,
    val order:Int,
    val drawable: Int,
    val active: Boolean
)
