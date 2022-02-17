pipeline {
    
    agent any

    environment {
        RESULTADOSTAGE = '' 
        RESULTADOKEYJIRA = ''
        JIRASERVER = 'Jira Connect'
   }
    stages {
        stage('Clean Past Tests') {
            steps {
                echo 'Building..'
            }
        }
        stage('Run tests') {
            steps {
                echo 'Building..'
            }
        }
        stage('JIRA Get Issue') {
            steps {
                script {
                    try {
                         def issue = jiraGetIssue idOrKey: 'PJ-5', site: JIRASERVER
                        RESULTADOSTAGE = 'SUCCESS'
                        RESULTADOKEYJIRA = issue.data.toString()                   
                      } catch (Exception e) {
                          echo 'Exception occurred: ' + e.toString()
                        RESULTADOSTAGE = 'FAILED'
                      }
                    
                    
                    echo 'Resultado de stage final get'
                    echo RESULTADOKEYJIRA
                }
            }
        }
        stage('JIRA Create Issue') {
            steps {
                script {
                    echo 'Resultado de stage get'
                    echo RESULTADOSTAGE
                    if(RESULTADOSTAGE == 'SUCCESS'){
                    
                    }else{
                            try{                           
                            def testIssue = [fields : [
                                                        project: [id: '10000'],
                                                        summary: 'SQA Sinergia Tecnologica de Jira desde Jenkins con Banco Popular',
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
         stage('JIRA Comment Issue') {
            steps {
                script {
                    echo 'Resultado de stage create'
                    echo RESULTADOSTAGE
                    if(RESULTADOSTAGE == 'SUCCESS'){
                      try{
                      def comment = [ 
                        body: 'test comment'
                      ]
                      jiraAddComment site: JIRASERVER, idOrKey: RESULTADOKEYJIRA.split(',')[11].split(':')[1], input: comment
                    }catch (Exception e) {
                          echo 'Exception occurred: ' + e.toString()                          
                          RESULTADOSTAGE = currentBuild.result
                      } 
                    } 
                }
            }
         }
    }
    post {
          success {
            echo 'success..'            
          }
          failure {
            echo 'failure..'
          }
          unsuccessful {
            echo 'unsuccessful..'
          }
    }
}
