package simulations

import baseConfig.BaseSimulation
import com.jayway.jsonpath.JsonPath
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration.DurationInt
import scala.io.Source
import scala.language.postfixOps


class EventReservationFilters extends BaseSimulation {



  val usersDataSource=jsonFile("/opt/src/gatling/resources/data/input-gamekeeper.json").circular
  val nameDataSource=jsonFile("/opt/src/gatling/resources/data/input-gamekeeper-StringBody.json").random
  var idNumbers=(1000020 to 1000030).iterator





  private def getProperty(propertyName: String, defaultValue: String) = {
    Option(System.getenv(propertyName))
      .orElse(Option(System.getProperty(propertyName)))
      .getOrElse(defaultValue)
  }
  // now specify the properties
  //def userCount: Int = getProperty("USERS", "100").toInt

  val source: String = Source.fromFile("/opt/src/gatling/resources/data/input-gamekeeper.json").getLines.mkString
  def userCount: Int  = JsonPath.parse(source).read("$.[0].user")
  def testDuration: Int  = JsonPath.parse(source).read("$.[0].testDuration")
  def rampDuration: Int  = JsonPath.parse(source).read("$.[0].rampDuration")


  // print out the properties at the start of the test
  before {
    println(s"Running test with ${userCount} users")
    println(s"Ramping users over ${rampDuration} seconds")
    println(s"Total Test duration: ${testDuration} seconds")
  }

  def getNextOrgId()=
  {

    if(!idNumbers.hasNext)
      idNumbers=(1000020 to 1000030).iterator
    Map("orgId"->idNumbers.next())
  }



  val customFeeder=Iterator.continually(getNextOrgId())


  def DungeonsAndDragonsAssertion()={


    exec(http("Dungeons And Dragons Name Filter Assertion")
      .get("https://api.tabletop-stage.tiamat-origin.cloud/perf-test-autoscale/event-reservations-service/events/filter/")

      .check(status.in(200, 201,302))
      .check(jsonPath(path="$..filters[:2].name").in("dungeons_&_dragons")))
      .exec{session=>println(session);session}
      .pause(1)


  }

  def MagicweekendAssertion()={


    exec(http("Magic Weekend Filter Assertion")
      .get("https://api.tabletop-stage.tiamat-origin.cloud/perf-test-autoscale/event-reservations-service/events/filter/")

      .check(status.in(200, 201,302))
      .check(jsonPath(path="$..filters[8].name").in( "magic_weekend")))
      .exec{session=>println(session);session}
      .pause(1)


  }

  def MagicTheGatheringAssertion()={


    exec(http("Magic The Gathering Filter Assertion")
      .get("https://api.tabletop-stage.tiamat-origin.cloud/perf-test-autoscale/event-reservations-service/events/filter/")

      .check(status.in(200, 201,302))
      .check(jsonPath(path="$..filters[1].name").in("magic:_the_gathering")))
      .exec{session=>println(session);session}
      .pause(1)


  }


  def MagicstandardshowdownAssertion()={


    exec(http("Magic Standard Showdown Filter Assertion")
      .get("https://api.tabletop-stage.tiamat-origin.cloud/perf-test-autoscale/event-reservations-service/events/filter/")

      .check(status.in(200, 201,302))
      .check(jsonPath(path="$..filters[7].name").in("magic_standard_showdown")))
      .exec{session=>println(session);session}
      .pause(1)


  }

  def MagicprereleaseAssertion()={


    exec(http("Magic Pre Release  Filter Assertion")
      .get("https://api.tabletop-stage.tiamat-origin.cloud/perf-test-autoscale/event-reservations-service/events/filter/")

      .check(status.in(200, 201,302))
      .check(jsonPath(path="$..filters[6].name").in("magic_prerelease")))
      .exec{session=>println(session);session}
      .pause(1)


  }


  // add a scenario



  val scenario1 = scenario("Dungeons And Dragons Name Filter Assertion ")

    .forever() { // add in the forever() method - users now loop forever

      exec(DungeonsAndDragonsAssertion())
    }

  val scenario2 = scenario("Magic Weekend Filter Assertion ")

    .forever() { // add in the forever() method - users now loop forever
      exec(MagicweekendAssertion())
    }

  val scenario3 = scenario("Magic The Gathering Filter Assertion ")

    .forever() { // add in the forever() method - users now loop forever
      exec(MagicTheGatheringAssertion())
    }

  val scenario4 = scenario("Magic Standard Showdown Filter Assertion ")

    .forever() { // add in the forever() method - users now loop forever
      exec(MagicstandardshowdownAssertion())
    }
  val scenario5 = scenario("Magic Pre Release  Filter Assertion")

    .forever() { // add in the forever() method - users now loop forever
      exec(MagicprereleaseAssertion())
    }


  // setup the load profile
  // example command line: ./gradlew gatlingRun-simulations.RuntimeParameters -DUSERS=10 -DRAMP_DURATION=5 -DDURATION=30
  setUp(

    scenario1.inject(
      nothingFor(5 seconds),
      rampUsers(userCount) over ( rampDuration ))
      .protocols(httpConf),
   scenario2.inject(
    nothingFor(5 seconds),
    rampUsers(userCount) over ( rampDuration ))
    .protocols(httpConf),
    scenario3.inject(
      nothingFor(5 seconds),
      rampUsers(userCount) over ( rampDuration ))
      .protocols(httpConf),
    scenario4.inject(
      nothingFor(5 seconds),
      rampUsers(userCount) over ( rampDuration ))
      .protocols(httpConf),
    scenario5.inject(
      nothingFor(5 seconds),
      rampUsers(userCount) over ( rampDuration ))
      .protocols(httpConf))


    .maxDuration(testDuration)
}

