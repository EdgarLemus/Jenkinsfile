pipeline {

    agent {
        label 'SQA_AGENTS'
    }

    stages {
        stage('Test') {
            steps {
                sh 'gradle test'
            }
        }
    }
}
