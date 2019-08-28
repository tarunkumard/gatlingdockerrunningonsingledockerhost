package baseConfig

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.filter.{ BlackList, Filters, WhiteList }

class BaseSimulation extends Simulation {


 val httpConf = http
  //  .baseURL("https://preview.contentful.com")
    //.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png"""), WhiteList())
    //.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36")

     /* .baseURL("https://webr20accounts.wizards.com")
      .disableFollowRedirect
      .disableAutoReferer
      .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36")*/
   // .header("Accept", "application/json")
  //  .proxy(Proxy("localhost", 8888).httpsPort(8888)) // uncomment this line if you want to run through a HTTP proxy such as Fiddler or Charles Proxy
  // val httpProtocol = http
    // .baseURL("http://r20services.onlinegaming.local:4059/Business/EventReporterV2?wsdl")
      //.baseURL("https://api.tabletop-stage.tiamat-origin.cloud")
     //.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png"""), WhiteList())


  /* val httpProtocol = http
       .baseURL("https://avalonhill.wizards.com/")
        .inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png"""), WhiteList())
        .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36")
        .hostNameAliases(Map("avalonhill.wizards.com" -> "54.149.250.224"))*/

  /*val httpProtocol = http*/
  /*  .baseURL("http://testwebserveralb-1773155928.us-west-2.elb.amazonaws.com")
    .inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png"""), WhiteList())
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36")*/
  //.hostNameAliases(Map("http://testwebserverclb-24790314.us-west-2.elb.amazonaws.com" -> "52.34.215.31"))

  /*val httpProtocol = http
    .baseURL("https://dev.company.wizards.com")
    .inferHtmlResources(BlackList(Seq("https://dev.company.wizards.com/.*")), WhiteList())
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36")*/

 /* val httpProtocol = http
    .baseURL("https://wpn.wizards.com")
    .disableFollowRedirect
    .disableAutoReferer
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36")*/
/*
  val httpProtocol = http
    .baseURL("https://dev.magic.wizards.com")
    .disableFollowRedirect
    .disableAutoReferer
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36")*/


  /* val httpProtocol = http
     .baseURL("https://wpn.wizards.com")
     .inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png"""), WhiteList())
     .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36")*/

  val httpProtocol = http
    .baseURL("https://webr20accounts.wizards.com")
    .disableFollowRedirect
    .disableAutoReferer
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36")



}
