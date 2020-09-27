package com.ngenia.gatling.simulations

import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder
import org.scalatest.{FlatSpec, Matchers}

class BasicSimulationTest extends FlatSpec with Matchers {
  val sim = Gatling.fromMap((new GatlingPropertiesBuilder)
    .simulationClass(classOf[ com.ngenia.gatling.simulations.BasicSimulation].getName)
    .build)
  it should "run without any exception" in {
    noException should be thrownBy sim
  }
}