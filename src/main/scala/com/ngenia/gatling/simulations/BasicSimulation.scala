package com.ngenia.gatling.simulations

import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BasicSimulation extends Simulation {

  // Load Simulation Config
  val config = ConfigFactory.load("simulations/BasicSimulation.conf")

  val scenarioName = config.getString("scenario.name")
  val baseUrl = config.getString("scenario.baseUrl")
  val vuserCount = config.getInt("scenario.vusers.count")

  val httpProtocol = http
    .baseUrl(baseUrl)

  val scn = scenario(scenarioName)
    .exec(
      http("request")
        .get("/")
    )

  setUp(
    scn
      .inject(
        atOnceUsers(vuserCount)
      ).protocols(httpProtocol)
  )
}
