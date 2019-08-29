
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class geteventreservationsautoscale extends Simulation {


val httpProtocol = http

  
  

  def getSpecificEventID()={
    repeat(96000){
      
      
        exec(http("Get Specific Search Event")
          .get("https://api.tabletop-stage.tiamat-origin.cloud/perf-test-autoscale/event-reservations-service/events/"+"21")


          .check(status.is(200)))
        .exec{session=>println(session);session}
        .pause(1)


    }
  }



  // add a scenario
  val scn  = scenario("Get Specific Search Event")
    .forever() { // add in the forever() method - users now loop forever

      exec(getSpecificEventID())
    }

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}