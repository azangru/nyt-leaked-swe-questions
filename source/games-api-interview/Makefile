all: build

# builds and runs the local server on port 8080.
run: _start-local-mysql build
	@export MYSQL_USER=petsdb; \
	export MYSQL_PW=$(MYSQL_PW); \
	export MYSQL_USER=$(MYSQL_USER); \
	export MYSQL_PORT=$(MYSQL_PORT); \
	export MYSQL_DB_NAME=$(MYSQL_DB_NAME); \
	export MYSQL_HOST_NAME=$(MYSQL_HOST_NAME); \
	./cmd/server/server;

build:
	@cd ./cmd/server; \
	go build .

_start-local-mysql:
	@echo "Attempting to start MySQL, if already started there will be an ignorable docker error...."; \
	export MYSQL_PWD=$(MYSQL_PW); \
	docker run --rm -p3306:3306 --name petsdb -d -e MYSQL_ROOT_PASSWORD=$(MYSQL_PW) mysql:5.7; \
	$(MAKE) wait-for-mysql; \
	$(MAKE) create-db; \
	$(MAKE) migrate; \

stop-local-mysql:
	@docker kill petsdb

db: create-db migrate

create-db:
	@export MYSQL_PWD=$(MYSQL_PW); \
	echo "Creating database..."; \
	mysql -u $(MYSQL_USER) -h $(MYSQL_HOST_NAME) -P $(MYSQL_PORT) -e 'CREATE DATABASE IF NOT EXISTS $(MYSQL_DB_NAME)'

drop-db:
	@export MYSQL_PWD=$(MYSQL_PW); \
	echo "Dropping database..."; \
	mysql -u $(MYSQL_USER) -h $(MYSQL_HOST_NAME) -P $(MYSQL_PORT) -e 'DROP DATABASE $(MYSQL_DB_NAME)'

_migrate_setup:
	@if [ -z "$$(which migrate)" ]; then echo "Installing migrate command..."; go install -tags mysql github.com/golang-migrate/migrate/cmd/migrate; fi

create-migration: _migrate_setup
	@if [ -z "$(NAME)" ]; then echo >&2 please set the name of the migration via the variable NAME; exit 2; fi
	@migrate -path ddl -database 'mysql://$(MYSQL_USER):$(MYSQL_PW)@tcp($(MYSQL_HOST_NAME):$(MYSQL_PORT))/$(MYSQL_DB_NAME)?multiStatements=true' create $(NAME)

migrate: _migrate_setup
	@echo "Running migrations..."
	@migrate -path ddl -database 'mysql://$(MYSQL_USER):$(MYSQL_PW)@tcp($(MYSQL_HOST_NAME):$(MYSQL_PORT))/$(MYSQL_DB_NAME)?multiStatements=true' up

test-migrations: _migrate_setup
	@migrate -path ddl -database 'mysql://$(MYSQL_USER):$(MYSQL_PW)@tcp($(MYSQL_HOST_NAME):$(MYSQL_PORT))/$(MYSQL_DB_NAME)?multiStatements=true' down
	@migrate -path ddl -database 'mysql://$(MYSQL_USER):$(MYSQL_PW)@tcp($(MYSQL_HOST_NAME):$(MYSQL_PORT))/$(MYSQL_DB_NAME)?multiStatements=true' up

wait-for-mysql:
	@echo "Waiting for MySQL..."
	@for i in $$(seq 1 20); do \
		mysql -u $(MYSQL_USER) -h $(MYSQL_HOST_NAME) -P $(MYSQL_PORT) -p$(MYSQL_PW) -e 'SELECT 1' >/dev/null 2>&1 && exit 0; \
		echo >&2 "mysql not ready, sleeping for 5 secs..."; \
		sleep 5; \
		done; \
		exit 2

MYSQL_DB_NAME ?= petsdb
MYSQL_USER ?= root
MYSQL_PW ?= rootpassword
MYSQL_PORT ?= 3306
MYSQL_HOST_NAME ?= 127.0.0.1
ENV ?= dev

.EXPORT_ALL_VARIABLES:
