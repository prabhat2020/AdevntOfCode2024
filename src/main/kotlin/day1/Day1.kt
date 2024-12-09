package org.prabhat2020.day1

import kotlin.io.path.Path
import kotlin.io.path.readLines
import kotlin.math.abs

/* updated after jetbrains solution */
class Day1 {

    private fun getTestData() = Path("/Users/dk36ry/Developer/AOC/AdevntOfCode/src/main/resources/day1.txt").readLines()

    fun processDataDay1() {

        val getInputData = getTestData()


        val (left, right) = getInputData.map { line ->
            val first = line.substringBefore(" ").toInt()
            val second = line.substringAfterLast(" ").toInt()
            first to second
        }.unzip()

        val result = left.sorted().zip(right.sorted()).sumOf { (first, second) ->
            abs(first - second)
        }

        //   println(result)

        val getLeftSideData = getInputData.map { line ->
            line.substringBefore(" ").toLong()
        }
        val getRightSideData = getInputData.map { line ->
            line.substringAfterLast(" ").toLong()
        }

        val rihtSideFrequency = getRightSideData.groupingBy { it }.eachCount()
        getLeftSideData.fold(0) { acc: Long, i: Long ->
            acc + i * rihtSideFrequency.getOrDefault(i, 0)
        }
        //    .also(::println)
    }
}