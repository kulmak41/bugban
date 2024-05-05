data class Problem(val hash: String, val data: Set<String>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Problem

        if (hash != other.hash) return false
        if (data != other.data) return false

        return true
    }

    override fun hashCode(): Int {
        return hash.hashCode()
    }
}