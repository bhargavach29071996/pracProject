pipeline{
    agent{
        label "jenkins-agent"
    }
    tools {
        jdk 'Java17'
        maven 'Maven3'
    }
    Stages{
        stage("Cleanup Workspace"){
            Steps{
                CleanWs()
            }
        }
    }
    Stages{
        Stage("Checkout from SCM"){
            steps{
                git branch: 'main', credentialsID: 'github', url: 'https://github.com/bhargavach29071996/pracProject.git'
            }
        }
    }
}