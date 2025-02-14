FROM node:22.13.1 AS builder
ARG SPRINGBOOT_ADDRESS=localhost
ARG SPRINGBOOT_PORT=9090
# 환경 변수 설정
ENV VITE_REST_API_HOST=${SPRINGBOOT_ADDRESS}
ENV VITE_REST_API_PORT=${SPRINGBOOT_PORT}
WORKDIR /app
COPY frontend .
RUN npm install
RUN npm run build

FROM nginx
COPY --from=builder /app/dist /usr/share/nginx/html
