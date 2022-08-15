// https://github.com/xpdojo/cicd
pipeline {
    agent any

    environment {
        SLACK_CHANNEL = '#jenkins'
        TEAM_DOMAIN = 'markruler' // workspace
        CREDENTIAL_ID = 'jenkins-slack'// Credential ID
    }

    stages {
        stage('checkout') {
            steps {
                checkout(
                    [
                        $class: 'GitSCM',
                        branches: [[name: '*/main']],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [],
                        submoduleCfg: [],
                        userRemoteConfigs: [
                            [credentialsId: 'github-spring-hello-world', url: 'https://github.com/xpdojo/spring-hello-world.git']
                        ]
                    ]
                )
            }
        }
        stage('Hello') {
            steps {
                echo 'Hello World'
                sh 'ls -hal'
                sh 'cat ./README.md'
            }
        }
    }

    post {
        success {
            slackSend (
                color: '#00FF00',
                message: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})",
                teamDomain: TEAM_DOMAIN,
                channel: SLACK_CHANNEL,
                tokenCredentialId: CREDENTIAL_ID
            )
        }
        failure {
            slackSend (
                color: '#FF0000',
                message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})",
                teamDomain: TEAM_DOMAIN,
                channel: SLACK_CHANNEL,
                tokenCredentialId: CREDENTIAL_ID
            )
        }
    }
}
