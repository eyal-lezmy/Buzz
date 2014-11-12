package main.groovy.fr.eyal

import org.gradle.api.Project
import org.gradle.api.UnknownTaskException


class BuzzExtension {

    final Project project
    def buzzConfig = new Config()

    BuzzExtension(Project project) {
        this.project = project
    }

    void injectTasks() {
        def taskLaunch = project.buzz.config.taskLaunch

        try {
            //if the automatic launch is enable and the configuration is correct
            if (taskLaunch != null) {
                def theTask = project.tasks.getByName(taskLaunch)
                theTask.finalizedBy(BuzzGradlePlugin.TASK_BUZZ)
            }

        } catch (UnknownTaskException e) {
            println "Task $taskLaunch not found"
        }
    }

    def processConfiguration() {

    }

    def checkParams() {
    }
}