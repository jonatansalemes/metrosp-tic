aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 396182636964.dkr.ecr.us-east-1.amazonaws.com/jslsolucoes/metrosp-tic-bot
docker tag jslsolucoes/metrosp-tic-bot:latest 396182636964.dkr.ecr.us-east-1.amazonaws.com/jslsolucoes/metrosp-tic-bot:latest
docker push 396182636964.dkr.ecr.us-east-1.amazonaws.com/jslsolucoes/metrosp-tic-bot:latest