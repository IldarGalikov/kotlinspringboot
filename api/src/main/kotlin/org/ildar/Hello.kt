package org.ildar

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@SpringBootApplication
class SpringKotlinHelloWorldApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringKotlinHelloWorldApplication::class.java, *args)
    println("#########################        Hello, world!             #########################")
}

@RestController
@RequestMapping("/hello")
class HelloKotlinController(@Autowired val helloRespository: HelloRespository
) {
    @RequestMapping(method = [(RequestMethod.GET)])
    @ResponseBody
    fun getHello() = helloRespository.findAll()

    @RequestMapping(method = [(RequestMethod.POST)])
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    fun createWorld(@RequestBody request: HelloResponse) = helloRespository.saveAndFlush(request);

}

@Entity
data class HelloResponse(
        var username: String,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0
)

interface HelloRespository : JpaRepository<HelloResponse, Long>


