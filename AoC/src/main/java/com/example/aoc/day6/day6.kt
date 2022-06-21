package com.example.aoc.day6

import com.example.aoc.FileReader

fun main() {
    part1()
}

class Grid(private val rowCount: Int, private val columnCount: Int) {
    var grid: ArrayList<ArrayList<Int>> = ArrayList(rowCount)

    fun initGrid(): ArrayList<ArrayList<Int>> {
        for(i in 0 until rowCount) {
            val newList = ArrayList<Int>(1000)

            for(j in 0 until columnCount) {
                newList.add(0)
            }
            grid.add(newList)
        }
        return grid
    }

    private fun alterLightState(command: String, row: Int, column: Int) {
        when(command){
            "on" -> grid[row][column] = 1
            "off" -> grid[row][column] = 0
            "toggle" -> grid[row][column] = kotlin.math.abs(grid[row][column] - 1)
        }
    }

    fun traverseGrid(topLeft: Pair<Int, Int>, bottomRight: Pair<Int, Int>, command: String) {
        for(i in topLeft.first..bottomRight.first) {
            println(i)
            for(j in topLeft.second..bottomRight.second) {
                println(j)
                alterLightState(command, i, j)
            }
        }
    }

    fun print() {
        for(row in grid){
            println(row)
        }
    }
}

fun part1() {
    val lines: List<String> = FileReader("input6").readFile()

    val grid = Grid(5, 5)
    grid.initGrid()


    // turn on 887,9 through 959,629
    for(line in lines) {
        val coordinates = Regex("(\\d+),(\\d+)").findAll(line).toList()
        val topLeft = coordinates[0].groups[1]!!.value.toInt() to coordinates[0].groups[2]!!.value.toInt()
        val bottomRight = coordinates[1].groups[1]!!.value.toInt() to coordinates[0].groups[2]!!.value.toInt()

        grid.traverseGrid(topLeft, bottomRight, "on")
        break
    }

    grid.print()
}