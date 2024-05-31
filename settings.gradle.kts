pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "UnidadResidencialAlameda181"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":aboutactivitymodule")
include(":ui")
include(":ScheduleModule")
include(":connect-gdrive")
include(":ServicesModule")
include(":alameda181-core")
include(":japl-android-graphs")
