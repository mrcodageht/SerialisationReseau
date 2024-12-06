plugins {
    java
    application
}
repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":server-tcp"))
}