# 🎨 Thumbnail Generator Backend

A lightning-fast Spring Boot application that transforms your YouTube thumbnails using cutting-edge AI technology. This backend service powers the SnapThumb platform, making professional-quality thumbnails accessible to everyone.

## ✨ Features

- 🎯 AI-powered thumbnail generation using Stable Diffusion/ControlNet
- 👤 Smart image processing with face detection and intelligent cropping
- 🔒 Enterprise-grade security with authentication and authorization
- ☁️ Seamless cloud storage integration with AWS S3
- 📚 Comprehensive RESTful API documentation

## 🛠️ Tech Stack

- ☕ Java 17
- 🌱 Spring Boot 3.3.5
- 🛡️ Spring Security
- 💾 Spring Data JPA
- 🐘 PostgreSQL (Production)
- 💿 H2 (Development/Testing)
- 🐳 Docker & Docker Compose
- ☁️ AWS S3
- 📝 OpenAPI/Swagger

## 🚀 Getting Started

### 📋 Prerequisites

- Java 17 or higher
- Maven
- Docker and Docker Compose (optional)

### 💻 Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/thumbnailgenerator.git
   cd thumbnailgenerator/backend
   ```

2. **Build the application:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

### 🐳 Docker Setup

Alternatively, use Docker for a containerized setup:

   ```bash
   docker-compose up -d
   ```

## 📚 API Documentation

API documentation is available via Swagger UI when the application is running:

http://localhost:8080/swagger-ui.html

## 🏗️ Project Structure

The application follows a clean/hexagonal architecture with:
- Domain layer: Core business logic and entities
- Application layer: Use cases and services
- Infrastructure layer: External systems integration (DB, S3, AI models)

## 📄 License

[Your License] - See LICENSE.md file for details