FROM    golang AS builder
WORKDIR /goapp
COPY    hello.go .
RUN     go env -w GO111MODULE=auto
RUN     go build -o hello.out .

FROM    alpine AS runtime
WORKDIR /goapp
# COPY    --from=0 /goapp/hello.out .
COPY    --from=builder /goapp/hello.out .

ENTRYPOINT  [ "./hello.out" ]