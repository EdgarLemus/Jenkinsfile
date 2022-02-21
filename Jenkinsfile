pipeline {

    agent {
        label 'SQA_AGENTS'
    }

    stages {
        stage('Test') {
            steps {
                bat 'gradle test -Dcucumber.options="--tags @' + JIRA_ISSUE_KEY +'"'
            }
        }
        stage('save log build') {
            steps {
            script {
                    echo JIRA_ISSUE_KEY
                    echo JIRA_ISSUE_SUMMARY
                }
            }
        }
    }
}
