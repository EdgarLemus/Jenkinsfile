pipeline {

    agent {
        label 'SQA_AGENTS'
    }

    environment {
        RESULTADOSTAGE = '' 
        RESULTADOKEYJIRA = ''
        JIRASERVER = 'JiraToken'
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
            echo 'failure..'
          }
          unsuccessful {
            echo 'unsuccessful..'
          }
    }
}
