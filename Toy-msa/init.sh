./gradlew :user-service:build -x test
./gradlew :order-service:build -x test
./gradlew :catalog-service:build -x test
./gradlew :service-discovery:build -x test
./gradlew :config-service:build -x test
./gradlew :apigateway-service:build -x test

docker buildx build --platform linux/amd64,linux/arm64 --tag wdd1016/user-service:1.1 -f user-service/Dockerfile user-service --push
docker buildx build --platform linux/amd64,linux/arm64 --tag wdd1016/order-service:1.1 -f order-service/Dockerfile order-service --push
docker buildx build --platform linux/amd64,linux/arm64 --tag wdd1016/catalog-service:1.1 -f catalog-service/Dockerfile catalog-service --push
docker buildx build --platform linux/amd64,linux/arm64 --tag wdd1016/service-discovery:1.1 -f service-discovery/Dockerfile service-discovery --push
docker buildx build --platform linux/amd64,linux/arm64 --tag wdd1016/config-service:1.1 -f config-service/Dockerfile config-service --push
docker buildx build --platform linux/amd64,linux/arm64 --tag wdd1016/apigateway-service:1.1 -f apigateway-service/Dockerfile apigateway-service --push

./gradlew clean

docker network create --driver bridge ecommerce-network
