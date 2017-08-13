package medium.nugroho

import vlfsoft.common.annotations.design.patterns.CreationalPattern

@CreationalPattern.Singleton
public class Singleton private constructor() {
    init { println("This ($this) is a singleton") }

    private object Holder { val INSTANCE = Singleton() }

    companion object {
        val instance: Singleton by lazy { Holder.INSTANCE }
    }
    var b:String? = null
}

fun main(args: Array<String>) {
    var first = Singleton.instance  // This (Singleton@7daf6ecc) is a
    // singleton
    first.b = "hello singleton"

    var second = Singleton.instance
    println(second.b)        // hello singleton
}