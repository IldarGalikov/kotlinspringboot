package org.ildar

import assertk.assert
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import org.ildar.components.Dummy
import org.junit.Before
import org.junit.Test

class HelloTest {

    var classUnderTest = Dummy("")

    @Before
    fun setup() {
        classUnderTest = Dummy("")
    }

    @Test
    fun sampleTest() {
        assert(false).isFalse()
    }


    @Test
    fun whenICallGetHello() {
        classUnderTest = Dummy("world")
        classUnderTest.getHello()
        assert(classUnderTest.getHello())
                .isEqualTo("Hello world")


    }

}
