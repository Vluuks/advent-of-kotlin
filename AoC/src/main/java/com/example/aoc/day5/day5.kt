package com.example.aoc.day5

import com.example.aoc.FileReader

fun main() {
    part1()
}

fun part1() {
    val lines: List<String> = FileReader("input5").readFile()

    var niceStrings = 0
    for(string in lines) {
        // first throw out the hard 'no's
        if(string.contains(Regex("ab|cd|pq|xy"))) {
            continue
        }

        // at least 3 vowels otherwise bye
        if(Regex("[aeiou]").findAll(string).count() < 3) {
            continue
        }

        // last check, repeating characters
        for(c in 'a'..'z'){
            if(string.contains(Regex("${c}{2}"))) {
                niceStrings++
                break
            }
        }
    }

    println(niceStrings)
}