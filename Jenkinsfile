/*
pipeline {
    agent any

    tools {
        maven 'mvn'
    }

    environment {
        DOCKERHUB_CREDENTIALS = credentials('docker-hub-credentials')
        SONARQUBE_TOKEN = 'squ_5374c50602e37c662976b7f8d2f0869689e7d45b'
        SONARQUBE_SERVER = 'http://localhost:9000'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'Change', url: 'https://github.com/BAOUCHbaSalma/MicroServices-Backend-Part5.git'
            }
        }

        stage('Build & Test Microservices') {
            parallel {
                stage('Build & Test user-service') {
                    steps {
                        dir('user-service') {
                            withMaven(maven: 'mvn') {
                                bat 'mvn clean package'
                            }
                        }
                    }
                }

                stage('Build & Test projet-service') {
                    steps {
                        dir('projet-service') {
                            withMaven(maven: 'mvn') {
                                bat 'mvn clean package'
                            }
                        }
                    }
                }

                stage('Build & Test tache-service') {
                    steps {
                        dir('tache-service') {
                            withMaven(maven: 'mvn') {
                                bat 'mvn clean package'
                            }
                        }
                    }
                }

                stage('Build & Test ressource-service') {
                    steps {
                        dir('ressource-service') {
                            withMaven(maven: 'mvn') {
                                bat 'mvn clean package'
                            }
                        }
                    }
                }

                stage('Build & Package gateway-service') {
                    steps {
                        dir('gateway-service') {
                            withMaven(maven: 'mvn') {
                                bat 'mvn clean package'
                            }
                        }
                    }
                }

                stage('Build & Test discovery-service') {
                    steps {
                        dir('discovery-service') {
                            withMaven(maven: 'mvn') {
                                bat 'mvn clean package'
                            }
                        }
                    }
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    def scannerHome = tool 'SonarQubeScanner'


                    dir('user-service') {
                        bat "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=user-service -Dsonar.sources=. -Dsonar.host.url=${SONARQUBE_SERVER} -Dsonar.login=${SONARQUBE_TOKEN} -Dsonar.java.binaries=target/classes"
                    }


                    dir('projet-service') {
                        bat "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=projet-service -Dsonar.sources=. -Dsonar.host.url=${SONARQUBE_SERVER} -Dsonar.login=${SONARQUBE_TOKEN} -Dsonar.java.binaries=target/classes"
                    }


                    dir('tache-service') {
                        bat "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=tache-service -Dsonar.sources=. -Dsonar.host.url=${SONARQUBE_SERVER} -Dsonar.login=${SONARQUBE_TOKEN} -Dsonar.java.binaries=target/classes"
                    }


                    dir('ressource-service') {
                        bat "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ressource-service -Dsonar.sources=. -Dsonar.host.url=${SONARQUBE_SERVER} -Dsonar.login=${SONARQUBE_TOKEN} -Dsonar.java.binaries=target/classes"
                    }


                    dir('gateway-service') {
                        bat "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=gateway-service -Dsonar.sources=. -Dsonar.host.url=${SONARQUBE_SERVER} -Dsonar.login=${SONARQUBE_TOKEN} -Dsonar.java.binaries=target/classes"
                    }


                    dir('discovery-service') {
                        bat "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=discovery-service -Dsonar.sources=. -Dsonar.host.url=${SONARQUBE_SERVER} -Dsonar.login=${SONARQUBE_TOKEN} -Dsonar.java.binaries=target/classes"
                    }
                }
            }
        }

        stage('Build Docker Images & Push') {
            parallel {
                stage('Build Docker & Push for user-service') {
                    steps {
                        dir('user-service') {
                            script {
                                def dockerImage = docker.build("salmaba/user-service:${env.TAG_VERSION ?: 'latest'}")
                                docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials') {
                                    dockerImage.push()
                                }
                            }
                        }
                    }
                }

                stage('Build Docker & Push for projet-service') {
                    steps {
                        dir('projet-service') {
                            script {
                                def dockerImage = docker.build("salmaba/projet-service:${env.TAG_VERSION ?: 'latest'}")
                                docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials') {
                                    dockerImage.push()
                                }
                            }
                        }
                    }
                }

                stage('Build Docker & Push for tache-service') {
                    steps {
                        dir('tache-service') {
                            script {
                                def dockerImage = docker.build("salmaba/tache-service:${env.TAG_VERSION ?: 'latest'}")
                                docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials') {
                                    dockerImage.push()
                                }
                            }
                        }
                    }
                }

                stage('Build Docker & Push for ressource-service') {
                    steps {
                        dir('ressource-service') {
                            script {
                                def dockerImage = docker.build("salmaba/ressource-service:${env.TAG_VERSION ?: 'latest'}")
                                docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials') {
                                    dockerImage.push()
                                }
                            }
                        }
                    }
                }

                stage('Build Docker & Push for gateway-service') {
                    steps {
                        dir('gateway-service') {
                            script {
                                def dockerImage = docker.build("salmaba/gateway-service:${env.TAG_VERSION ?: 'latest'}")
                                docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials') {
                                    dockerImage.push()
                                }
                            }
                        }
                    }
                }

                stage('Build Docker & Push for discovery-service') {
                    steps {
                        dir('discovery-service') {
                            script {
                                def dockerImage = docker.build("salmaba/discovery-service:${env.TAG_VERSION ?: 'latest'}")
                                docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials') {
                                    dockerImage.push()
                                }
                            }
                        }
                    }
                }
            }
        }

        stage('Deploy with Docker Compose') {
            steps {
                bat 'docker-compose up'
            }
        }
    }
}
 */
