
run:
	@docker run --rm -it -p 8000:8000 -v ${PWD}:/docs squidfunk/mkdocs-material

build:
	@docker run --rm -it -v ${PWD}:/docs squidfunk/mkdocs-material build --strict

.PHONY: run, build
.EXPORT_ALL_VARIABLES:
