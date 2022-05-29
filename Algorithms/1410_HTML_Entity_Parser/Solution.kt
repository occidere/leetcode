class Solution {
    fun entityParser(text: String): String {
        val parsed = mutableListOf<String>()
        var i = 0
        while (i < text.length) {
            parsed += if (text[i] != '&') {
                "${text[i++]}"
            } else {
                val entityList = mutableListOf(text[i])
                var j = i + 1
                while (j < text.length) {
                    entityList += text[j]
                    if (text[j++] == ';') {
                        break
                    }
                }
                entityList.joinToString("")
                    .toEntity()
                    .run {
                        if (length == 1) {
                            i = j
                            this
                        } else {
                            "${text[i++]}"
                        }
                    }
            }
        }
        return parsed.joinToString("")
    }

    private fun String.toEntity() = when (this) {
        "&quot;" -> "\""
        "&apos;" -> "'"
        "&amp;" -> "&"
        "&gt;" -> ">"
        "&lt;" -> "<"
        "&frasl;" -> "/"
        else -> this
    }
}
