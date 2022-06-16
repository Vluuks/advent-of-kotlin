package com.example.aoc.day1

import com.example.aoc.FileReader

fun main() {
    part1()
    part2()
}

fun part1() {
    val lines: List<String> = FileReader("input1").readFile()

    var floor = 0
    for (c in lines[0]) {
        if (c == '(') floor += 1
        else if (c == ')') floor -= 1
    }

    println(floor)
}

fun part2() {
    val lines: List<String> = FileReader("input1").readFile()
    val characters = lines[0].toList()

    var floor = 0
    for (i in characters.indices) {
        if (characters[i] == '(') {
            floor += 1
        }
        else if (characters[i] == ')') {
            floor -= 1

            if (floor == -1) {
                println(i+1)
                break
            }
        }
    }
}