# build backend image
./backend/mvnw clean install -DskipTests -f backend/pom.xml
docker build -t backend-pagnet:latest ./backend

# build frontend image
docker build -t frontend-pagnet:latest ./frontend

# start environment
docker-compose up