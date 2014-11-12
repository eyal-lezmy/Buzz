package main.groovy.fr.eyal

import org.gradle.api.Plugin
import org.gradle.api.Project

class BuzzGradlePlugin implements Plugin<Project> {

    static final String PLUGIN_GROUP = "fr.eyal"
    static final String TASK_BUZZ = "buzz"

    void apply(Project project) {

        project.extensions.create('buzz', BuzzExtension, project);
        project.buzz.extensions.create('config', Config); //the extension name have to be different from the original nested element's name (receiver)

        project.task(TASK_BUZZ, type: BuzzTask){
            description 'Buzz task. Launch me and I will play for you :-)'
            group PLUGIN_GROUP
        }

        project.afterEvaluate {

            project.buzz.checkParams()

            project.buzz.injectTasks()

        }
    }
}