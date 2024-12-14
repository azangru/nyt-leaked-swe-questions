package service

import (
	"net/http"

	"github.com/nytm/ae"
)

func init() {
	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		w.Header().Set("Content-Type", "application/json; charset=utf8")
		ae.CORSHandler(http.StripPrefix("/", http.FileServer(http.Dir("data/"))), "").ServeHTTP(w, r)
	})
}
