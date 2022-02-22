pipeline {

    agent {
        label 'SQA_AGENTS'
    }

    environment {
        RESULTADOSTAGE = '' 
        RESULTADOKEYJIRA = ''
        JIRASERVER = 'Jira Connect'
   }
    
    stages {
        
        stage('Clean Past Tests') {
            steps {
                bat 'gradle clean'
            }
        }
        
        stage('Excecute Test') {
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
    
    
    post {
          success {
            echo 'success..'          
              script {
                  if(JIRASERVER == 'JiraToken'){
                      echo 'ENTRO'
                  }
              }
          }
          failure {
            script {
                  if('Bug' == JIRA_ISSUE_SUMMARY.split(':')[0]){
                      echo 'codigo de comentario al bug'
                  }else{
                     def testIssue = [fields: [ project: [id: '10000'],
                                 summary: 'Bug: Error en la ejecucion de las pruebas del caso de prueba ' + JIRA_ISSUE_KEY,
                                 description: 'Se encuentra error en la ejecucion de las pruebas del caso de prueba ' + JIRA_ISSUE_KEY + ' adjunto evidencia de las pruebas.',
                                 issuetype: [name: 'Bug']]]
                      response = jiraNewIssue issue: testIssue, site: JIRASERVER
                      echo response.successful.toString()
                      echo response.data.toString()
                  }
              }
          }
          unsuccessful {
            echo 'unsuccessful..'
          }
    }
}
