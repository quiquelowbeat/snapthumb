.PHONY: run run-debug build validate

# Running commands
run:
	docker-compose -f docker-compose.backend.yml up --build

run-debug:
	docker-compose -f docker-compose.backend.debug.yml up --build

# Building commands
build:
	@echo "\n🏗️ Building application..."
	@docker build -f backend/Dockerfile --target build -t thumbnailgenerator-build backend || \
		(echo "❌ Build failed!" && exit 1)
	@echo "✅ Build successful!"

# Validation commands
validate:
	@echo "\n📋 Running tests..."
	@docker build -f backend/Dockerfile --target test -t thumbnailgenerator-test backend || \
		(echo "❌ Tests failed!" && exit 1)
	@echo "✅ Tests passed successfully!"

	@echo "\n🔍 Running quality checks..."
	@docker build -f backend/Dockerfile --target quality -t thumbnailgenerator-quality backend || \
		(echo "❌ Quality checks failed!" && exit 1)
	@echo "✅ Quality checks passed!"

	@echo "\n✨ All validations passed successfully!"

help:
	@echo "\n📚 Available commands:"
	@echo "  make run         - Run the application"
	@echo "  make run-debug   - Run the application in debug mode"
	@echo "  make build       - Build the application"
	@echo "  make validate    - Run tests and quality checks"
	@echo "  make help        - Show this help message"
	@echo "\n"

