plugins {
    java
    application
}

repositories{
    mavenCentral()
}

dependencies{
    implementation(project(":server-http"))
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")

}