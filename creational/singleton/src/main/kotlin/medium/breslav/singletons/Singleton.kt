package medium.breslav.singletons

import vlfsoft.common.annotations.design.patterns.CreationalPattern

@CreationalPattern.Singleton
object Singleton {
    var b: String? = null
}

fun main(args: Array<String>) {
    Singleton.b = "foo" // class is initialized at this point
    println(Singleton.b) // prints "foo"
}
