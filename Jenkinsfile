pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                 def testIssue = [fields: [ project: [key: 'PJ'],
                                summary: 'New JIRA Created from Jenkins.',
                                issuetype: [name: 'Bug']]]

    response = jiraNewIssue issue: testIssue, site: 'LOCAL'

    echo response.successful.toString()
    echo response.data.toString()
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
