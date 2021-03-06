#!/bin/bash
read -p "Bot url base" bot_url
read -p "Github username: " username
read -s -p "Github password: " password
docker build --rm --build-arg BOT_URL=$bot_url --build-arg GIT_USERNAME=$username --build-arg GIT_PASSWORD=$password -t jslsolucoes/metrosp-tic-bot:latest .