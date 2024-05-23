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
        maven(url = "https://artifactory-external.vkpartner.ru/artifactory/vkid-sdk-andorid/")
        mavenCentral()
    }
}

rootProject.name = "surprize_gift"
include(":app")
 