pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                 def testIssue = [fields: [ // id or key must present for project.
                               project: [id: '10000'],
                               summary: 'New JIRA Created from Jenkins.',
                               description: 'New JIRA Created from Jenkins.',
                               customfield_1000: 'customValue',
                               issuetype: [id: '3']]]

    response = jiraNewIssue issue: testIssue

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
