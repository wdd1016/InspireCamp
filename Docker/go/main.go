/* 8080 포트로 HTTP 요청을 대기하다가, /로 요청이 들어오면 Hello Docker!!!를 응답 */


/* 프로그램의 진입점인 main 패키지를 지정 */
package main


/* 표준 입출력과 문자열 형식을 처리하는 Go 패키지, 
   로그를 출력하기 위한 패키지, 
   HTTP 서버와 클라이언트 관련 기능을 제공하는 패키지를 임포트 */
import (
	"fmt"
	"log"
	"net/http"
)

func main() {
	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		log.Println("received request")
		fmt.Fprintf(w, "Hello Docker!!")
	})

	log.Println("start server")
	server := &http.Server{Addr: ":8080"}
	if err := server.ListenAndServe(); err != nil {
		log.Println(err)
	}
}
