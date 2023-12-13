/*
 * *
 *  Created by Prada Calculator on 10/12/2023, 4:03 pm
 *  Copyright(c) $today.year.All rights reserved.
 *  Last modified 10/12/2023, 10:17 am
 * /
 */

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

rootProject.name = "projectzakat"
include(":app")
 