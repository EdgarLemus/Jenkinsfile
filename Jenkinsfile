pipeline {

    agent {
        label 'SQA_AGENTS'
    }

    stages {
        stage('Build') {
            steps {
                git branch: 'main', url: 'https://github.com/EdgarLemus/Jenkinsfile.git'
            }
        }
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
