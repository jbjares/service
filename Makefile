.PHONY: build build_dep

build:
	docker build -f Dockerfile --no-cache --pull --rm -t lukaszimmermann/pht-service:test .

builddep:
	docker build -f Dockerfile_builddep --no-cache --pull --rm -t lukaszimmermann/pht-service-builddep:latest .


