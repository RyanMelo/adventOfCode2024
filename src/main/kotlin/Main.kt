package org.example

import java.io.File

fun main() {
    val lines = readFile("input.txt")

    day1(lines)
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

    println(fistList)
    println(secondList)
    println(resultDifs)
    println("Resultado da soma: $result")
}

fun readFile(file: String): List<String> {
    val filePath = "src/main/resources/$file"
    val lines = File(filePath).readLines()
    return lines
}