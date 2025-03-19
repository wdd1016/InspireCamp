./gradlew :user-service:build -x test
./gradlew :order-service:build -x test
./gradlew :catalog-service:build -x test

docker buildx build --platform linux/amd64,linux/arm64 --tag wdd1016/user-service:1.1 -f user-service/Dockerfile user-service --push
docker buildx build --platform linux/amd64,linux/arm64 --tag wdd1016/order-service:1.1 -f order-service/Dockerfile order-service --push
docker buildx build --platform linux/amd64,linux/arm64 --tag wdd1016/catalog-service:1.1 -f catalog-service/Dockerfile catalog-service --push

docker network create --driver bridge ecommerce-network
