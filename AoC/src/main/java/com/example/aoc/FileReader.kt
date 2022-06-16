package com.example.aoc

import java.io.File
import java.io.InputStream

class FileReader(private val fileName: String) {

    fun readFile(): List<String> {
        // crying emojis for not using relative path :'((((((
        val path = "/Users/renske/AndroidStudioProjects/AdventOfKode/AoC/src/main/java/com/example/aoc/day${fileName.last()}/${fileName}.txt"
        val inputStream: InputStream = File(path).inputStream()
        val lineList = mutableListOf<String>()

        inputStream.bufferedReader().forEachLine { lineList.add(it) }
        return lineList
    }
}