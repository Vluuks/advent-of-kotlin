package com.example.aoc.day5

import com.example.aoc.FileReader

fun main() {
    part1()
    part2()
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

fun part2() {
    val lines: List<String> = FileReader("input5").readFile()

    var niceStrings = 0

    for(string in lines) {

        // time to nest because I'm not good at regex!
        var hasTwoPairs = false
        loop@ for(c1 in 'a'..'z'){
            for(c2 in 'a'..'z'){
                // if we found a double occurrence of a pair, e.g. aa or ab twice
                if(Regex("(${c1}${c2})").findAll(string).count() == 2) {
                    hasTwoPairs = true
                    break@loop
                }
            }
        }

        // if first condition already failed, we can never succeed
        if(!hasTwoPairs) {
            continue
        }

        var hasTriple = false
        for(c in 'a'..'z'){
            if(Regex("(${c}[^${c}]${c})").findAll(string).count() > 0) {
                hasTriple = true
                break
            }
        }

        if(hasTwoPairs && hasTriple) {
            println(string)
            niceStrings++
        }
    }

    println(niceStrings)
}