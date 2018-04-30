FROM circleci/android:api-26-alpha

USER circleci:circleci

WORKDIR /home/circleci/app/

RUN sudo apt-get update
RUN sudo apt-get install -y cowsay vim vim-common locales
RUN sudo apt-get clean

# Japanese Locale Settings
RUN sudo locale-gen ja_JP.UTF-8
ENV LANG ja_JP.UTF-8
ENV LC_CTYPE ja_JP.UTF-8
RUN sudo localedef -f UTF-8 -i ja_JP ja_JP.utf8

RUN mkdir -p $ANDROID_HOME/licenses
RUN echo y | android update sdk --no-ui --all --filter "build-tools-25.0.2"
RUN echo y | android update sdk --no-ui --all --filter "extra-android-m2repository,extra-google-m2repository"

ADD . /home/circleci/app/
RUN sudo chown circleci:circleci -R /home/circleci/app/
RUN echo > local.properties

ENV JVM_OPTS -Xmx3200m
#ENV KEY sA1EKahokT
#RUN openssl aes-256-cbc -d -in secret-env-cipher -k $KEY >> ~/.bashrc
#RUN source /home/circleci/.bashrc

RUN ./gradlew clean build
CMD echo "build ok"