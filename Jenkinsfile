pipeline {

    agent {
        label 'SQA_AGENTS'
    }

    stages {
        stage('Test') {
            steps {
                bat 'gradle test --test  ** -t @' + JIRA_ISSUE_KEY
            }
        }
        stage('save log build') {
            steps {
            script {
                    echo JIRA_ISSUE_KEY
                }
            }
        }
    }
}
