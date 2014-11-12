package main.groovy.fr.eyal

/**
 * Created by eyal on 05/09/14.
 */
class Config {

    static final DEFAULT_ANCHOR_TASK = "test"

    def fromFile                //get the whole configuration from a file. The content get the priority to the .gradle file

    //task configs
    String taskLaunch = DEFAULT_ANCHOR_TASK     //define the task that launches the BUZZ
    boolean automaticLaunch = true               //enable or not the task injection
    int processTimeout = 300000                  //timeout for all the processes launched in command line
    boolean verbose = true                       //verbose mode
    boolean abortOnError = false                 //abort the task execution

}
