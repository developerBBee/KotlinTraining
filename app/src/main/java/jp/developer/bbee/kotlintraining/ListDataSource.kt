package jp.developer.bbee.kotlintraining

class ListDataSource {
    companion object {
        private val keyList: List<String> = listOf(
        "a",
        "b",
        "c",
        "d",
        "e",
        "f",
        "g",
        "h",
        "i",
        "j",
        "k",
        "l",
        "m",
        "n",
        )
        fun getAllNames(): List<String> {
            return keyList
        }

        private val items : Map<String, Map<String,String>> = mapOf(
            Pair("a", mapOf(Pair("alias", "a is ..."), Pair("info", "AAAAA"))),
            Pair("b", mapOf(Pair("alias", "b is ..."), Pair("info", "BBBBB"))),
            Pair("c", mapOf(Pair("alias", "c is ..."), Pair("info", "CCCCC"))),
            Pair("d", mapOf(Pair("alias", "d is ..."), Pair("info", "DDDDD"))),
            Pair("e", mapOf(Pair("alias", "e is ..."), Pair("info", "EEEEE"))),
            Pair("f", mapOf(Pair("alias", "f is ..."), Pair("info", "FFFFF"))),
            Pair("g", mapOf(Pair("alias", "g is ..."), Pair("info", "GGGGG"))),
            Pair("h", mapOf(Pair("alias", "h is ..."), Pair("info", "HHHHH"))),
            Pair("i", mapOf(Pair("alias", "i is ..."), Pair("info", "IIIII"))),
            Pair("j", mapOf(Pair("alias", "j is ..."), Pair("info", "JJJJJ"))),
            Pair("k", mapOf(Pair("alias", "k is ..."), Pair("info", "KKKKK"))),
            Pair("l", mapOf(Pair("alias", "l is ..."), Pair("info", "LLLLL"))),
            Pair("m", mapOf(Pair("alias", "m is ..."), Pair("info", "MMMMM"))),
            Pair("n", mapOf(Pair("alias", "n is ..."), Pair("info", "NNNNN"))),
        )
        fun getInfoByName(key: String?) : Map<String,String>{
            val k = key ?: "z"
            return items[k] ?: mapOf(Pair("alias", "None"), Pair("info", "None"))
        }
    }
}
