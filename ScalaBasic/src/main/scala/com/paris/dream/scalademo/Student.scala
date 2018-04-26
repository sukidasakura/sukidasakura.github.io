package com.paris.dream.scalademo

/**
  * 伴生类和伴生对象
  * class Student 是伴生对象object Student 的伴生类
  * object Student 是伴生类class Student 的伴生对象
  */
class Student(var name: String, var address: String) {
	private var phone = "110";

	def infoCompObj() = println("伴生类中访问伴生对象：" + Student.sno)
}

object Student{
	private var sno: Int = 10;
	def incremenSno() = {
		sno += 1
		sno
	}
}
