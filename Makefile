.PHONY: build

build:
	docker build --no-cache --pull -t lukaszimmermann/pht-service:test .
