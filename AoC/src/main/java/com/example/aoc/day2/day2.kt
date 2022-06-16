package com.example.aoc.day2

import com.example.aoc.FileReader
import kotlin.reflect.typeOf

fun main() {
    part1()
    part2()
}

fun getNeededRibbon(lstr: String, wstr: String, hstr: String): Int {
    // this is kinda ehhhh
    val l = lstr.toInt()
    val w = wstr.toInt()
    val h = hstr.toInt()

    // get 2 smallest
    val dimensions = listOf(l, w, h).sorted()
    val wrapAround = dimensions[0] * 2 + dimensions[1] * 2
    val bow = l * w * h

    return wrapAround + bow
}

fun getNeededPaper(lstr: String, wstr: String, hstr: String): Int {
    // this is kinda ehhhh
    val l = lstr.toInt()
    val w = wstr.toInt()
    val h = hstr.toInt()

    val side1 = l * w
    val side2 = w * h
    val side3 = h * l

    val surfaceArea = 2*side1 + 2*side2 + 2*side3
    val margin = listOf<Int>(side1, side2, side3).min()

    return surfaceArea + margin
}

fun part1() {
    val lines: List<String> = FileReader("input2").readFile()

    var totalPaper = 0
    for(l in lines) {
        val dimensions = l.split('x')

        // no spread operator?? #sadlife
        totalPaper += getNeededPaper(dimensions[0], dimensions[1], dimensions[2])
    }

    println(totalPaper)
}

fun part2() {
    val lines: List<String> = FileReader("input2").readFile()

    var totalRibbon = 0
    for(l in lines) {
        val dimensions = l.split('x')

        // no spread operator?? #sadlife
        totalRibbon += getNeededRibbon(dimensions[0], dimensions[1], dimensions[2])
    }

    println(totalRibbon)
}

