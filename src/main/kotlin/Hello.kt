import kotlinx.atomicfu.*

class A {
    val a = atomic("dnvjdnv")
}

fun foo() {
    val aClass = A()
    println(aClass.a.value)
}

fun main() {
    foo()
}
