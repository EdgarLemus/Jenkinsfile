pipeline {
    agent any
    
    environment {
        RESULTADOSTAGE = '' 
        RESULTADOKEYJIRA = ''
        JIRASERVER = 'Jira Connect'
   }

    stages {
        stage('Build') {
        steps {
                script {
                    echo 'Resultado de stage get'
                    echo RESULTADOSTAGE
                    if(RESULTADOSTAGE == 'SUCCESS'){
                    
                    }else{
                            try{                           
                            def testIssue = [fields : [
                                                        project: [id: '10154'],
                                                        summary: 'Sinergia Tecnologica de Jira desde Jenkins con Banco Popular',
                                                        description: 'Realiza la integracion desde Jenkins mediante un Pipeline a Jira luego de ejecutar las pruebas.',
                                                        issuetype: [id: '10004']]]
                        response = jiraNewIssue issue: testIssue , site: JIRASERVER

                        echo response.successful.toString()
                        echo response.data.toString()
                        }catch (Exception e) {
                          echo 'Exception occurred: ' + e.toString()                          
                          RESULTADOSTAGE = currentBuild.result
                      }
                    }                       
                }
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
