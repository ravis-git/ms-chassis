package com.example.microservicechassisplugin.chassis

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin

/**
 * Created by ravipalakodeti on 8/21/17.
 */
class BasePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.repositories {
            mavenCentral()
        }

        project.buildscript.repositories {
            mavenCentral()
        }

        project.repositories{
            mavenCentral()
            mavenLocal()
        }

        project.apply plugin: JavaPlugin
        project.configure(project) {
            apply plugin: 'org.springframework.boot'
        }
//        addSpringBoot(project)
        addLombok(project)
        addPluginAsDependency(project)
    }


    private static void addLombok(Project project) {
        project.afterEvaluate {
            project.dependencies.add('compile', 'org.projectlombok:lombok:1.16.10')
        }
    }

    private addSpringBoot(Project project) {
        project.dependencies.add('compile', "org.springframework.boot:spring-boot-starter:1.5.6.RELEASE")
        project.dependencies.add('compile', "org.springframework.boot:spring-boot-starter-jersey:1.5.6.RELEASE")
    }

    private addPluginAsDependency(Project project) {
//        project.repositories.add(mavenLocal())
        project.dependencies.add('compile', 'com.example.microservicechassisplugin.chassis:ms-chassis:0.1.1-SNAPSHOT')
    }
}
