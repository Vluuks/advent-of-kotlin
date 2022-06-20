package com.example.aoc.day4

import com.example.aoc.FileReader

import java.math.BigInteger
import java.security.MessageDigest
import kotlin.reflect.typeOf

fun main() {
    part1()
    part2()
}

// https://stackoverflow.com/questions/64171624/how-to-generate-an-md5-hash-in-kotlin
fun md5(input: String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}

fun part1() {
    val lines: List<String> = FileReader("input4").readFile()
    val key = lines[0]

    var keySuffix = 1
    while(true) {
        val hashed = md5("${key}${keySuffix}")

        // check if start matches
        if(hashed.slice(0..4) == "00000") {
            println(keySuffix)
            break
        }

        keySuffix++
    }
}

fun part2() {
    val lines: List<String> = FileReader("input4").readFile()
    val key = lines[0]

    var keySuffix = 1
    while(true) {
        val hashed = md5("${key}${keySuffix}")

        // check if start matches
        if(hashed.slice(0..5) == "000000") {
            println(keySuffix)
            break
        }

        keySuffix++
    }
}