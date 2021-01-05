class Department(var head: Person) {
}

class Person(var name:String, var department: Department?)

fun printDeptHead(person: Person?) {
    println(person?.department?.head?.name)
}

fun main() {
    var person = Person("Bob", null)
    printDeptHead(person)
}


