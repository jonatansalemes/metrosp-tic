#!/bin/bash
read -p "Bot url base:\n" bot_url
read -p "Github username:\n" username
read -s -p "Github password:\n" password
docker build --rm --build-arg BOT_URL=$bot_url --build-arg GIT_USERNAME=$username --build-arg GIT_PASSWORD=$password -t jslsolucoes/metrosp-tic-bot:latest .