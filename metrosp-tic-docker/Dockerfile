FROM ubuntu:20.04

RUN echo "Building Bot"

#packages
ENV DEBIAN_FRONTEND=noninteractive
RUN apt-get update --fix-missing
RUN apt-get install -y nodejs postgresql postgresql-contrib openjdk-8-jdk maven git supervisor npm dos2unix vim telnet python3 python3-pip
RUN pip3 install --upgrade pip

#pgsql
COPY pgsql /pgsql
RUN chmod +x /pgsql/*.sh
RUN dos2unix /pgsql/*.sh
RUN sed -i 's/port = 5432/port = 5433/' /etc/postgresql/12/main/postgresql.conf

#build frontend app
ARG GIT_USERNAME
ARG GIT_PASSWORD
ARG BOT_URL
COPY app /app
RUN chmod +x /app/*.sh
RUN dos2unix /app/*.sh
RUN git config --global http.sslVerify false
RUN git clone --depth 1 --single-branch --branch feature-rc4 https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/jslsolucoes/open-chatbot.git /opt/open-chatbot
RUN rm -rf /opt/open-chatbot/app/.env*
RUN npm install -g serve
RUN printf "REACT_APP_URL_BASE=${BOT_URL}/api/v1\nREACT_APP_BOT_ID=bots\nREACT_APP_LOCALE=pt_br\n" > /opt/open-chatbot/app/.env
RUN cd /opt/open-chatbot/app && npm install && npm run build

#build engine
RUN cd /opt/open-chatbot && mvn install

#build backend metrosp-tic api and bot
COPY api /api
RUN chmod +x /api/*.sh && dos2unix /api/*.sh
COPY bot /bot
RUN chmod +x /bot/*.sh && dos2unix /bot/*.sh


#force rebuild
ADD "https://www.random.org/cgi-bin/randbyte?nbytes=10&format=h" skipcache

RUN git clone --depth 1 --single-branch --branch main https://github.com/jslsolucoes/metrosp-tic /opt/metrosp-tic
RUN cd /opt/metrosp-tic && mvn install
COPY bot/env.properties /opt/metrosp-tic/metrosp-tic-bot/target/env.properties

#build ml
ENV FLASK_API_KEY 12345678
COPY ml /ml
RUN chmod +x /ml/*.sh && dos2unix /ml/*.sh
RUN pip3 install flask waitress textblob tensorflow
RUN python3 -c 'import nltk; nltk.download("punkt")'

#ports
EXPOSE 5000
EXPOSE 5001
EXPOSE 8080
EXPOSE 8081

#supervisor
COPY supervisord.conf /etc/supervisord.conf
CMD ["/usr/bin/supervisord"]
  
  