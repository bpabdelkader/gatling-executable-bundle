#!/bin/sh

if type -p java; then
  echo "java found in PATH"
  JAVA=java
elif [[ -n "$JAVA_HOME" ]] && [[ -x "$JAVA_HOME/bin/java" ]];  then
  echo "java found in JAVA_HOME: $JAVA_HOME"
  JAVA="$JAVA_HOME/bin/java"
else
  echo "Java not found !!"
fi

JAR=`find -L ./lib -maxdepth 1 -type f -name "*.jar"`

if [ -z "$JAR" ]
then
  echo "JAR not found in ./lib directory !!!"
else
  echo "Executing $JAR ..."
fi

# Tracing classpath > -Dconfig.trace=loads"
USER_ARGS="-Dlogback.configurationFile=conf/logback.xml"
SIMIULATION_CLASS="-Dgatling.core.simulationClass=com.ngenia.gatling.simulations.BasicSimulation"

java \
	$USER_ARGS\
	$SIMIULATION_CLASS\
	-jar ${JAR}