package medium.nugroho

class MyClass {
    companion object Factory {
        val info = "This is factory"
        fun getMoreInfo():String { return "This is factory fun" }
    }
}

fun main(args: Array<String>) {
    MyClass.info             // This is factory
    MyClass.getMoreInfo()    // This is factory fun
}
