@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import lesson3.task1.digitNumber
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double = TODO()


/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */


fun mean(list: List<Double>): Double {
    return if (list.isNotEmpty()) {
        (list.sum() / list.size)
    } else
        0.0
}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    if (list.isNotEmpty()) {
        val sr = list.sum() / list.size
        for (i in 0 until list.size) {
            list[i] = list[i] - sr
        }
    }
    return list
}


/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int = TODO()


/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int = TODO() //Int {
//    if (p.isNotEmpty()) {
//        var result = p[0]
//        for (i in 1 until p.size) {
//            result += p[i] * ((x.toDouble()).pow(i.toDouble())).toInt()
//            if (i == p.size) {
//               return  result}
//            else result += 0
//        }
//    }
//    return result
//}


/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> {
    if (list.isNotEmpty()) {
        var sum = list.first()
        for (i in 1 until list.size) {
            sum += list[i]
            list[i] = sum
        }
    }
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    var i = 1
    var k = n
    val result = mutableListOf<Int>()
    while ((k > 0) && (i <= k)) {
        i += 1
        while (k % i == 0) {
            k /= i
            result.add(i)
        }
    }
    return result
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    val result = mutableListOf<Int>()
    var b = n
    while (b > 0) {
        result.add(0, b % base)
        b /= base
    }
    return result
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String = (convert(n, base).map { if (it > 9) it + 87 }).joinToString()
//    var result = mutableListOf<Int>()
//    val x: Int
//    var b = n
//    while (b > 0) {
//        result.add(0, b % base)
//        b /= base
//    }
//    result.joinToString()
//    when {
//        10 in result ->
//
//    }


//   }

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int = TODO()

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */

fun roman(n: Int): String = TODO()


/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    val a = n % 10
    val b = n / 10 % 10
    val c = n / 100 % 10
    val d = n / 1000 % 10
    val e = n / 10000 % 10
    val g = n / 100000 % 10

    var one: String = ("")
    var two: String = ("")
    var three: String = ("")
    var four: String = ("")
    var five: String = ("")
    var six: String = ("")
    val words = mutableListOf<String>(
        "один ",                // 0
        "два ",                 // 1
        "три ",                 // 2
        "четыре ",              // 3
        "пять ",                // 4
        "шесть ",               // 5
        "семь ",                // 6
        "восемь ",              // 7
        "девять ",              // 8
        "десять ",              // 9
        "одиннадцать ",         // 10
        "двенадцать ",          // 11
        "тринадцать ",          // 12
        "четырнадцать ",        // 13
        "пятнадцать ",          // 14
        "шестнадцать ",         // 15
        "семнадцать ",          // 16
        "восемнадцать ",        // 17
        "девятнадцать ",        // 18
        "двадцать ",            // 19
        "тридцать ",            // 20
        "сорок ",               // 21
        "пятьдесят ",           // 22
        "шестьдесят ",          // 23
        "семьдесят ",           // 24
        "восемьдесят ",         // 25
        "девяносто ",           // 26
        "сто ",                 // 27
        "двести ",              // 28
        "триста ",              // 29
        "четыреста ",           // 30
        "пятьсот ",             // 31
        "шестьсот ",            // 32
        "семьсот ",             // 33
        "восемьсот ",           // 34
        "девятьсот ",           // 35
        "одна тысяча ",         // 36
        "тысячи ",              // 37
        "тысяч ",               // 38
        "две "                  // 39
    )
    if ((digitNumber(n) >= 3)) {
        when (c) {
            0 -> three = ("")
            in 1..9 -> three = words[26 + c]
        }
    } else {
        three = ("")
    }

    when (a) {
        0 -> one = ("")
        in 1..9 -> one = words[a - 1]
    }
    when (b) {
        0 -> two = ("")
        1 -> {
            one = ("")
            two = words[9 + a]
         }
        in 2..9 -> two = words[17 + b]
    }
    if ((e == 0) && (digitNumber(n) >= 4)) {
        when (d) {
            0 -> four = ("")
            1 -> four = words[36]
            2 -> four = words[39] + words[37]
            3, 4 -> four = words[d - 1] + words[37]
            in 5..9 -> four = words[d - 1] + words[38]
        }
    } else if (digitNumber(n) >= 5) {
        when (e) {
            1 -> five = words[9 + d] + words[38]
            in 2..9 -> five = words[17 + e] + when (d) {
                0 -> words[38]
                1 -> words[36]
                2 -> words[39] + words[37]
                3, 4 -> words[d - 1] + words[37]
                in 5..9 -> words[d - 1] + words[38]
                else -> ""
            }
        }
    }
    six = if ((digitNumber(n) >= 6) && (e == 0) && (d == 0)) {
        words[26 + g] + words[38]
    } else if (digitNumber(n) >= 6) {
        words[26 + g]
    } else ("")
    return ("$six$five$four$three$two$one").trim()
}






















