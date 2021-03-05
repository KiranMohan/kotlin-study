package org.ktest.study.kotlin.coroutines

import kotlinx.coroutines.*
import java.time.Duration
import java.time.Instant


fun main() {
    val startTime = Instant.now()

    /*
    val c = AtomicLong()
    runBlocking {
        for (i in 1..1_000_000L)
            launch {
                c.addAndGet(i)
                delay(1000L)
            }
    }
    println(c.get())
    */

    var sum: Long = 0;
    runBlocking {
        var deferred: List<Deferred<Long>> = (1..1_000_000L).map {
            async { workload(it) }
        }
        sum = deferred.sumOf { it.await().toLong() }
    }
    println("sum : $sum")

    val endTime = Instant.now()
    val duration = Duration.between(startTime, endTime)
    println("time taken: ${duration.toMillis()}")
}

private suspend fun workload(n: Long): Long {
    delay(1000L)
    return n
}