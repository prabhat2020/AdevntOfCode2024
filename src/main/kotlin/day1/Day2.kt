package org.prabhat2020.day1

import kotlin.io.path.Path
import kotlin.io.path.readLines

class Day2 {

    private fun getTestData() = Path("/Users/dk36ry/Developer/AOC/AdevntOfCode/src/main/resources/day2.txt").readLines()

    fun processDataDay2(): Int {

        val inputData = getTestData()
        val convertEachRecord = inputData.map { line ->
            line.split(" ").map { it.toInt() }
        }
        var records = 0
        var recordsDampener = 0
        convertEachRecord.forEach {
            val checkSafety = isSafeLogic(it)
            if (checkSafety) records++

            val test = applyProblemDampener(it)
            recordsDampener += test
        }

        println(records)
        println(recordsDampener)
        return records
    }

    private fun isSafeLogic(records: List<Int>): Boolean {
        val checkDifference = records.zipWithNext { i, j -> i - j }
        return checkDifference.all { it in -3..3 } && (checkDifference.all { it > 0 } || checkDifference.all { it < 0 })
    }

    private fun applyProblemDampener(records: List<Int>): Int {
        var result2 = 0
        var safe = false
        for (i in 0..records.lastIndex) {
            safe = isSafeLogic(records.toMutableList().apply { removeAt(i) })
            if (safe) break
        }
        if (safe) result2++
        return result2
    }
}