package Priya
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration.DurationInt


class AddPauseTime extends Simulation {

val httpConf= http.baseUrl(url = "http://localhost:8080/app/")
  .header(name = "Accept", value = "application/json")
  .proxy(Proxy("localhost", 8888 ))

val scn= scenario(scenarioName = "Add Pause Time")
  .exec(http(requestName = "get vedio game")
    .get("videogames"))
  .pause(5)

  .exec(http(requestName = "Get Game By ID")
  .get("videogames/1"))
  .pause(1 , 20)

  .exec(http(requestName = "get vedio game")
    .get("videogames"))
  .pause(3000.milliseconds)

  setUp(

    scn.inject(atOnceUsers(1))
      .protocols(httpConf)
  )




}
