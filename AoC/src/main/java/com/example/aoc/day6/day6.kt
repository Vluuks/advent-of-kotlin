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

    fun alterLightState(command: String, row: Int, column: Int) {
        when(command){
            "on" -> grid[row][column] = 1
            "off" -> grid[row][column] = 0
            "toggle" -> grid[row][column] = kotlin.math.abs(grid[row][column] - 1)
        }
    }
}



fun part1() {
    val lines: List<String> = FileReader("input6").readFile()

    val grid = Grid(1000, 1000).initGrid()

    for(line in lines) {
        // todo
    }
}