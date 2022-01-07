class Solution {
    fun removeSubfolders(folder: Array<String>) = folder.sortedBy { it.split("/").size }
        .toTypedArray()
        .apply {
            for (i in indices) {
                if (this[i].isNotEmpty()) {
                    for (j in i + 1 until size) {
                        if (this[j].isSubFolderOf(this[i])) {
                            this[j] = ""
                        }
                    }
                }
            }
        }.filter { it.isNotEmpty() }

    private fun String.isSubFolderOf(folder: String) = startsWith(folder) && this[folder.length] == '/'
}
