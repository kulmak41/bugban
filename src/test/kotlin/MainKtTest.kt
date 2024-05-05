import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MainKtTest {
    @Test
    fun partition() {
        val p1 = Problem("1", setOf("a", "b"))
        val p2 = Problem("2", setOf("a", "c"))
        val p3 = Problem("3", setOf("d", "c"))
        val analysis1 = Analysis(setOf(p1, p2))
        val analysis2 = Analysis(setOf(p3, p2))

        val (only1, only2, common) = partition(analysis1, analysis2)
        assertEquals(Analysis(setOf(p1)), only1)
        assertEquals(Analysis(setOf(p3)), only2)
        assertEquals(Analysis(setOf(p2)), common)
    }
}