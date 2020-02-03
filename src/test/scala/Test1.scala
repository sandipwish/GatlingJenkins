import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Test1 extends Simulation {
  //Http Conf
  val httpConf = http.baseUrl("http://localhost:8080/app/")
    .header(name = "Accept", value="application/json")

  //Scenario Definition

  val scn = scenario(scenarioName = "Test1")
    .exec(http(requestName = "Get All Games")
    .get("videogames"))

  //Load Scenario
  setUp(
    scn.inject(atOnceUsers(users = 1))
  ).protocols(httpConf)

}
