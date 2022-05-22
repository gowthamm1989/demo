pipeline{

	
	
	agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
    }
   agent any
	environment {
		DOCKERHUB_CREDENTIALS=credentials('docker-hub-gow')
	}

	stages {

		stage('Build') {

			steps {
				sh 'docker build -t gmuniraju/assignment-1:latest .'
			}
		}

		stage('Login') {

			steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
		}

		stage('Push') {

			steps {
				sh 'docker push gmuniraju/assignment-1:latest'
			}
		}
	}

	post {
		always {
			sh 'docker logout'
		}
	}

}
