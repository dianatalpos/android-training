package com.example.homework1

data class Rectangle(val x: Int, val y: Int, val w: Int, val h: Int)

class Paint {
    var color: Long = 0x00FF00
    var strokeWidth: Int = 5
    fun drawRectangle(rect: Rectangle) {
        println("Drawing $rect color: $color stroke: $strokeWidth")
    }
}

fun render1(paint: Paint?, rectangles: List<Rectangle?>) {
    paint?.apply {
        color = 0xFF0000
        rectangles.filterNotNull()
            .forEach {this.drawRectangle(it)}
    }
}


fun Paint.drawRectangles(rectangles : List<Rectangle?>) {
    rectangles.filterNotNull()
        .forEach {this.drawRectangle(it)}
}

fun render2(paint: Paint?, rectangles: List<Rectangle?>) {
    paint?.let {
        it.color = 0xFF0000;
        it.drawRectangles(rectangles)
    }
}

