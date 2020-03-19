plugins {
    kotlin("jvm") version "1.3.70"
    id("me.champeau.gradle.jmh") version "0.5.0"
    id("io.morethan.jmhreport") version "0.9.0"
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

jmh {
    jmhVersion = "1.23"

    fork = 2 // default is 5
    warmup = "3s" // default is 10s
    warmupIterations = 2 // default is 5
    iterations = 3 // default is 5
    timeOnIteration = "5s"

    duplicateClassesStrategy = DuplicatesStrategy.WARN
    resultFormat = "JSON"
}
