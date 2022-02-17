pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                jiraComment body: 'Hola mundo', issueKey: 'PJ-5'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
