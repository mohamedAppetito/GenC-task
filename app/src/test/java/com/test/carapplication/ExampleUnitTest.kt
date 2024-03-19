package com.test.carapplication

import junit.framework.TestCase
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    private fun multiTwoNumbers(a: Int , b: Int): Int {
        var result: Int = 0
        for (i in 0 until a) {
            result += b
        }
        return result
    }
    @Test
    fun testMultiPlyTwoNumbersWithout() {
        val result=multiTwoNumbers(2,-4)
        assertEquals(-8, result)
    }
}