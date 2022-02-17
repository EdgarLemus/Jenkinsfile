pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                def testIssue = [fields : [project: [id: '10000'],
                                                        summary: 'SQA Sinergia Tecnologica de Jira desde Jenkins con Banco Popular',
                                                        description: 'Realiza la integracion desde Jenkins mediante un Pipeline a Jira luego de ejecutar las pruebas.',
                                                        issuetype: [id: '10004']]]
                        response = jiraNewIssue issue: testIssue , site: 'Jira Connect'

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
