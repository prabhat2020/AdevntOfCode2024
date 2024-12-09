package org.prabhat2020.day1

class Day3 {
    fun processDataDay3() {
        val getLines = readInputData("Day3")

        val pattern = Regex("mul\\((\\d+),(\\d+)\\)")
        val pattern2 =
            Regex("(?<!don't\\(\\))(?<=^|do\\(\\))mul\\((\\d+),(\\d+)\\)|(?<=do\\(\\).*don't\\(\\).*do\\(\\))mul\\((\\d+),(\\d+)\\)")
        val mulRegex = """mul\((\d{1,3}),(\d{1,3})\)"""
        val doRegex = """do\(\)"""
        val dontRegex = """don't\(\)"""
        val pattern2Regex = """$mulRegex|$doRegex|$dontRegex""".toRegex()

        var totalSum = 0L
        var totalSum2 = 0L
        for (line in getLines) {
            val matches = pattern.findAll(line)
            for (match in matches) {
                val (num1, num2) = match.destructured
                totalSum += num1.toLong() * num2.toLong()
            }

//            for (match in matches2) {
//                val (num1, num2) = match.destructured
//                totalSum2 += num1.toLong() * num2.toLong()
//            }
        }
//jet brains solution:
        val regex2 = """mul\(\d{1,3},\d{1,3}\)|do(n't)?\(\)""".toRegex()
        val all = getLines.flatMap { string -> regex2.findAll(string).map { it.value } }

        var enabled = true
        for (line in all) {
            when {
                line == "do()" -> enabled = true
                line == "don't()" -> enabled = false
                enabled && line.startsWith("mul(") -> {
                    val (a, b) = line.removeSurrounding("mul(", ")").split(",")
                    totalSum2 += a.toLong() * b.toLong()
                }
            }
        }
        println("Day3 Solution1: $totalSum")
        println("Day3 Solution2: $totalSum2")
    }

    fun MatchResult.multiplyNumbers(): Long {
        val (first, second) = destructured
        return first.toLong() * second.toLong()
    }

    //File("input.txt").readText().trim() reads the whole file
}