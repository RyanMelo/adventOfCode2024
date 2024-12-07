package org.example

import java.io.File

fun main() {
    val lines = readFile("input.txt")

    day1(lines)
}

fun day1(lines: List<String>) {
    val fistList: MutableList<String> = mutableListOf();
    val secondList: MutableList<String> = mutableListOf();

    val resultDifs: MutableList<Int> = mutableListOf();

    lines.map { it.split("   ") }.map { line ->
        line.mapIndexed { index, value ->
            if (index == 0) {
                fistList.add(value)
            }

            if (index == 1) {
                secondList.add(value)
            }
        }
    }

    fistList.sort()
    secondList.sort()

    var diff = 0
    for (i in fistList.indices) {
        diff = fistList[i].toInt() - secondList[i].toInt()
        if (diff < 0) {
            diff *= -1
        }
        resultDifs.add(diff)
    }

    var result = resultDifs.sum()

    println(fistList)
    println(secondList)
    println(resultDifs)
    println("Resultado da soma: $result")
}

fun readFile(file: String): List<String> {
    val filePath = "src/main/resources/$file"
    val lines = File(filePath).readLines();
    return lines
}