val ktorVersion: String  = "1.0.1"
val kotlinVersion: String  = "1.3.11"
val logbackVersion: String = "1.2.1"

plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.11")

    application
}

repositories {
    jcenter()
}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-gson:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
}

application {
    mainClassName = "com.packtpub.alumni.AppKt"
}
