package lmller.github.io.gofkotlin.decorator

interface Text {
    fun draw()
}

class DefaultText(val text: String) : Text {
    override fun draw() {
        print(text)
    }
}

fun Text.underline(decorated: Text.() -> Unit) {
    print("_")
    this.decorated()
    print("_")
}

fun Text.background(decorated: Text.() -> Unit) {
    print("\u001B[43m")
    this.decorated()
    print("\u001B[0m")
}


fun preDecorated(decorated: Text.() -> Unit): Text.() -> Unit {
    return {
        background {
            underline {
                decorated()
            }
        }
    }
}

fun preDecorated2(decorated: Text.() -> Unit): Text.() -> Unit {
    return {
        underline {
            decorated()
        }
    }
}

/**
 * https://dev.to/lovis/gang-of-four-patterns-in-kotlin
 * http://beust.com/weblog/2015/10/30/exploring-the-kotlin-standard-library/
 */
fun main(args: Array<String>) {
    DefaultText("Hello").run(preDecorated { draw() })
    DefaultText("World").run(preDecorated2 { draw() })
}

