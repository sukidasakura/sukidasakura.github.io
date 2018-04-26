package com.paris.dream.classdefine

// 类默认是public级别的
class Person(firstname : String, lastname : String, spou : Person ) {
	val lastName = lastname; // 没有private修饰符，则认为是public
	val firstName = firstname; // 从构造函数的参数类型，推断firstName 为String 类型。
	val spouse = spou; // 从构造函数推断为参数类型为Person

	def this(fn : String, ln : String) = {
		this(fn, ln, null)
	}

	def introduction() : String =
		return "我的名字是，" + lastName + " " + firstName +
				(if (spouse != null) "，他的名字是" + spouse.lastName + spouse.firstName + "。" else "。")
}

class Person02(var firstName : String, val lastName : String, var spouse : Person){
	def this(fn: String, ln: String) = this(fn, ln, null)
	def introduction() : String = "我的名字是，" + lastName + " " + firstName +
			(if(spouse != null) "，他的名字是，" + spouse.lastName + spouse.firstName + "。 " else "。")

}


object Person{
	def main(args: Array[String]): Unit = {
		val steveLi = new Person("Fei", "Zhang")
		println(steveLi lastName)
		val steveZ = new Person02("YuFan", "Zhang")
		steveZ.firstName = "right name";
		println(steveZ.firstName)
	}
}