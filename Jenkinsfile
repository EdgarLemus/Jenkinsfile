pipeline {

    agent {
        label 'SQA_AGENTS'
    }

    stages {
        stage('Test') {
            steps {
                bat 'gradle test'
            }
        }
        stage('save log build') {
            steps {
            script {
                    def logContent = Jenkins.getInstance()
                    .getItemByFullName(env.JOB_NAME)
                    .getBuildByNumber(
                    Integer.parseInt(env.BUILD_NUMBER))
                    .logFile.text
                    // copy the log in the job's own workspace
                    writeFile file: "buildlog.txt", text: logContent
                }
            }
        }
    }
}
