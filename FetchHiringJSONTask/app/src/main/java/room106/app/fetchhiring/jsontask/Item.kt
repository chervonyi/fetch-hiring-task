package room106.app.fetchhiring.jsontask

data class Item(
    var id: Int? = null,
    var listId: Int? = null,
    var name: String? = null
) {

    fun isNotNull(): Boolean {
        return id != null &&
                listId != null &&
                name != null && name!!.isNotEmpty()
    }
}