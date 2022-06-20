package com.example.aoc.day3

import com.example.aoc.FileReader

fun main() {
//    part1()
    part2()
}

fun part1() {
    val lines: List<String> = FileReader("input3").readFile()
    val characters = lines[0].toList()

    val map = HashMap<String, Int>()

    var row = 0
    var col = 0

    map["0-0"] = 1

    for(c in characters) {

        // move
        when(c) {
            '^' -> row -= 1
            'v' -> row += 1
            '>' -> col += 1
            '<' -> col -= 1
        }

        // add present
        val key = "${row}-${col}"

        if(!map.containsKey(key)){
            map[key] = 1
        }
        else {
            map[key]!!.plus(1)
        }

    }

    var gotAtLeastOneGift = 0
    for((k, v) in map) {
        if(v > 0) {
            gotAtLeastOneGift++
        }
    }
    println(gotAtLeastOneGift)
}

fun part2() {
    val lines: List<String> = FileReader("input3").readFile()
    val characters = lines[0].toList()

    val map = HashMap<String, Int>()

    var rowSanta = 0
    var colSanta = 0

    var rowRobo = 0
    var colRobo = 0

    // they both start at 0,0
    map["0-0"] = 2

    // why no regular for -.- i hate it when languages do that
    for(i in characters.indices) {
        var key = ""

        // alternate turns for santa and robo santa
        if(i % 2 == 0) {
            val (row, col) = getMoveIndices(characters[i], rowSanta, colSanta)

            rowSanta = row
            colSanta = col

            key = "${row}-${col}"

        }
        else {
            val (row, col) = getMoveIndices(characters[i], rowRobo, colRobo)

            rowRobo = row
            colRobo = col

            key = "${row}-${col}"
        }

        // keep present count
        if (!map.containsKey(key)) {
            map[key] = 1
        } else {
            map[key]!!.plus(1)
        }
    }

    var gotAtLeastOneGift = 0
    for((k, v) in map) {
        if(v > 0) {
            gotAtLeastOneGift++
        }
    }
    println(gotAtLeastOneGift)
}

// why are params final that's kinda annoying
fun getMoveIndices(character: Char, row: Int, col: Int): Pair<Int, Int> {
    var rowMutable = row
    var colMutable = col

    when (character) {
        '^' -> rowMutable -= 1
        'v' -> rowMutable += 1
        '>' -> colMutable += 1
        '<' -> colMutable -= 1
    }

    return rowMutable to colMutable
}