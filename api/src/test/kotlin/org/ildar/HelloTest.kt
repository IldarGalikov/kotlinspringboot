package org.ildar


import org.assertj.core.api.Assertions.assertThat
import org.ildar.components.Dummy
import org.junit.Before
import org.junit.Test

class HelloTest {

    private lateinit var classUnderTest: Dummy

    @Before
    fun setup() {
        classUnderTest = Dummy("")
    }

    @Test
    fun sampleTest() {
        assertThat(true).isTrue()
    }

    @Test
    fun whenICallGetHello() {
        classUnderTest = Dummy("world")
        classUnderTest.getHello()
        assertThat(classUnderTest.getHello())
                .isEqualTo("Hello world")
    }
}
