# ConstructionXpert Services Part-5

## Table of Contents
1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Technology Stack](#technology-stack)
4. [Project Structure](#project-structure)
5. [Getting Started](#getting-started)
   - [Prerequisites](#prerequisites)
   - [Local Development](#local-development)
6. [CI/CD Pipeline](#cicd-pipeline)
7. [SonarQube Analysis](#sonarqube-analysis)
8. [Docker Images](#docker-images)
9. [Contributing](#contributing)
10. [License](#license)
11. [Contact](#contact)

## Project Overview
ConstructionXpert Services is a modern project management system designed for the construction industry. This repository contains the microservices architecture that powers our platform, along with CI/CD pipeline configurations for automated testing, quality assurance, and deployment.

## Features
- Microservices-based architecture for scalability and maintainability
- Automated CI/CD pipeline using Jenkins
- Unit testing integration for each microservice
- Code quality analysis with SonarQube
- Automated Docker image building and pushing to DockerHub

## Technology Stack
- Java (Spring Boot for microservices)
- Jenkins (CI/CD)
- SonarQube (Code quality analysis)
- Docker (Containerization)
- DockerHub (Container registry)
- Git (Version control)

## Getting Started

### Prerequisites
- Java JDK 11+
- Maven
- Docker
- Jenkins
- SonarQube

### Local Development
1. Clone the repository:
https://github.com/BAOUCHbaSalma/MicroServices-Backend-Part5.git
3. Navigate to the project directory:
cd ConstructionXpert-Services
4. Run the microservices locally:
5. ## CI/CD Pipeline

Our CI/CD pipeline is configured in Jenkins and performs the following steps:

1. Pulls the latest code from the main branch
2. Runs unit tests for each microservice
3. Performs code quality analysis with SonarQube
4. Builds Docker images for each microservice
5. Pushes Docker images to DockerHub

The pipeline is triggered automatically on each commit to the main branch.

### Pipeline Configuration

The Jenkins pipeline is defined in the `Jenkinsfile` located in the `jenkins/` directory. It includes the following stages:

1. **Checkout**: Retrieves the latest code from the Git repository.
2. **Build**: Compiles the code and runs unit tests.
3. **SonarQube Analysis**: Performs code quality analysis.
4. **Docker Build**: Creates Docker images for each microservice.
5. **Docker Push**: Pushes the built images to DockerHub.

### Jenkins Setup

To set up Jenkins for this project:

1. Install necessary Jenkins plugins (Git, Docker, SonarQube Scanner).
2. Configure Jenkins credentials for Git, DockerHub, and SonarQube.
3. Create a new Jenkins pipeline job pointing to the `Jenkinsfile` in your repository.
4. Set up webhook in GitHub to trigger the Jenkins job on each commit to the main branch.

## SonarQube Analysis

SonarQube is integrated into our CI/CD pipeline to ensure code quality. It analyzes:
- Code coverage
- Potential bugs
- Code smells
- Security vulnerabilities

The build will fail if it doesn't meet the defined quality gate criteria.
