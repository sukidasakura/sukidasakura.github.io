package com.paris.dream.scalademo

object whileLoop {

	def whileLoop(): Unit ={
		var i =1
		while (i <= 3){
			println(i)
			i += 1
		}
	}

	def main(args: Array[String]): Unit = {
		whileLoop()
	}
}
