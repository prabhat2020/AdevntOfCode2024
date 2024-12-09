package org.prabhat2020.day1

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun readInputData(path: String) =
    Path("/Users/dk36ry/Developer/AOC/AdevntOfCode/src/main/resources/$path.txt").readLines()
