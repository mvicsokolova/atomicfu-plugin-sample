package pack1

import java.util.concurrent.atomic.*
import kotlinx.atomicfu.*

internal var internalInt = 587986

internal class AAA {
    @Volatile
    private var a = 56

    @Volatile
    private var internalA = 56

    companion object {
        private val atomicUpdater = AtomicIntegerFieldUpdater.newUpdater(AAA::class.java, "a")

        internal val internalUpdater = AtomicIntegerFieldUpdater.newUpdater(AAA::class.java, "a")
    }

    fun privateValUpdate(): Int {
        atomicUpdater.compareAndSet(this, 56, 34)
        return a
    }
}

internal val volatileWrapper = VolatileWrapper()

internal class VolatileWrapper {
    @Volatile private var wrappedTopLevelVar = 777

    companion object {
        internal val internalVolatileWrapperUpdater = AtomicIntegerFieldUpdater.newUpdater(VolatileWrapper::class.java, "wrappedTopLevelVar")
    }
}

@Volatile var b = 78

fun main() {
    val aaa = AAA()
    println(aaa.privateValUpdate())
}
