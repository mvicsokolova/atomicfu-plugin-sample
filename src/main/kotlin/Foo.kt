import kotlinx.atomicfu.*
import pack1.*

class Foo {
    private val a = atomic(0)

    fun foo() {
        a.inlineFoo(23)
        check(a.value == 5)
    }
}
