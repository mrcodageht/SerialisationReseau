rootProject.name = "SerialisationReseau"
include("server-http")
include("client-http")
include("client-tcp")
include("server-tcp")
include("server-tcp:main")
findProject(":server-tcp:main")?.name = "main"
include("server-tcp")
