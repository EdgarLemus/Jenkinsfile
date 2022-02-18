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
        stage('Deploy') {
            steps {
                
            }
        }
    }
}
