package lmller.github.io.gofkotlin.iterator

class Sentence(val words: List<String>)
class OtherSentence(private val words: List<String>): Collection<String> by words

// operator fun Sentence.iterator(): Iterator<String> = words.iterator()
operator fun Sentence.iterator() = words.iterator()

fun main(args: Array<String>) {
    val words = "This is not the greatest example in the world"
            .split(" ")
            .toList()

    val words2 = "This is just a tribute"
            .split(" ")
            .toList()

    for(word in Sentence(words)){
        print("$word ")
    }
    println()

    val otherSentence = OtherSentence(words2)
    otherSentence.forEach { word ->
        print("$word ")
    }

    println(otherSentence.contains("tribute"))

}