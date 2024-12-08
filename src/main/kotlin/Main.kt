package org.example

import java.io.File

fun main() {
    day1(readFile("input_day1.txt"))
}


fun day1(lines: List<String>) {
    val fistList: MutableList<Int> = mutableListOf()
    val secondList: MutableList<Int> = mutableListOf()

    val resultDifs: MutableList<Int> = mutableListOf()

    lines.map { it.split("   ") }.map { line ->
        line.mapIndexed { index, value ->
            if (index == 0) {
                fistList.add(value.toInt())
            }

            if (index == 1) {
                secondList.add(value.toInt())
            }
        }
    }

    fistList.sort()
    secondList.sort()

    var diff: Int
    for (i in fistList.indices) {
        diff = fistList[i] - secondList[i]
        if (diff < 0) {
            diff *= -1
        }
        resultDifs.add(diff)
    }

    val result = resultDifs.sum()

    println("Resultado da soma: $result")

//    Part 2

    val similarutyList: MutableList<Int> = mutableListOf()

    var rep = 0
    for (i in fistList.indices) {
        for (j in secondList.indices) {
            if (fistList[i] == secondList[j]) {
                rep += 1
            }
        }
        similarutyList.add(fistList[i] * rep)
        rep = 0
    }

    println("Similaridade: ${similarutyList.sum()}")
}

fun readFile(file: String): List<String> {
    val filePath = "src/main/resources/$file"
    val lines = File(filePath).readLines()
    return lines
}