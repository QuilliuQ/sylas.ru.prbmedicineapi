data class QueueData(
    val personCode : Int,
    val personRole : String,
    val lastSecurityPointNumber : Int,
    val lastSecurityPointDirection : String,
    val lastSecurityPointTime: String
)

enum class Role(val text : String){
    PATIENT("Клиент"),
    EMPLOYEE("Сотрудник");
}

enum class EntryType(val text : String){
    IN("in"),OUT("out")
}