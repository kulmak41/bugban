import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File
import java.io.IOException

fun partition(analysis1: Analysis, analysis2: Analysis): Array<Analysis> {
    val only1 = Analysis(analysis1.problems - analysis2.problems)
    val only2 = Analysis(analysis2.problems - analysis1.problems)
    val common = Analysis(analysis1.problems intersect analysis2.problems)
    return arrayOf(only1, only2, common)
}

fun main(args: Array<String>) {
    try {
        val (analysis1Path, analysis2Path, only1Path, only2Path, commonPath) = readln().split(" ")

        val mapper = jacksonObjectMapper()
        val analysis1 = mapper.readValue<Analysis>(File(analysis1Path))
        val analysis2 = mapper.readValue<Analysis>(File(analysis2Path))

        val (only1, only2, common) = partition(analysis1, analysis2)

        mapper.writeValue(File(only1Path), only1)
        mapper.writeValue(File(only2Path), only2)
        mapper.writeValue(File(commonPath), common)
    } catch (e: IOException) {
        println(e.message)
        return
    } catch (e: JsonMappingException) {
        println(e.message)
    }
}