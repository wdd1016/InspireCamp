docker container run -p 4406:3306 --name mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=springbootdb -e MYSQL_USER=springboot -e MYSQL_PASSWORD=password -v ./mysql_data:/var/lib/mysql mysql:8.0

cd backend
./gradlew clean build bootBuildImage -x test

cd ..
docker container run -p 9090:8080 --name springboot --link mysql:mysql backend:0.0.1-SNAPSHOT

docker image build --build-arg SPRINGBOOT_ADDRESS=localhost -t board-app:v3 .