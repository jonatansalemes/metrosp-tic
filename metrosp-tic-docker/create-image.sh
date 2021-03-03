#!/bin/bash
read -p "Github username: " username
read -s -p "Github password: " password
docker build --rm --build-arg GIT_USERNAME=$username --build-arg GIT_PASSWORD=$password -t jslsolucoes/metrosp-tic-bot:latest .