package lmller.github.io.gofkotlin.builder

class Car() {
    var color: String = "red"
    var doors = 3

    override fun toString() = "$color car with $doors doors"
}

/**
 * https://dev.to/lovis/gang-of-four-patterns-in-kotlin
 * http://beust.com/weblog/2015/10/30/exploring-the-kotlin-standard-library/
 */
fun main(args: Array<String>) {
    Car().apply {
        color = "yellow"
        doors = 5
    }.let { println(it) }
}