status:
	curl -s http://localhost:8080/status | jq

test:
	mvn test
