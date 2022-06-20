package com.example.aoc.day3

import com.example.aoc.FileReader

class DeliveryPerson() {
    private var presentDeliveryMap: HashMap<String, Int> = HashMap()
    private var row: Int = 0
    private var column: Int = 0

    init {
        // deliver at starting location
        presentDeliveryMap["0,0"] = 1
    }

    fun move(character: Char) {
        when (character) {
            '^' -> row -= 1
            'v' -> row += 1
            '>' -> column += 1
            '<' -> column -= 1
        }

        addToMap(row, column)
    }

    private fun addToMap(currentRow: Int, currentColumn: Int) {
        val key = "${currentRow},${currentColumn}"

        // keep present count
        if (!presentDeliveryMap.containsKey(key)) {
            presentDeliveryMap[key] = 1
        } else {
            presentDeliveryMap[key]!!.plus(1)
        }
    }

    fun getMap(): Map<String, Int> {
        return this.presentDeliveryMap
    }
}

fun main() {
    part1()
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

    val santa = DeliveryPerson()
    val roboSanta = DeliveryPerson()


    // why no regular for -.- i hate it when languages do that
    for(i in characters.indices) {
        if(i % 2 == 0) {
            santa.move(characters[i])
        }
        else {
            roboSanta.move(characters[i])
        }
    }

    println((santa.getMap() + roboSanta.getMap()).values.sum())
}