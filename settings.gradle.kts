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
include(":ui")
