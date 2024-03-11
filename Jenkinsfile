pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Build the Project'
            }
        }
		stage('Test') {
            steps {
                echo 'Test is completed'
            }
        }
		stage('Deploy') {
            steps {
                echo 'Successfully Deployed'
            }
        }

    }
    post { 
        always { 
            emailext body: 'Please have a look for deployment of your project', subject: 'Deployment status', to: 'myutility.all@gmail.com'
        }
    }
}
