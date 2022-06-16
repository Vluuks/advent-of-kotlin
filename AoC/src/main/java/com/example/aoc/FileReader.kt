package com.example.aoc

import java.io.File
import java.io.InputStream
import java.nio.file.Paths

class FileReader(private val fileName: String) {

    fun readFile(): List<String> {
        val path = "/Users/renske/AndroidStudioProjects/AdventOfKode/AoC/src/main/java/com/example/aoc/day${fileName.last()}/${fileName}.txt"
        val inputStream: InputStream = File(path).inputStream()
        val lineList = mutableListOf<String>()

        inputStream.bufferedReader().forEachLine { lineList.add(it) }
        lineList.forEach{println(">  " + it)}

        return lineList
    }
}

fun main() {




}