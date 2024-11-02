# Virtual threads demo application
This application demonstrates virtual threading in Spring Boot.

## Install Hey
Hey is used to generate some load on this application. Installation instructions are here: https://github.com/rakyll/hey?tab=readme-ov-file

## Run initial test with platform threads
Once you installed Hey, do the following:

1. Start the application by running the `ConferenceServiceApplication`
2. The application's Tomcat server has a maximum amount of 8 threads, and each request will take 2 seconds to complete.
3. Run `hey -n 32 -c 32 http://localhost:8080/conferences`
4. You will see that the majority of requests cannot be handled within 2 seconds, since the thread pool is exhausted.

## Enable virtual threading and re-run
1. Add a property `spring.threads.virtual.enabled=true` to the `application.properties`. This enables virtual threading in the Tomcat server.
2. Start the application by running the `ConferenceServiceApplication`
3. Run `hey -n 32 -c 32 http://localhost:8080/conferences` again.
4. Now all requests can be handled concurrently, resulting in a much faster throughput.

