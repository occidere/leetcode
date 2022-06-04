class Solution {
    fun getFolderNames(names: Array<String>) = names.run {
        mutableMapOf<String, String>()
            .let { nameMap -> map { nameMap.getValidName(it) } }
            .toTypedArray()
    }

    private fun MutableMap<String, String>.getValidName(name: String) =
        if (contains(name)) {
            val lastName = get(name)!!
            var (ver, nextName) = lastName.lastIndexOf('(').let {
                lastName.substring(it + 1, lastName.length - 1).toInt() to lastName.substring(0, it)
            }
            while (true) {
                if (!contains("$nextName(${++ver})")) {
                    nextName += "($ver)"
                    break
                }
            }
            put(name, nextName)
            put(nextName, "$nextName(0)")
            nextName
        } else {
            put(name, "$name(0)")
            name
        }
}
