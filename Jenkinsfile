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
                script {
                    if('Bug' == JIRA_ISSUE_SUMMARY.split(':')[0]){
                          bat 'gradle test -Dcucumber.options="--tags @' + JIRA_ISSUE_SUMMARY.split('caso de prueba ')[1] +'"'
                    }else{
                         bat 'gradle test -Dcucumber.options="--tags @' + JIRA_ISSUE_KEY +'"'
                    }
                }
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
              echo JIRA_ISSUE_KEY
              script {
                  
                  jiraAssignableUserSearch issueKey: JIRA_ISSUE_KEY, project: 'PJ', queryStr: '', site: JIRASERVER
                  
                  def notify = [ subject: 'Update about TEST-01',
               textBody: 'Just wanted to update about this issue...',
               htmlBody: 'Just wanted to update about this issue...',
               to: [ reporter: true,
                     assignee: true,
                     watchers: false,
                     voters: false,
                     users: [{
                              name: 'Edgar Lemus'
                            }]
                   ]
              ]
                jiraNotifyIssue idOrKey: JIRA_ISSUE_KEY, notify: notify, site: JIRASERVER
                  
                  
                  if('Bug' == JIRA_ISSUE_SUMMARY.split(':')[0]){
                      def transitionInput =
                        [
                            transition: [
                                id: '31'
                            ]
                        ]
                      jiraTransitionIssue idOrKey: JIRA_ISSUE_KEY, input: transitionInput, site: JIRASERVER       
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
                      def ISSUE_NEW_KEY = response.data.toString()
                      echo ISSUE_NEW_KEY.split(', ')[1].split(':')[1]
                      jiraLinkIssues type: 'Relates', inwardKey: JIRA_ISSUE_KEY, outwardKey: ISSUE_NEW_KEY.split(', ')[1].split(':')[1], site: JIRASERVER
                  }
              }
          }
          unsuccessful {
            echo 'unsuccessful..'
          }
    }
}
