package org.example.utils

import java.io.File

fun readFile(file: String): List<String> {
    val filePath = "src/main/resources/$file"
    val lines = File(filePath).readLines()
    return lines
}